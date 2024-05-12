
package bankmanegmentsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class SignupPage3 extends JFrame implements ActionListener{
    
    String fromno,acc_holder_name;
    JRadioButton r1,r2,r3,r4;
    JCheckBox j1,j2,j3,j4,j5,j6,j7;
    JButton submit,cancle;
    int BALANCE = 0;
    
    SignupPage3(String fromno, String name)
    {
        
        //                         [module 1]
        
        this.acc_holder_name = name;
        this.fromno = fromno;
        setLayout(null);
        //add from no lable
        JLabel from_no = new JLabel("From no."+this.fromno);
        from_no.setBounds(850, 5, 170, 20);
        from_no.setFont(new Font("Arial",Font.BOLD,15));
        add(from_no);
        
        //                      add bank logo
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel logo = new JLabel(i3);
        logo.setBounds(180, 30, 100, 100);
        add(logo);
        
        //                       add page 3 lable
        
        JLabel page3 = new JLabel("PAGE 2 : ACCOUNT DETAILS");
        page3.setBounds(320,60,600,50);
        page3.setFont(new Font("Arial",Font.BOLD,30));
        add(page3);
        
        
        //                    [module 2]
        
        
        //                  add label for account type
        
        JLabel ac = new JLabel("ACCOUNT TYPE :");
        ac.setBounds(200,160,400,40);
        ac.setFont(new Font("Arial",Font.BOLD,25));
        add(ac);
        
        //              add radio buttons for account type
        
        
        //savings account
        r1 = new JRadioButton("Savings account");
        r1.setBounds(220, 220, 250, 20);
        r1.setFont(new Font("Arial",Font.BOLD,20));
        r1.setBackground(Color.white);
        r1.setForeground(Color.BLACK);
        r1.addActionListener(this);
        add(r1);
        //current account
        r2 = new JRadioButton("Current account");
        r2.setBounds(220, 260, 250, 20);
        r2.setFont(new Font("Arial",Font.BOLD,20));
        r2.setBackground(Color.white);
        r2.setForeground(Color.BLACK);
        r2.addActionListener(this);
        add(r2);
        //reckring deposit account
        r3 = new JRadioButton("Recurring Deposit account");
        r3.setBounds(470, 220, 300, 20);
        r3.setFont(new Font("Arial",Font.BOLD,20));
        r3.setBackground(Color.white);
        r3.setForeground(Color.BLACK);
        r3.addActionListener(this);
        add(r3);
        //fixed diposit account
        r4 = new JRadioButton("Fixed Diposit account");
        r4.setBounds(470, 260, 300, 20);
        r4.setFont(new Font("Arial",Font.BOLD,20));
        r4.setBackground(Color.white);
        r4.setForeground(Color.BLACK);
        r4.addActionListener(this);
        add(r4);
        
        ButtonGroup AC_type = new ButtonGroup();
        AC_type.add(r1);
        AC_type.add(r2);
        AC_type.add(r3);
        AC_type.add(r4);
        
        
        
        //                              [module 3]
        
        
        //                      add label for card no
        
        JLabel cardno = new JLabel("CARD NO :");
        cardno.setBounds(220, 330, 200, 30);
        cardno.setFont(new Font("Arial",Font.BOLD,25));
        add(cardno);
        
        //                     add label for demo card no
        
        JLabel demo_cardno = new JLabel("XXXX-XXXX-XXXX-4321");
        demo_cardno.setBounds(470, 330, 350, 30);
        demo_cardno.setFont(new Font("Arial",Font.BOLD,25));
        add(demo_cardno);
        
        //                     add label for pin no
        
        JLabel pinno = new JLabel("CARD NO :");
        pinno.setBounds(220, 370, 200, 30);
        pinno.setFont(new Font("Arial",Font.BOLD,25));
        add(pinno);
        
        //                    add label for demo pin no
        
        JLabel demo_pinno = new JLabel("XXXX");
        demo_pinno.setBounds(470, 370, 250, 30);
        demo_pinno.setFont(new Font("Arial",Font.BOLD,25));
        add(demo_pinno);
        
        
        
        //                           [module 4]
        
        
        
        //                     add label for services
        
        JLabel services = new JLabel("SERVICES REQUIRED");
        services.setBounds(190,450,400,30);
        services.setFont(new Font("Arial",Font.BOLD,25));
        add(services);
        
        //            add checkbox for services
        
        // for atm card
        j1 = new JCheckBox("ATM card");
        j1.setBounds(220,510,200,20);
        j1.setFont(new Font("Arial",Font.BOLD,20));
        j1.setBackground(Color.WHITE);
        j1.addActionListener(this);
        add(j1);
        // for internet banking
        j2 = new JCheckBox("INTERNET BANKING");
        j2.setBounds(470,510,250,20);
        j2.setFont(new Font("Arial",Font.BOLD,20));
        j2.setBackground(Color.WHITE);
        j2.addActionListener(this);
        add(j2);
        // for mobile banking
        j3 = new JCheckBox("MOBILE BANKING");
        j3.setBounds(220,550,200,20);
        j3.setFont(new Font("Arial",Font.BOLD,20));
        j3.setBackground(Color.WHITE);
        j3.addActionListener(this);
        add(j3);
        // for email alerts
        j4 = new JCheckBox("E-MAIL ALETRS");
        j4.setBounds(470,550,200,20);
        j4.setFont(new Font("Arial",Font.BOLD,20));
        j4.setBackground(Color.WHITE);
        j4.addActionListener(this);
        add(j4);
        // for cheque book
        j5 = new JCheckBox("CHEQUE BOOK");
        j5.setBounds(220,590,200,20);
        j5.setFont(new Font("Arial",Font.BOLD,20));
        j5.setBackground(Color.WHITE);
        j5.addActionListener(this);
        add(j5);
        // for e statements
        j6 = new JCheckBox("E-STATEMENT");
        j6.setBounds(470,590,200,20);
        j6.setFont(new Font("Arial",Font.BOLD,20));
        j6.setBackground(Color.WHITE);
        j6.addActionListener(this);
        add(j6);
        
        //last lable
        j7 = new JCheckBox("i here by declears that the avove entered details correct to the best of my knowlege");
        j7.setBounds(140,640,800,20);
        j7.setFont(new Font("Arial",Font.BOLD,15));
        j7.setBackground(Color.WHITE);
        add(j7);
        
        
        
        
        
        //                    [module 5]
        
        
        //                     add buttons
        
        //submit button
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(360,690,100,30);
        submit.setFont(new Font("Arial",Font.BOLD,20));
        submit.addActionListener(this);
        add(submit);
        
        //cancle button
        cancle = new JButton("Cancle");
        cancle.setBackground(Color.BLACK);
        cancle.setForeground(Color.WHITE);
        cancle.setBounds(500,690,100,30);
        cancle.setFont(new Font("Arial",Font.BOLD,20));
        cancle.addActionListener(this);
        add(cancle);
        
        
        
        //                   add frame
        
        getContentPane().setBackground(Color.WHITE);
        setSize(1000,800);
        setLocation(250,10);
        setVisible(true);
        
    }
    
    //                   add response
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //           action performed for submit button
        if(e.getSource() == submit)
        {
            String acc_type = null;
            if(r1.isSelected())
            {
                acc_type = "Savings";
            }
            else if(r2.isSelected())
            {
                acc_type = "Current";
            }
            else if(r3.isSelected())
            {
                acc_type = "Recuring";
            }
            else if(r4.isSelected())
            {
                acc_type = "Fixed";
            }
        
            Random r2 = new Random();
            String card_no = "" + Math.abs((r2.nextLong() % 90000000L) + 5463721000000000L);
            String pin_no = "" + Math.abs((r2.nextLong() % 9000L) + 1000L);
            
            String services = "";
            if(j1.isSelected())
            {
                services = services + " ATM CARD";
            }
            if(j2.isSelected())
            {
                services = services + " INTERMET BANKING";
            }
            if(j3.isSelected())
            {
                services = services + " MOBILE BANKING";
            }
            if(j4.isSelected())
            {
                services = services + " E-MAIL ALERTS";
            }
            if(j5.isSelected())
            {
                services = services + " CHEQUE BOOK";
            }
            if(j6.isSelected())
            {
                services = services + " E-STATEMENT ALERT";
            }
            
            try{
                if(acc_type == null)
                {
                    JOptionPane.showMessageDialog(null,"Please select a account type");
                }
                else
                {
                    Conn c3 = new Conn();
                    String query3 = "insert into signupthree values('" +fromno+ "','" +acc_type+ "','" +card_no+ "','" +pin_no+ "','" +services+ "')";
                    String query4 = "insert into login values('" +fromno+ "','" +card_no+ "','" +pin_no+ "','"+acc_holder_name+ "','" +Integer.toString(BALANCE)+" ')";
                    c3.s1.executeUpdate(query3);
                    c3.s1.executeUpdate(query4);
                    
                    JOptionPane.showMessageDialog(null, "CARD NO: " +card_no+ "\nPIN NO: " +pin_no);
                    //open diposit page
                    setVisible(false);
                    new Diposit(pin_no,Integer.toString(BALANCE) , card_no).setVisible(true);
                }
            }catch(Exception e3){
                System.out.println(e3);
            }
        }
        //                    action performed for cancle button
        else if(e.getSource() == cancle)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
        new SignupPage3(null,"");
    }

    
}
