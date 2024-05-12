
package bankmanegmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;



public class Pin_change extends JFrame implements ActionListener{
    
    JPasswordField new_pin, rentered_pin;
    String pin_no,card_no;
    JButton back,change;
    int BALANCE;
    
    Pin_change(String pin_no , String acc_balance , String card_no)
    {
        this.BALANCE = Integer.parseInt(acc_balance);
        this.pin_no = pin_no;
        this.card_no = card_no;
        setLayout(null);
        
        
         //                  [module 1]
        
        
        //             add atm image
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atm_image = new JLabel(i3);
        atm_image.setBounds(0, 0, 1000, 800);
        add(atm_image);
        
        
        
        
        //                  [module 2]
        
        
        
        // add upper text
        JLabel text = new JLabel("          Change your PIN");
        text.setBounds(230,260,500,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,20));
        atm_image.add(text);
        
        //add lable for new pin
        JLabel new_pin_lable = new JLabel("New PIN :");
        new_pin_lable.setBounds(192,300,150,20);
        new_pin_lable.setForeground(Color.WHITE);
        new_pin_lable.setFont(new Font("System",Font.BOLD,20));
        atm_image.add(new_pin_lable);
        
        //add textfield for pin
        new_pin= new JPasswordField();
        new_pin.setFont(new Font("Arial",Font.BOLD,15));
        new_pin.setBounds(342,300,205,25);
        atm_image.add(new_pin);
        
        //add lable for re enter pin
        JLabel reenter_pin_lable = new JLabel("Reenter PIN :");
        reenter_pin_lable.setBounds(192,340,150,20);
        reenter_pin_lable.setForeground(Color.WHITE);
        reenter_pin_lable.setFont(new Font("System",Font.BOLD,20));
        atm_image.add(reenter_pin_lable);
        
        //add textfield for reentered pin
        rentered_pin= new JPasswordField();
        rentered_pin.setFont(new Font("Arial",Font.BOLD,15));
        rentered_pin.setBounds(342,340,205,25);
        atm_image.add(rentered_pin);
        
        
        
        //                 [module 3]
        
        
         
        //add change button
        change = new JButton("Change");
        change.setBounds(407, 390, 140, 25);
        change.setFont(new Font("Arial",Font.BOLD,15));
        change.setBackground(Color.WHITE);
        change.setForeground(Color.BLACK);
        change.addActionListener(this);
        atm_image.add(change);
        
        // add back button
        back = new JButton("Back");
        back.setBounds(407, 435, 140, 25);
        back.setFont(new Font("Arial",Font.BOLD,15));
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
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
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == change)
        {
            String first_new_pin = this.new_pin.getText();
            String reentered_pin = this.rentered_pin.getText();
            
            if(first_new_pin.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter new pin");
                return;
            }
            
            if(reentered_pin.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Re-enter new pin");
                return;
            }
            
            if(first_new_pin.equals(reentered_pin))
            {
                try{
                    Conn conn = new Conn();
                    //prepere query to update pin no to all tables
                    String query = "update login set pin_no = '"+first_new_pin+"' where card_no = '"+card_no+"'";
                    String query2 = "update signupthree set pin_no = '"+first_new_pin+"' where card_no = '"+card_no+"'";
                    String query3 = "update bank set pin_no = '"+first_new_pin+"' where pin_no = '"+pin_no+"'";
                    conn.s1.executeUpdate(query);
                    conn.s1.executeUpdate(query2);
                    conn.s1.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null, "Pin change sucessfully");
                    // redirect to transaction page
                    setVisible(false);
                    new Transactions(first_new_pin , Integer.toString(BALANCE) , card_no).setVisible(true);
                    
                }catch(HeadlessException | SQLException ex){
                    System.out.println(e);
                }
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Both pin are dose not match");
                return;
            }
        }
        else if(e.getSource() == back)
        {
            setVisible(false);
            new Transactions(pin_no , Integer.toString(BALANCE) , card_no).setVisible(true);
        }
       
    }
    
    
    
    
    public static void main(String args[])
    {
       new Pin_change(null,null,"");
        
    }

    
}
