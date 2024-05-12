
package bankmanegmentsystem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Mini_statements extends JFrame{
    Mini_statements(String pin_no , String balance , String card_no)
    {
        setLayout(null);
        setTitle("Mini Statement");
        
        
        
        
        
        //                    [module 1]
        
        
        //add bank name
        JLabel bank_name = new JLabel("Indian Bank");
        bank_name.setBounds(130,20,200,30);
        bank_name.setFont(new Font("Arial",Font.BOLD,20));
        add(bank_name);
        
        //add card no lable
        JLabel card_lable = new JLabel("Card no :"+card_no.substring(0,4)+"XXXXXXXX"+card_no.substring(12));
        card_lable .setBounds(30,70,300,20);
        card_lable .setFont(new Font("Arial",Font.BOLD,20));
        add(card_lable );
        
        
        
        
        
        
        //                   [module 2]
        
        
        
        
        //add lable for mini statements (fetch value from database and put on lable dynamically)
        JLabel mini = new JLabel();
        mini.setBounds(30,110,350,450);
        mini.setFont(new Font("Arial",Font.BOLD,12));
        add(mini);
        
        //deal with statements
        try{
            Conn conn = new Conn();
            ResultSet user_data = conn.s1.executeQuery("select * from bank where pin_no ='"+pin_no+"'");
            while(user_data.next())
            {
                //set value on the lable dynamicaly from the database
                mini.setText(mini.getText()+"<html>"+user_data.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+user_data.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+user_data.getString("amount")+"<br><br><html>");
            }
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
       
        
        
         //             deploy the frame
        
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);
        //setUndecorated(true);
        setVisible(true);
    }
    
    
    public static void main(String args[])
    {
        new Mini_statements("", "" ,"");
    }
}
