
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    JButton back,depo;
    JTextField deposit;
    String p;
    Deposit(String p)
    {
        this.p=p;
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
        
        
        JLabel j=new JLabel("Enter the amout you want to deposit");
        j.setBounds(145,250,400,25);
        j.setForeground(Color.white);
        label.add(j);
        
        deposit=new JTextField("");
        deposit.setBounds(145,300,200,25);
       // deposit.setForeground(Color.whit);
        label.add(deposit);
        
          
         depo=new JButton("Deposit");
        depo.setFont(new Font("Bahnschrift SemiBold",Font.BOLD,10));
        depo.setBounds(270,385,100,25);
        depo.addActionListener(this);
        label.add(depo);
       
         back=new JButton("Back");
        back.setFont(new Font("Bahnschrift SemiBold",Font.BOLD,10));
        back.setBounds(270,420,100,25);
        back.addActionListener(this);
        label.add(back);
        
       setSize(660,690);
       setLocation(100,0);
       setVisible(true);
    }
    
    public  void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==depo)
        {
            String b=deposit.getText();
            if(b.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please enter Amount $$$");
            }
            else{
                Date dd=new Date();
                Conn c=new Conn();
                try
                {
                    String query="insert into balance values('"+p+"','"+b+"','"+dd+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Money deposited Successfully");
                    setVisible(false);
                    new Transaction(p).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                
                 }
            }
            
        }
        if(ae.getSource()==back)
        {
            
            setVisible(false);
            Transaction tt=new Transaction(p);
            tt.setVisible(true);
        }
    }
    public static void main(String args[])
    {
        Deposit d=new Deposit("");
    }
}
