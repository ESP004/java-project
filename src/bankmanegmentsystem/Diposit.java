
package bankmanegmentsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import java.util.*;


public class Diposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton diposit,back;
    String pin_no,card_no;
    int BALANCE;
    
    Diposit(String pin_no , String balance , String card_no)
    {
        BALANCE = Integer.parseInt(balance);
        this.card_no = card_no;
        setLayout(null);
        this.pin_no = pin_no;
        
        
        //                [module 1]
        
        
         //             add atm image
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atm_image = new JLabel(i3);
        atm_image.setBounds(0, 0, 1000, 800);
        add(atm_image);
        
        
        //                 [module 2]
        
        
        
        //add text for info
        JLabel text = new JLabel("Enter the amount you want to diposit");
        text.setBounds(192,260,500,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,20));
        atm_image.add(text);
        
        //add text field for amount
        amount= new JTextField();
        amount.setFont(new Font("Arial",Font.BOLD,15));
        amount.setBounds(192,310,345,25);
        atm_image.add(amount);
        
        
        
        //                [module 3]
        
        //add Diposit button
        diposit = new JButton("Diposit");
        diposit.setBounds(397, 380, 140, 25);
        diposit.setBackground(Color.WHITE);
        diposit.setForeground(Color.BLACK);
        diposit.setFont(new Font("Arial",Font.BOLD,20));
        diposit.addActionListener(this);
        atm_image.add(diposit);
        
        //cancle button
        back = new JButton("Back");
        back.setBounds(397, 430, 140, 25);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Arial",Font.BOLD,20));
        back.addActionListener(this);
        atm_image.add(back);
        
        //             deploy the frame
        
        getContentPane().setBackground(Color.WHITE);
        setSize(1000,800);
        setLocation(250,10);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String diposit_amount = amount.getText().trim();
        Date date = new Date();
        
        //action performed on diposit button
        if(ae.getSource() == diposit)
        {
            //apply validation
            if(diposit_amount.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter a amount");
            }
            else
            {
                try 
                {
                    if(!valNum(diposit_amount))
                    {
                        JOptionPane.showMessageDialog(null,"Only digits are allowed for this field" , "INVALID" , JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    else if(Integer.parseInt(diposit_amount) == 0)
                    {
                        JOptionPane.showMessageDialog(null,"Invalid amount" , "INVALID" , JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    BALANCE += Integer.parseInt(diposit_amount);
                    Conn diposit_conn = new Conn();
                    String query = "insert into bank values('"+pin_no+"','"+date+"','diposit','"+diposit_amount+"')";
                    // update balence into login table
                    String query2 = "update login set balance = '"+Integer.toString(BALANCE)+"' where pin_no = '"+pin_no+"'";
                    diposit_conn.s1.executeUpdate(query);
                    diposit_conn.s1.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"rs:"+diposit_amount+" Diposited Sucessfull");
                    
                    //redirect io transactions page
                    setVisible(false);
                    new Transactions(pin_no,Integer.toString(BALANCE) , card_no).setVisible(true);
                } 
                catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
        else if(ae.getSource() == back)
        {
            //redirect io transactions page
            setVisible(false);
            new Transactions(pin_no,Integer.toString(BALANCE) , card_no).setVisible(true);
            
        }
    }
    
    //logic for validating number only
    public static boolean valNum(String input)
    {
        return input.matches("[0-9]+");
    }
    
    public static void main(String args[])
    {
        new Diposit("","","");
    }

   
}
