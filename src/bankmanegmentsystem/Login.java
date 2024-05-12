
package bankmanegmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import java.sql.SQLException;
import java.sql.*;



public class Login extends JFrame implements ActionListener{
    
    JButton singup,singin,clear;
    JTextField t1;
    JPasswordField p1;
    
    Login(){
        
        //turn off the deafult layout
        setLayout(null);
        
        //                     [module 1]
        
        
        //                add bank logo 
        
        //catch the logo from the system
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        //scale the image
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        //convert the scaled image into imageicon class object so that it will used by JLable
        ImageIcon i3 = new ImageIcon(i2);
        //convet the logo into lable
        JLabel label = new JLabel(i3);
        //set lable location(but location will be changed after set defult layout off
        label.setBounds(170,50,100,100);
        add(label);
        
        //add wellcome label
        JLabel text=new JLabel("WELLCOME TO ATM");
        text.setFont(new Font("Arial",Font.BOLD,40));
        text.setBounds(290,50,400,100);
        add(text);
        
        
        
        //                     [module 2]
        
        
        
        //add card no: label
        JLabel cardNo = new JLabel("CARD NO :");
        cardNo.setFont(new Font("Raleway",Font.BOLD,30));
        cardNo.setBounds(250,210,200,30);
        add(cardNo);
        //add textfield for card no
        t1=new JTextField();
        t1.setBounds(440,211,200,30);
        t1.setFont(new Font("Arial",Font.BOLD,18));
        add(t1);
        //add pin label
        JLabel pin = new JLabel("PIN NO     :");
        pin.setFont(new Font("Raleway",Font.BOLD,30));
        pin.setBounds(250,290,200,30);
        add(pin);
        //add textfield for pin
        p1=new JPasswordField();
        p1.setBounds(440,291,200,30);
        p1.setFont(new Font("Arial",Font.BOLD,18));
        add(p1);
        
        
        
        //                 [module 3]
        
        
        
        //                 add buttons
        
        // 1.singin button
        singin=new JButton("SIGN IN");
        singin.setBounds(440,340,80,30);
        singin.setBackground(BLACK);
        singin.setForeground(WHITE);
        singin.addActionListener(this);//targrts the button
        add(singin);
        
        //2.clear button
        clear=new JButton("CLEAR");
        clear.setBounds(560,340,80,30);
        clear.setBackground(BLACK);
        clear.setForeground(WHITE);
        clear.addActionListener(this);//targrts the button
        add(clear);
        
        //3.sign up
        singup=new JButton("SIGN UP");
        singup.setBounds(440,390,200,30);
        singup.setBackground(BLACK);
        singup.setForeground(WHITE);
        singup.addActionListener(this);//targrts the button
        add(singup);
        
        getContentPane().setBackground(WHITE);
        //create the frame[module 1]
        setTitle("AUTOMETED TAILER MACHINE");
        // create a frame ,paarameters:higith,width
        setSize(1000,600);
        setVisible(true);
        setLocation(250,150);  
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        //                action performed for clear butto
        if(ae.getSource() == clear)
        {
            t1.setText("");
            p1.setText("");
        }
        
        //                action performed for signin button
        else if(ae.getSource() == singin)
        {
            // creating connection
            Conn login_conn = new Conn();
            // get card no and pin from the text fiels
            String card_no = t1.getText().trim();
            String pin_no= p1.getText().trim();
            // prepare query
            if(card_no.equals("") || card_no.equals(" "))
            {
                JOptionPane.showMessageDialog(null, "Please fill the card no" , "INVALID" , JOptionPane.WARNING_MESSAGE);
                return;
            }
            else if(pin_no.equals("") || pin_no.equals(" "))
            {
                JOptionPane.showMessageDialog(null, "Please fill the pin no" , "INVALID" , JOptionPane.WARNING_MESSAGE);
                return;
            }
            else
            {
                String query = "select * from login where card_no = '"+card_no+ "' and pin_no = '"+pin_no+"'";
                //save user data and redirect to next page
                try {
                    // ResultSet class is used to save user data into an object
                    ResultSet user_data = login_conn.s1.executeQuery(query);
                    if(user_data.next())
                    {
                        //fetch account balance of user from database
                        String user_balance = user_data.getString("balance");
                        setVisible(false);
                        //redirct to Transaction page
                        new Transactions(pin_no , user_balance , card_no).setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Incorrect Card no or Pin no" , "INVALID" , JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
        
        //                    action performed for signup button
        else if(ae.getSource() == singup)
        {
            //swithch to signuppage1
            setVisible(false);
            new SignupPage1().setVisible(true);
        }
    }
    
    //logic for validating adhar no
    public static boolean valCardNo(String card_no)
    {
        return card_no.length() == 16 && card_no.matches("[0-9]+");
    }
    
    public static boolean valPinNo(String pin_no)
    {
        return pin_no.length() == 4 && pin_no.matches("[0-9]+");
    }
    
    
    public static void main(String args[])
    {
        //annoymous function call by constuctor
        new Login();
    }
}
