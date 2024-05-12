
package bankmanegmentsystem;

import static java.awt.Color.WHITE;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignupPage2 extends JFrame implements ActionListener{
    
    JButton next2;
    JComboBox b1,b2,b3,b4,b5;
    JTextField panno_textfield,adaharno_textfield;
    JRadioButton sinior_textfield,sinior_textfield2,exiting_textfield,exiting_textfield2;
    String fromno, acc_holder_name;
    
    SignupPage2(String fromno,String name)
    {
        this.acc_holder_name = name;
        this.fromno = fromno;
        setLayout(null);
        //add from no lable
        JLabel from_no = new JLabel("From no."+this.fromno);
        from_no.setBounds(850, 5, 170, 20);
        from_no.setFont(new Font("Arial",Font.BOLD,15));
        add(from_no);
        
        //add logo lable
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel logo = new JLabel(i3);
        logo.setBounds(150, 35, 100, 100);
        add(logo);
        
        //add page 2 lable
        JLabel page2 = new JLabel("PAGE 2 : ADDITIONAL DETAILS");
        page2.setBounds(260,60,600,50);
        page2.setFont(new Font("Arial",Font.BOLD,35));
        add(page2);
        
        //add label for religion
        JLabel religion = new JLabel("RELIGION :");
        religion.setBounds(140, 160, 300, 30);
        religion.setFont(new Font("Arial",Font.BOLD,25));
        add(religion);
        
        //add choise box for rligion
        String r[] = {"None","Hindu","Sikh","Muslim","Christan","Jain","Others"};
        b1 = new JComboBox(r);
        b1.setBounds(440,160,400,30);
        b1.setBackground(WHITE);
        add(b1);
        
        //add label for category
        JLabel category = new JLabel("CATEGORY :");
        category.setBounds(140, 210, 300, 30);
        category.setFont(new Font("Arial",Font.BOLD,25));
        add(category);
        
        //add choise box for category
        String r2[] = {"None","Genral","OBC","SC","ST","EWS","Others"};
        b2 = new JComboBox(r2);
        b2.setBounds(440,210,400,30);
        b2.setBackground(WHITE);
        add(b2);
        
        //add label for income
        JLabel income = new JLabel("INCOME :");
        income.setBounds(140, 260, 300, 30);
        income.setFont(new Font("Arial",Font.BOLD,25));
        add(income);
        
        //add choise box for income
        String r3[] = {"null","<150000","<250000","<500000","500000","upto 1000000","avove 1000000"};
        b3 = new JComboBox(r3);
        b3.setBounds(440,260,400,30);
        b3.setBackground(WHITE);
        add(b3);
        
        //add label for qualification
        JLabel qualification = new JLabel("QUALIFICATION :");
        qualification.setBounds(140, 310, 300, 30);
        qualification.setFont(new Font("Arial",Font.BOLD,25));
        add(qualification);
        
        //add choise box for qualification
        String r4[] = {"None","Graduate","Non-Graduate","Post-Graduate","Docotrate","Others"};
        b4 = new JComboBox(r4);
        b4.setBounds(440,310,400,30);
        b4.setBackground(WHITE);
        add(b4);
        
        //add label for occupation
        JLabel occupation = new JLabel("OCCUPATION :");
        occupation.setBounds(140, 360, 300, 30);
        occupation.setFont(new Font("Arial",Font.BOLD,25));
        add(occupation);
        
        //add choise box for occupation
        String r5[] = {"None","Salaried","Self-imployed","Business","Student","Others"};
        b5 = new JComboBox(r5);
        b5.setBounds(440,360,400,30);
        b5.setBackground(WHITE);
        add(b5);
        
        //add label for pan no
        JLabel panno = new JLabel("PAN NO :");
        panno.setBounds(140, 410, 300, 30);
        panno.setFont(new Font("Arial",Font.BOLD,25));
        add(panno);
        
        //add textfield for pan no
        panno_textfield = new JTextField();
        panno_textfield.setBounds(440,410,400,30);
        panno_textfield.setFont(new Font("Arial",Font.BOLD,15));
        add(panno_textfield);
        
        //add label for adhar no
        JLabel adaharno = new JLabel("ADAHAR NO :");
        adaharno.setBounds(140, 460, 300, 30);
        adaharno.setFont(new Font("Arial",Font.BOLD,25));
        add(adaharno);
        
        //adhar no textfield
        adaharno_textfield = new JTextField();
        adaharno_textfield.setBounds(440,460,400,30);
        adaharno_textfield.setFont(new Font("Arial",Font.BOLD,15));
        add(adaharno_textfield);
        
        //add label for sinior citizen
        JLabel sinior = new JLabel("SINIOR CITIZEN :");
        sinior.setBounds(140, 510, 300, 30);
        sinior.setFont(new Font("Arial",Font.BOLD,25));
        add(sinior);
        
        //add radio buttons for sinior citizen
        //for yes
        sinior_textfield = new JRadioButton("yes");
        sinior_textfield.setBounds(440,510,200,30);
        sinior_textfield.setBackground(WHITE);
        sinior_textfield.setFont(new Font("Arial",Font.BOLD,20));
        add(sinior_textfield);
        
        //for no
        sinior_textfield2 = new JRadioButton("no");
        sinior_textfield2.setBounds(640,510,200,30);
        sinior_textfield2.setBackground(WHITE);
        sinior_textfield2.setFont(new Font("Arial",Font.BOLD,20));
        add(sinior_textfield2);
        
        //group two buttons of sinior citizen
        ButtonGroup group_sinior = new ButtonGroup();
        group_sinior.add(sinior_textfield);
        group_sinior.add(sinior_textfield2);
        
        //add label for exisiting account
        JLabel exisiting = new JLabel("EXISITING ACCOUNT :");
        exisiting.setBounds(140, 560, 300, 30);
        exisiting.setFont(new Font("Arial",Font.BOLD,25));
        add(exisiting);
        
        //add radio buttons for sinior citizen
        //for yes
        exiting_textfield = new JRadioButton("yes");
        exiting_textfield.setBounds(440,560,200,30);
        exiting_textfield.setBackground(WHITE);
        exiting_textfield.setFont(new Font("Arial",Font.BOLD,20));
        add(exiting_textfield);
        
        //for no
        exiting_textfield2 = new JRadioButton("no");
        exiting_textfield2.setBounds(640,560,200,30);
        exiting_textfield2.setBackground(WHITE);
        exiting_textfield2.setFont(new Font("Arial",Font.BOLD,20));
        add(exiting_textfield2);
        
        //group two buttond of exiting account
        ButtonGroup group_exiting = new ButtonGroup();
        group_exiting.add(exiting_textfield);
        group_exiting.add(exiting_textfield2);
        
        //add next button
        next2 = new JButton("Next");
        next2.setBounds(740,630,100,30);
        next2.setFont(new Font("Arial",Font.BOLD,20));
        next2.setBackground(Color.BLACK);
        next2.setForeground(WHITE);
        next2.addActionListener(this);
        add(next2);
        
        
        //add frame
        getContentPane().setBackground(WHITE);
        setSize(1000,800);
        setLocation(250,10);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //get data from the form/user[module 1]
        String religion = (String) b1.getSelectedItem();
        String category = (String) b2.getSelectedItem();
        String income = (String) b3.getSelectedItem();
        String qualification = (String) b4.getSelectedItem();
        String occupation = (String) b5.getSelectedItem();
        String pan_no = panno_textfield.getText().trim();
        String adhar_no = adaharno_textfield.getText().trim();
        String sinior_citizen = null;
        if(sinior_textfield.isSelected())
        {
            sinior_citizen = "yes";
        }
        else if(sinior_textfield2.isSelected())
        {
            sinior_citizen = "no";
        }
        String exiting_account = null;
        if(exiting_textfield.isSelected())
        {
            exiting_account = "yes";
        }
        else if(exiting_textfield2.isSelected())
        {
            exiting_account = "no";
        }
        
        //apply validition
       try{
           if(religion.equals("None"))
           {
               JOptionPane.showMessageDialog(null,"Please select a Religion");
               return;
           }
           else if(category.equals("None"))
           {
               JOptionPane.showMessageDialog(null,"Please select a category");
               return;
           }
           else if(pan_no.equals(""))
           {
               JOptionPane.showMessageDialog(null,"Pan no is mandotory");
               return;
           }
           else if(adhar_no.equals(""))
           {
               JOptionPane.showMessageDialog(null,"Adahar no is mandotory");
               return;
           }
           else if(sinior_citizen == null)
           {
               JOptionPane.showMessageDialog(null,"Fill all the mandotory field first");
               return;
           }
           else if(exiting_account == null)
           {
               JOptionPane.showMessageDialog(null,"Fill all the mandotory field first");
               return;
           }
           else
           {
               if(!valPanno(pan_no))
               {
                   JOptionPane.showMessageDialog(null,"Pan no contains 10 alphanumeric values only" , "INVALID" , JOptionPane.ERROR_MESSAGE);
                   return;
               }
               else if(!valAdharno(adhar_no))
               {
                   JOptionPane.showMessageDialog(null,"Adhar no contains 12 digits only" , "INVALID" , JOptionPane.ERROR_MESSAGE);
                   return;
               }
               Conn c2 = new Conn();
               String queery2 = "insert into signuptwo values('"+fromno+"','"+religion+"','"+category+"','"+income+"','"+qualification+"','"+occupation+"','"+pan_no+"','"+adhar_no+"','"+sinior_citizen+"','"+exiting_account+"')";
               c2.s1.executeUpdate(queery2);
           }
           //redirect to signup page 3
           setVisible(false);
           new SignupPage3(fromno,acc_holder_name).setVisible(true);
       }
       catch(HeadlessException e2)
       {
           System.out.println(e2);
       } catch (SQLException ex) {
            Logger.getLogger(SignupPage2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //logic for validating adhar no
    public static boolean valAdharno(String adhar)
    {
        return adhar.length() == 12 && adhar.matches("[0-9]+");
    }
    
    //logic for validating pan no
    public static boolean valPanno(String pan_no)
    {
        return pan_no.length() == 10 && pan_no.matches("[A-Z0-9]+");
    }
    
    
    public static void main(String args[]){
        new SignupPage2("","");
    }

    
}
