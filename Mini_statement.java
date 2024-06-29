
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Mini_statement extends JFrame {
    public Mini_statement(String pinn)
    {
        
        setLayout(null);
         setVisible(true);
        setSize(500,700);
        setLocation(400,20);
        getContentPane().setBackground(Color.WHITE);
        JLabel l1=new JLabel("Bank OF GCOEARA");
        l1.setFont(new Font("Algerian",Font.BOLD,30));
        l1.setBounds(100,50,300,25);
        add(l1);
         Conn con=new Conn();
        int balance=0;
        String date="";
        String str=" ";
        int x=0;
        try
        {
             ResultSet rs=con.s.executeQuery("select * from balance where Pin = '"+pinn+"'");
            
            while(rs.next())
            {
                int val=Integer.parseInt(rs.getString("Balance"));
                balance+=Integer.parseInt(rs.getString("Balance"));
                date=rs.getString("Date_of_deposit");
                JLabel d=new JLabel("Deposit date : "+date+" Amount deposited :"+val);
                d.setBounds(30,125+x,400,25);
                add(d);
                x+=25;
            }
            ResultSet rss=con.s.executeQuery("select * from withdraw where pin = '"+pinn+"'");
         
             while(rss.next())
            {
                int va=Integer.parseInt(rss.getString("Withdraw"));
                balance-=Integer.parseInt(rss.getString("Withdraw"));
                         
                JLabel ddd=new JLabel("Withdraw date : "+date+" Amount Withdraw :"+va);
                ddd.setBounds(30,125+x,400,25);
                add(ddd);
                x+=25;
            }
            ResultSet r=con.s.executeQuery("select * from accountdetail where Account_pin = '"+pinn+"'");
            r.next();
            str=r.getString("Account_no");
            
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
       
         JLabel dd=new JLabel("Your account num is : "+str);
        dd.setBounds(30,100,300,25);
        add(dd);
        
         JLabel dash=new JLabel("--------------------------------------------------------");
        dash.setBounds(70,125+x,400,25);
        add(dash);
        x+=25;
         JLabel bal=new JLabel("Total current Balance of account is  : "+balance);
        bal.setBounds(30,125+x,300,25);
        add(bal);
        
    }
    
    public static void main(String args[])
    {
        Mini_statement ms=new Mini_statement("");
    }
}
