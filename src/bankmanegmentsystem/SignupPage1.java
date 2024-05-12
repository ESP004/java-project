
package bankmanegmentsystem;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignupPage1 extends JFrame implements ActionListener{
    
    Random r1;
    JButton next;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JRadioButton male,female,married,unmarried;
    JDateChooser d1;
    long from_no;//used in random
    String fromno;
    
    SignupPage1(){
        
        setLayout(null);
        
        
        //                  [module 1]
        
        
        
        //                add bank logo
        
        //catch the logo from the system
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        //scale the image
        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        //convert the scaled image into imageicon class object so that it will used by JLable
        ImageIcon i3=new ImageIcon(i2);
        //convet the logo into lable
        JLabel label =new JLabel(i3);
        //set lable location(but location will be changed after set defult layout off
        label.setBounds(180,5,70,70);
        add(label);
        
        //add from no
        r1= new Random();
        from_no=Math.abs((r1.nextLong()%9000L)+1000L);
        JLabel fromno_lable=new JLabel("APPLACTION FROM NO :"+from_no);
        fromno_lable.setFont(new Font("Arial",Font.BOLD,35));
        fromno_lable.setBounds(260, 20, 600, 45);
        add(fromno_lable);
        
        
        
        
        //                     [module 2]
        
        
        
        //                label personal details  
        
        JLabel pdetail=new JLabel("page 1 : PERSONAL DETAILS");
        pdetail.setFont(new Font("Arial",Font.BOLD,23));
        pdetail.setBounds(290, 80, 450, 28);
        add(pdetail);
        
        //add name label
        JLabel name =new JLabel("NAME :");
        name.setBounds(200, 140, 220,30 );
        name.setFont(new Font("arial",Font.BOLD,25));
        add(name);
        //add textfield for name
        t1= new JTextField();
        t1.setFont(new Font("Arial",Font.BOLD,15));
        t1.setBounds(440,140,350,25);
        add(t1);
        
        // add texfield for fathers name
        JLabel fname =new JLabel("FATHER'S NAME :");
        fname.setBounds(200, 190, 220,30 );
        fname.setFont(new Font("arial",Font.BOLD,25));
        add(fname);
        //add textfiels for fathers name
        t2= new JTextField();
        t2.setFont(new Font("Arial",Font.BOLD,15));
        t2.setBounds(440,190,350,25);
        add(t2);
        
        // add label for dob
        JLabel dob =new JLabel("DATE OD BIRTH :");
        dob.setBounds(200, 240, 240,30 );
        dob.setFont(new Font("arial",Font.BOLD,25));
        add(dob);
        //add date choser for dob
        d1 =new JDateChooser();
        d1.setBounds(440, 240, 350, 30);
        d1.setForeground(BLACK);
        add(d1);
        
        //add label for gender
        JLabel gender =new JLabel("GENDER :");
        gender.setBounds(200, 290, 300,30 );
        gender.setFont(new Font("arial",Font.BOLD,25));
        add(gender);
        //add radio button for gender
        //for male
        male = new JRadioButton("Male");
        male.setBounds(440, 290,125 , 30);
        male.setBackground(WHITE);
        add(male);
        //for female
        female = new JRadioButton("Female");
        female.setBounds(565, 290,125 , 30);
        female.setBackground(WHITE);
        add(female);
        //group both radio buttons
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        
        //add lable for email
        JLabel email =new JLabel("EMAIL ADDRESS :");
        email.setBounds(200, 340, 240,30 );
        email.setFont(new Font("arial",Font.BOLD,26));
        add(email);
        //textfield for email
        t3= new JTextField();
        t3.setFont(new Font("Arial",Font.BOLD,15));
        t3.setBounds(440,340,350,25);
        add(t3);
        
        // add radio button for marital stutas
        JLabel mstatus =new JLabel("MARITAL STATUS :");
        mstatus.setBounds(200, 390, 300,30 );
        mstatus.setFont(new Font("arial",Font.BOLD,25));
        add(mstatus);
        //add radio button for marid
        //for married
        married = new JRadioButton("MARRIED");
        married.setBounds(440, 390,125 , 30);
        married.setBackground(WHITE);
        add(married);
        //for unmarried
        unmarried = new JRadioButton("UNMARRIED");
        unmarried.setBounds(565, 390,125 , 30);
        unmarried.setBackground(WHITE);
        add(unmarried);
        //group both radio buttons
        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(married);
        bg2.add(unmarried);
        
        // add address
        JLabel address =new JLabel("ADDRESS :");
        address.setBounds(200,440, 220,30 );
        address.setFont(new Font("arial",Font.BOLD,25));
        add(address);
        //textfield for address
        t4= new JTextField();
        t4.setFont(new Font("Arial",Font.BOLD,15));
        t4.setBounds(440,440,350,25);
        add(t4);
        
        // add lable for pincode
        JLabel pcode =new JLabel("PINCODE :");
        pcode.setBounds(200, 490, 220,30 );
        pcode.setFont(new Font("arial",Font.BOLD,25));
        add(pcode);
        //textfield for pincode
        t5= new JTextField();
        t5.setFont(new Font("Arial",Font.BOLD,15));
        t5.setBounds(440,490,350,25);
        add(t5);
        
        //add label for city
        JLabel city =new JLabel("CITY :");
        city.setBounds(200, 540, 220,30 );
        city.setFont(new Font("arial",Font.BOLD,25));
        add(city);
        //textfield for city
        t6= new JTextField();
        t6.setFont(new Font("Arial",Font.BOLD,15));
        t6.setBounds(440,540,350,25);
        add(t6);
        
        //add state
        JLabel state =new JLabel("STATE :");
        state.setBounds(200, 590, 220,30 );
        state.setFont(new Font("arial",Font.BOLD,25));
        add(state);
        //textfield for status
        t7= new JTextField();
        t7.setFont(new Font("Arial",Font.BOLD,15));
        t7.setBounds(440,590,350,25);
        add(t7);
        
        
        //                    [module 3]
        
        
        //                    add next button
        next = new JButton("Next");
        next.setBounds(690, 650, 100, 30);
        next.setBackground(BLACK);
        next.setForeground(WHITE);
        next.setFont(new Font("Arial",Font.BOLD,20));
        next.addActionListener(this);
        add(next);        
        
        
        //create frame
        getContentPane().setBackground(WHITE);
        setSize(1000,800);
        setLocation(250,10);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        //take responce of text fields
        fromno = "" + from_no;
        String name = t1.getText().trim();
        String fname = t2.getText().trim();
        //response of dob
        String dob= ((JTextField) d1.getDateEditor().getUiComponent()).getText().trim();
        String email = t3.getText().trim();
        String address = t4.getText().trim();
        String pincode = t5.getText().trim();
        String city = t6.getText().trim();
        String state = t7.getText().trim();
        //take response of radio buttons
        //for gender
        String gender = null;
        if(male.isSelected())
        {
            gender = "male";
        }
        else if(female.isSelected())
        {
            gender = "female";
        }
        //for marital status
        String mstatus = null;
        if(married.isSelected())
        {
            mstatus = "married";
        }
        else if(unmarried.isSelected())
        {
            mstatus = "unmarried";
        }
        
        //hit responce into database
        try
        {
            //apply vallidition
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter your name" , "EMPTY FIELD" , JOptionPane.WARNING_MESSAGE);
                return;
            }
            else if(fname.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter your fathers name" , "EMPTY FIELD" , JOptionPane.WARNING_MESSAGE);
                return;
            }
            else if(dob.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter your date of birth" , "EMPTY FIELD" , JOptionPane.WARNING_MESSAGE);
                return;
            }
            else if(gender.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please select your gender" , "EMPTY FIELD" , JOptionPane.WARNING_MESSAGE);
                return;
            }
            else if(mstatus.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Select marittal status" , "EMPTY FIELD" , JOptionPane.WARNING_MESSAGE);
            }
            else if(email.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter your email" , "EMPTY FIELD" , JOptionPane.WARNING_MESSAGE);
                return;
            }
            else if(address.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter your address" , "EMPTY FIELD" , JOptionPane.WARNING_MESSAGE);
                return;
            }
            else if(pincode.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter your pin code" , "EMPTY FIELD" , JOptionPane.WARNING_MESSAGE);
                return;
            }
            else if(city.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter your city" , "EMPTY FIELD" , JOptionPane.WARNING_MESSAGE);
                return;
            }
            else if(state.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter your state" , "EMPTY FIELD" , JOptionPane.WARNING_MESSAGE);
                return;
            }
            //             prepare the querry for insert data
            else
            {
                if(!valEmail(email))
                {
                    JOptionPane.showMessageDialog(null,"Invalid email" , "INVALID" , JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else if(!valAlpha(name))
                {
                    JOptionPane.showMessageDialog(null,"Name only contains alphabets" , "INVALID" , JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else if(!valAlpha(fname))
                {
                    JOptionPane.showMessageDialog(null,"Father name only contains alphabets" , "INVALID" , JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else if(!valNum(pincode))
                {
                    JOptionPane.showMessageDialog(null,"Pincode only contains numeric values" , "INVALID" , JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else if(!valAlphaNum(address))
                {
                    JOptionPane.showMessageDialog(null,"address contains alphanumeric values" , "INVALID" , JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else if(!valAlpha(city))
                {
                    JOptionPane.showMessageDialog(null,"city only contains alphabets" , "INVALID" , JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else if(!valAlpha(state))
                {
                    JOptionPane.showMessageDialog(null,"state contains alphanumeric values" , "INVALID" , JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else
                {
                    Conn c1 = new Conn();
                    String querry = "insert into signup values('"+fromno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+mstatus+"','"+address+"','"+pincode+"','"+city+"','"+state+"')";
                    c1.s1.executeUpdate(querry);
                }
            }
            //open the signuppage2
            setVisible(false);
            new SignupPage2(fromno,name).setVisible(true);
        }
        catch(HeadlessException e)
        {
            System.out.println(e);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //logic for validate an email
    public static boolean valEmail(String email)
    {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat = Pattern.compile(emailRegex , Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(email);
        return matcher.find();
    }

    //logic for validating alphabet only
    public static boolean valAlpha(String input)
    {
        return input.matches("[A-Za-z ]+");
    }
    
    //logic for validating alphabet and numeric and - / only
    public static boolean valAlphaNum(String input)
    {
        return input.matches("[A-Za-z0-9-/ ]+");
    }
    
    //logic for validating number only
    public static boolean valNum(String input)
    {
        return input.matches("[0-9]+");
    }
    
    public static void main(String args[]){
        new SignupPage1();
    }

    
}
