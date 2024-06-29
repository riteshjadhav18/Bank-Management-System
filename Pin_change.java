
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Pin_change extends JFrame implements ActionListener{
     JButton ch,bk;
     JPasswordField npin,rpin;
    String pinn;
   Pin_change(String pinn)
   {
       this.pinn=pinn;
       setLayout(null);
       ImageIcon m=new ImageIcon(ClassLoader.getSystemResource("images/imatm.jpeg"));
       Image i2 =m.getImage().getScaledInstance(660,690,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,660,690);
        add(label);
       
        JLabel j=new JLabel("Change your PIN");
        j.setBounds(200,250,400,25);
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
        
         JLabel newpin=new JLabel("New PIN :");
         //j1.setBackground(Color.blue);
        newpin.setForeground(Color.white);
     //   newpin.setFont(new Font("Bahnschrift SemiBold",Font.BOLD,20));
        newpin.setBounds(120,300,200,40);
        label.add(newpin);
        
         npin=new JPasswordField();
        npin.setBounds(250,310,100,25);
        
        label.add(npin);
        
         JLabel newpin2=new JLabel(" Re-Enter New PIN :");
         //j1.setBackground(Color.blue);
        newpin2.setForeground(Color.white);
    //    newpin2.setFont(new Font("Bahnschrift SemiBold",Font.BOLD,20));
        newpin2.setBounds(120,350,300,40);
        label.add(newpin2);
        
           
        rpin=new JPasswordField();
        rpin.setBounds(250,360,100,25);
       
        label.add(rpin);
        
         ch=new JButton("Change");
        ch.setBounds(120,420,100,25);
        ch.addActionListener(this);
        label.add(ch);
        
          bk=new JButton("Back");
        bk.setBounds(270,420,100,25);
        bk.addActionListener(this);
        label.add(bk);
        
        setSize(660,690);
       setVisible(true);
         
   }
   public void  actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==bk)
       {
           setVisible(false);
           Transaction tt= new Transaction(pinn);
           tt.setVisible(true);
       }
       if(ae.getSource()==ch)
       {
           try{
           String pin1=npin.getText();
           String pin2=rpin.getText();
            if(pin1.equals(""))
           {
               JOptionPane.showMessageDialog(null,"please enter pin");
               return;
           }
            if(pin2.equals(""))
           {
               JOptionPane.showMessageDialog(null,"please re-enter pin");
               return;
           }
           if(!pin1.equals(pin2))
           {
               JOptionPane.showMessageDialog(null,"PIN not matched !!!");
               return;
           }
          
          
           Conn con=new Conn();
           String q="UPDATE login SET PIN='"+pin2+"' where PIN='"+pinn+"'";
           String q1="UPDATE accountdetail SET Account_pin='"+pin2+"' where Account_pin='"+pinn+"'";
          String q2="UPDATE balance SET Pin='"+pin2+"' where Pin='"+pinn+"'";
           String q3="UPDATE withdraw SET pin='"+pin2+"' where pin='"+pinn+"'";
          con.s.executeUpdate(q);
           con.s.executeUpdate(q1);
           con.s.executeUpdate(q2);
           con.s.executeUpdate(q3);
            JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
           setVisible(false);
           new Transaction(pin2).setVisible(true);
               
           }catch(Exception e)
           {
               System.out.println(e);
           }
          
       }
   }
   public static void main(String args[])
   {
       Pin_change pp=new Pin_change("");
   }
}
