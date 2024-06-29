package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class Fastcash extends JFrame implements ActionListener{
    JButton deposit,cash ,pin, withdraw,st,bc,e;
    String pinn;
   Fastcash(String pinn)
   {
       this.pinn=pinn;
       setLayout(null);
       ImageIcon m=new ImageIcon(ClassLoader.getSystemResource("images/imatm.jpeg"));
       Image i2 =m.getImage().getScaledInstance(660,690,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,660,690);
        add(label);
       
        JLabel j=new JLabel("Please select following option");
        j.setBounds(165,250,400,25);
        j.setForeground(Color.white);
        label.add(j);
        
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
        
         deposit=new JButton("Rs 100");
        deposit.setFont(new Font("Bahnschrift SemiBold",Font.BOLD,10));
        deposit.setBounds(120,345,100,25);
        deposit.addActionListener(this);
        label.add(deposit);
       
        
         cash=new JButton("Rs 500");
        cash.setFont(new Font("Bahnschrift SemiBold",Font.BOLD,10));
        cash.setBounds(120,375,100,25);
        cash.addActionListener(this);
        label.add(cash);
      
        
         pin=new JButton("Rs 1000");
        pin.setFont(new Font("Bahnschrift SemiBold",Font.BOLD,10));
        pin.setBounds(120,405,100,25);
        pin.addActionListener(this);
        label.add(pin);
        
         withdraw=new JButton("Rs 2000");
        withdraw.setFont(new Font("Bahnschrift SemiBold",Font.BOLD,10));
        withdraw.setBounds(275,345,100,25);
        withdraw.addActionListener(this);
        label.add(withdraw);
        
         st=new JButton("Rs 5000");
        st.setFont(new Font("Bahnschrift SemiBold",Font.BOLD,10));
        st.setBounds(275,375,100,25);
        st.addActionListener(this);
        label.add(st);
        
         bc=new JButton("Rs 10000");
        bc.setFont(new Font("Bahnschrift SemiBold",Font.BOLD,10));
        bc.setBounds(275,405,100,25);
        bc.addActionListener(this);
        label.add(bc);
        
          e=new JButton("Back");
        e.setFont(new Font("Bahnschrift SemiBold",Font.BOLD,10));
        e.setBounds(275,435,100,20);
        e.addActionListener(this);
        label.add(e);
        
       setSize(660,690);
       setVisible(true);
      // setLocation(100,20);
   }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==e)
        {
            setVisible(false);
            Transaction d=new Transaction(pinn);
            d.setVisible(true);
        }
        else{
            
        try{
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from balance where Pin = '"+pinn+"'");
            int balance=0;
            while(rs.next())
            {
                balance+=Integer.parseInt(rs.getString("Balance"));
            }
            ResultSet rss=c.s.executeQuery("select * from withdraw where pin = '"+pinn+"'");
         
             while(rss.next())
            {
                //if(rss.getString("pin").equals(pinn))
               // {
                    balance-=Integer.parseInt(rss.getString("Withdraw"));
               // }
            }
          if(Integer.parseInt(amount)>=balance)
          {
              JOptionPane.showMessageDialog(null,"Balance Insufficient");
              return;
          }
          if(Integer.parseInt(amount)<balance)
          {
              Date date=new Date();
              String query="insert into withdraw values('"+pinn+"','"+amount+"','"+date+"')";
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"  Money withdraw Successfully");
              setVisible(false);
              new Transaction(pinn).setVisible(true);
          }  
             
        }catch(Exception e){
            System.out.println(e);
        }
        }
    }
    
    public static void main(String args[])
    {
        Fastcash tt=new Fastcash("");
    }
}

 
