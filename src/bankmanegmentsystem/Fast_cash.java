
package bankmanegmentsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class Fast_cash extends JFrame implements ActionListener{
    
    JButton rs_100,rs_500,rs_1000,rs_2000,rs_5000,rs_10000,back;
    String pin_no,card_no;
    int BALANCE;
    
    Fast_cash(String pin_no, String acc_balance ,String card_no)
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
        JLabel text = new JLabel("    Please select the amount");
        text.setBounds(230,260,500,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,20));
        atm_image.add(text);
        
        //             add buttons
        
        //for rs_100
        rs_100 = new JButton("rs_100");
        rs_100.setBounds(180,320,180,25);
        rs_100.setFont(new Font("Arial",Font.BOLD,15));
        rs_100.setBackground(Color.WHITE);
        rs_100.setForeground(Color.BLACK);
        rs_100.addActionListener(this);
        atm_image.add(rs_100);
        
        //for rs_500
        rs_500 = new JButton("rs_500");
        rs_500.setBounds(180,355,180,25);
        rs_500.setFont(new Font("Arial",Font.BOLD,15));
        rs_500.setBackground(Color.WHITE);
        rs_500.setForeground(Color.BLACK);
        rs_500.addActionListener(this);
        atm_image.add(rs_500);
        
        //for rs_1000
        rs_1000 = new JButton("rs_1000");
        rs_1000.setBounds(180,390,180,25);
        rs_1000.setFont(new Font("Arial",Font.BOLD,15));
        rs_1000.setBackground(Color.WHITE);
        rs_1000.setForeground(Color.BLACK);
        rs_1000.addActionListener(this);
        atm_image.add(rs_1000);
        
        //for rs_2000
        rs_2000 = new JButton("rs_2000");
        rs_2000.setBounds(385,320,180,25);
        rs_2000.setFont(new Font("Arial",Font.BOLD,15));
        rs_2000.setBackground(Color.WHITE);
        rs_2000.setForeground(Color.BLACK);
        rs_2000.addActionListener(this);
        atm_image.add(rs_2000);
        
        // for rs_5000
        rs_5000 = new JButton("rs_5000");
        rs_5000.setBounds(385,355,180,25);
        rs_5000.setFont(new Font("Arial",Font.BOLD,15));
        rs_5000.setBackground(Color.WHITE);
        rs_5000.setForeground(Color.BLACK);
        rs_5000.addActionListener(this);
        atm_image.add(rs_5000);
        
        //for rs_10000
        rs_10000 = new JButton("rs_10000");
        rs_10000.setBounds(385,390,180,25);
        rs_10000.setFont(new Font("Arial",Font.BOLD,15));
        rs_10000.setBackground(Color.WHITE);
        rs_10000.setForeground(Color.BLACK);
        rs_10000.addActionListener(this);
        atm_image.add(rs_10000);
        
        //for back
        back = new JButton("Back");
        back.setBounds(385,425,180,25);
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
    public void actionPerformed(ActionEvent ae) {
       
        if(ae.getSource() == back)
        {
            setVisible(false);
            new Transactions(pin_no , Integer.toString(BALANCE) , card_no).setVisible(true);
        }
        else
        {
            //method for dynamicly method handeling for all fast cash buttons
            
            // gettint the text upon the button(rs 500 = only 500 will store into fast_cash_amount variable)
            String fast_cash_amount = ((JButton) ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            //String query = "select * from bank where pin_no = '"+this.pin_no+"'";   ***********
            
            try {
                
                
                
                
                /*
                //fetch data from the table into user_data object
                ResultSet user_data = conn.s1.executeQuery(query);
                //variable for store total amount
                int total_balence = 0;
                //check one by one entries with the help of a loop
                while(user_data.next())                                           [un used portion]
                {
                    if(!user_data.getString("type").equals("diposit"))
                    {
                        total_balence += Integer.parseInt(user_data.getString("amount"));
                    }
                    else {
                        total_balence -= Integer.parseInt(user_data.getString("amount"));
                    }
                }
                */     
                
                
                
                //System.out.println(fast_cash_amount);
                // this condition for when balence is lower then widthrawl amount
                if(ae.getSource() != back && BALANCE < Integer.parseInt(fast_cash_amount))
                {
                    JOptionPane.showMessageDialog(null,"Insufficent Balance" );
                    return;
                }
                else
                {
                    // make entry for fast cash widthrawl into bank table
                    Date date = new Date();
                    String query2 = "insert into bank values('"+pin_no+"','"+date+"','widthraw','"+fast_cash_amount+"')";
                    conn.s1.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"rs :"+fast_cash_amount+"Widthrawl sucessful" );
                    
                    //manage balance in login table
                    BALANCE -= Integer.parseInt(fast_cash_amount);
                    String query3 = "update login set balance = '"+Integer.toString(BALANCE)+"' where pin_no = '"+pin_no+"'";
                    conn.s1.executeUpdate(query3);
                }

                //redirect io transactions page
                setVisible(false);
                new Transactions(pin_no , Integer.toString(BALANCE) , card_no).setVisible(true);
                
            } catch (SQLException ex) {
               
                System.out.println(ex);
            }
            
        }
        
    }
    
    public static void main(String args[])
    {
        new Fast_cash("","","");
    }

    
}

