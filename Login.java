
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener{
 
    JButton signin,signup,clear;
    JTextField cardtextfield;
    JPasswordField pintextfield;
    Login()
    {
        setLayout(null);
        setTitle("AUTOMATED TELLER MACHINE");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/atm2.jpeg"));
        Image i2 =i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(170,15,100,100);
        add(label);
     
        JLabel text=new JLabel("Welcome To ATM");
        text.setBounds(300,40,400,50);
        text.setFont(new Font("Algerian",Font.BOLD,30));
        add(text);
        
        JLabel cardno=new JLabel("Card Number :");
        cardno.setBounds(250,150,400,50);
        cardno.setFont(new Font("Modern No. 20",Font.BOLD,20));
        add(cardno);
        
        cardtextfield=new JTextField();
        cardtextfield.setBounds(400,160,200,30);
        cardtextfield.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(cardtextfield);
                
        JLabel pin=new JLabel("PIN     :");
        pin.setBounds(250,200,400,50);
        pin.setFont(new Font("Modern No. 20",Font.BOLD,20));
        add(pin);
        
        pintextfield=new JPasswordField();
        pintextfield.setBounds(400,210,200,30);
        pintextfield.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(pintextfield);
        
        signup=new JButton("SIGN UP");
        signup.setBounds(400,310,200,30);
        signup.addActionListener(this);
        add(signup);
        
        clear=new JButton("CLEAR");
        clear.setBounds(510,260,90,30);
        clear.addActionListener(this);
        add(clear);
        
        signin=new JButton("SIGN IN");
        signin.setBounds(400,260,90,30);
        signin.addActionListener(this);
        add(signin);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setVisible(true);
        setLocation(150,100);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clear)
        {
            cardtextfield.setText("");
            pintextfield.setText("");
        }
        else if(ae.getSource()==signin)
        {
            setVisible(false);
            SignupOne s1=new SignupOne();
            
        }
        else if(ae.getSource()==signup)
        {
             setVisible(false);
            SignupOne s1=new SignupOne();
            s1.setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
        Login lg=new Login();
    }
}
