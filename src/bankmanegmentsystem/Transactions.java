
package bankmanegmentsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton diposit,fast_cash,pin_change,withdrawl,mini_statements,balance,exit;
    String pin_no,card_no;
    int BALANCE;
    
    Transactions(String pin_no , String acc_balance , String card_no)
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
        JLabel text = new JLabel("Please sellect your transaction");
        text.setBounds(230,260,500,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,20));
        atm_image.add(text);
        
        //             add buttons
        
        //for diposit
        diposit = new JButton("Diposit");
        diposit.setBounds(180,320,180,25);
        diposit.setFont(new Font("Arial",Font.BOLD,15));
        diposit.setBackground(Color.WHITE);
        diposit.setForeground(Color.BLACK);
        diposit.addActionListener(this);
        atm_image.add(diposit);
        
        //for fast_cash
        fast_cash = new JButton("Fast cash");
        fast_cash.setBounds(180,355,180,25);
        fast_cash.setFont(new Font("Arial",Font.BOLD,15));
        fast_cash.setBackground(Color.WHITE);
        fast_cash.setForeground(Color.BLACK);
        fast_cash.addActionListener(this);
        atm_image.add(fast_cash);
        
        //for pin change
        pin_change = new JButton("Pin change");
        pin_change.setBounds(180,390,180,25);
        pin_change.setFont(new Font("Arial",Font.BOLD,15));
        pin_change.setBackground(Color.WHITE);
        pin_change.setForeground(Color.BLACK);
        pin_change.addActionListener(this);
        atm_image.add(pin_change);
        
        //for cash withdrawl
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(385,320,180,25);
        withdrawl.setFont(new Font("Arial",Font.BOLD,15));
        withdrawl.setBackground(Color.WHITE);
        withdrawl.setForeground(Color.BLACK);
        withdrawl.addActionListener(this);
        atm_image.add(withdrawl);
        
        //for mini statement
        mini_statements = new JButton("Mini Statements");
        mini_statements.setBounds(385,355,180,25);
        mini_statements.setFont(new Font("Arial",Font.BOLD,15));
        mini_statements.setBackground(Color.WHITE);
        mini_statements.setForeground(Color.BLACK);
        mini_statements.addActionListener(this);
        atm_image.add(mini_statements);
        
        //for Balance enquiry
        balance = new JButton("Balance enquiry");
        balance.setBounds(385,390,180,25);
        balance.setFont(new Font("Arial",Font.BOLD,15));
        balance.setBackground(Color.WHITE);
        balance.setForeground(Color.BLACK);
        balance.addActionListener(this);
        atm_image.add(balance);
        
        // for exit
        exit = new JButton("Exit");
        exit.setBounds(385,425,180,25);
        exit.setFont(new Font("Arial",Font.BOLD,15));
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        atm_image.add(exit);
        
        
        
        
        //             deploy the frame
        
        getContentPane().setBackground(Color.WHITE);
        setSize(1000,800);
        setLocation(250,10);
        setUndecorated(true);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       
        if(ae.getSource() == diposit)
        {
            //redirect to diposite page
            setVisible(false);
            new Diposit(pin_no , Integer.toString(BALANCE) , card_no).setVisible(true);
        }
        else if(ae.getSource() == fast_cash)
        {
            //redirect to fast cash page
            setVisible(false);
            new Fast_cash(pin_no,Integer.toString(BALANCE) , card_no).setVisible(true);
        }
        else if(ae.getSource() == pin_change)
        {
            setVisible(false);
            new Pin_change(pin_no , Integer.toString(BALANCE) , card_no).setVisible(true);
            
        }
        else if(ae.getSource() == withdrawl)
        {
            //redirect to Withdrawl page
            setVisible(false);
            new Widthrawl(pin_no , Integer.toString(BALANCE) , card_no).setVisible(true);
        }
        else if(ae.getSource() == balance)
        {
            setVisible(false);
            new Balance_inq(pin_no , Integer.toString(BALANCE) , card_no).setVisible(true);
        }
        else if(ae.getSource() == mini_statements)
        {
            new Mini_statements(pin_no , Integer.toString(BALANCE) , card_no).setVisible(true);
        }
        else if(ae.getSource() == exit)
        {
            System.exit(0);
        }
    }
    
    public static void main(String args[])
    {
        new Transactions("","","");
    }

    
}
