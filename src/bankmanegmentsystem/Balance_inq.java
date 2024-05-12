
package bankmanegmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Balance_inq extends JFrame implements ActionListener{
    
    int BALANCE;
    String card_no,pin_no;
    JButton back;
    
    Balance_inq(String pin_no , String balance , String card_no)
    {
        BALANCE = Integer.parseInt(balance);
        this.card_no = card_no;
        this.pin_no = pin_no;
        
        setLayout(null);
        
        
        
        
        
        //                      [module 1]
        
        
        
        
         //                 add atm image
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atm_image = new JLabel(i3);
        atm_image.setBounds(0, 0, 1000, 800);
        add(atm_image);
        
        
        
        
        //                       [module 2] 
        
        
        
        
        //add text for info
        JLabel text = new JLabel("Balance enquiry");
        text.setBounds(292,260,500,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,20));
        atm_image.add(text);
        
        //add 2nd text
        JLabel text2 = new JLabel("Your account balance is  :-");
        text2.setBounds(200,310,500,25);
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("System",Font.BOLD,25));
        atm_image.add(text2);
        
        
        //add lable for display amount
        JLabel text3 = new JLabel("Rs :"+Integer.toString(BALANCE));
        text3.setBounds(292,370,500,35);
        text3.setForeground(Color.WHITE);
        text3.setFont(new Font("System",Font.BOLD,35));
        atm_image.add(text3);
        
        
        
        //add back button
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
       
        if(e.getSource() == back)
        {
            setVisible(false);
            new Transactions(pin_no , Integer.toString(BALANCE) , card_no).setVisible(true);
        }
    }
    
    
    
    
    public static void main(String args[])
    {
        new Balance_inq("","","");
    }

}
