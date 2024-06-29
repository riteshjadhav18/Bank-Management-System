
package bankmanagementsystem;
// package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class Balance_check extends JFrame implements ActionListener{
    JButton back;
    String pinn;
   Balance_check(String pinn)
   {
       this.pinn=pinn;
       setLayout(null);
       ImageIcon m=new ImageIcon(ClassLoader.getSystemResource("images/imatm.jpeg"));
       Image i2 =m.getImage().getScaledInstance(660,690,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,660,690);
        add(label);
       
       
        
         JLabel j1=new JLabel("CASH");
         //j1.setBackground(Color.blue);
        j1.setForeground(Color.white);
        j1.setFont(new Font("Bahnschrift SemiBold",Font.BOLD,25));
        j1.setBounds(200,467,300,50);
        label.add(j1);
        
        JLabel j2=new JLabel("RECEPT");
         //j1.setBackground(Color.blue);
        j2.setForeground(Color.white);
        j2.setFont(new Font("Bahnschrift SemiBold",Font.BOLD,20));
        j2.setBounds(500,188,300,40);
        label.add(j2);
        
         JLabel j3=new JLabel("CARD");
         //j1.setBackground(Color.blue);
        j3.setForeground(Color.white);
        j3.setFont(new Font("Bahnschrift SemiBold",Font.BOLD,20));
        j3.setBounds(515,282,300,40);
        label.add(j3);
        Conn con=new Conn();
        int balance=0;
        try{
            ResultSet rs=con.s.executeQuery("select * from balance where Pin = '"+pinn+"'");
            
            while(rs.next())
            {
                balance+=Integer.parseInt(rs.getString("Balance"));
            }
            ResultSet rss=con.s.executeQuery("select * from withdraw where pin = '"+pinn+"'");
         
             while(rss.next())
            {
                //if(rss.getString("pin").equals(pinn))
               // {
                    balance-=Integer.parseInt(rss.getString("Withdraw"));
               // }
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        JLabel j=new JLabel("Your Account Balance is \n Rs "+balance);
        j.setBounds(145,340,400,25);
        j.setForeground(Color.white);
        label.add(j);
        
        back=new JButton("BACK");
        back.setBounds(270,420,100,25);
        back.addActionListener(this);
        label.add(back);
         
        setSize(660,690);
       setVisible(true);
         
        
    }
   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==back)
       {
           setVisible(false);
           new Transaction(pinn).setVisible(true);
       }
   }
   
    public static void main(String args[])
    {
        Balance_check tt=new Balance_check("");
    }
}

 


