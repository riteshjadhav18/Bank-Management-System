
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SignupThree extends JFrame implements ActionListener{
    
    JButton submit,cancel;
    JRadioButton rd1,rd2,rd3,rd4;
    JCheckBox ser1,ser2,ser3,ser4,ser5,ser6,need;
    String form="";
    SignupThree(String formno)
    {
        this.form=formno;
        setLayout(null);
         JLabel jj=new JLabel("Page 3 : Account Details");   
         jj.setFont(new Font("Times New Roman",Font.BOLD,30));
         jj.setBounds(250,40,400,30);
         add(jj);
         getContentPane().setBackground(Color.WHITE);
         
          JLabel acctype=new JLabel("Account Type");   
         acctype.setFont(new Font("Times New Roman",Font.BOLD,25));
         acctype.setBounds(150,100,400,30);
         add(acctype);

          rd1=new JRadioButton("Sving Account"); 
         rd1.setBackground(Color.white);
          rd2=new JRadioButton("Current Account"); 
          rd3=new JRadioButton("Fixed Diposit");
          rd4=new JRadioButton("Recurring Deposit Account");
         rd2.setBackground(Color.white);
         rd3.setBackground(Color.white);
         rd4.setBackground(Color.white);
         rd1.setBounds(150,130,200,30);
         rd2.setBounds(150,160,200,30);
         rd3.setBounds(350,130,200,30);
         rd4.setBounds(350,160,200,30);
         ButtonGroup bg=new ButtonGroup();
         bg.add(rd1);
          bg.add(rd2);
           bg.add(rd3);
            bg.add(rd4);
         add(rd1);
          add(rd2);
           add(rd3);
            add(rd4);
            
         JLabel cardno=new JLabel("Card Number : xxxx-xxxx-xxxx-6155");   
         cardno.setFont(new Font("Times New Roman",Font.BOLD,25));
         cardno.setBounds(150,250,450,25);
         add(cardno);     
         
          JLabel cd=new JLabel("Your 16 Digit Card Number");   
         cd.setFont(new Font("Times New Roman",Font.BOLD,12));
         cd.setBounds(150,275,450,25);
         add(cd);     
         
          JLabel pinno=new JLabel("PIN Number :    xxxx");   
         pinno.setFont(new Font("Times New Roman",Font.BOLD,25));
         pinno.setBounds(150,350,450,25);
         add(pinno);     
         
          JLabel cd1=new JLabel("Your 4 Digit Passward");   
         cd1.setFont(new Font("Times New Roman",Font.BOLD,12));
         cd1.setBounds(150,375,450,25);
         add(cd1);     
         
          JLabel service=new JLabel("Services Required ");   
         service.setFont(new Font("Times New Roman",Font.BOLD,25));
         service.setBounds(150,450,450,25);
         add(service); 
         
        ser1=new JCheckBox("ATM CARD");
          ser2=new JCheckBox("MOBILE BANKING");
           ser3=new JCheckBox("CHECK BOOK");
         ser4=new JCheckBox("EMAIL & MESSAGE ALERT");
             ser5=new JCheckBox("INTERNAT BANKING");
                  ser6=new JCheckBox("E-STATEMENT");
        ser1.setBackground(Color.white);
         ser2.setBackground(Color.white);
          ser3.setBackground(Color.white);
           ser4.setBackground(Color.white);
            ser5.setBackground(Color.white);
             ser6.setBackground(Color.white);
           
        ser1.setBounds(150,475,200,25);
         ser2.setBounds(150,500,200,25);
          ser3.setBounds(150,525,200,25);
           ser4.setBounds(350,475,200,25);
            ser5.setBounds(350,500,200,25);
             ser6.setBounds(350,525,200,25);
         
               need=new JCheckBox("I here by declare that all the details are correct");
             need.setBounds(150,575,400,25);
             need.setBackground(Color.WHITE);
             add(need);
             
             add(ser1);
             add(ser2);
             add(ser3);
             add(ser4);
             add(ser5);
             add(ser6);
             
              submit=new JButton("Submit");
             submit.setBackground(Color.BLUE);
             submit.setForeground(Color.white);
             submit.setBounds(250,650,100,30);
             submit.addActionListener(this);
             add(submit);
             
               
              cancel=new JButton("Cancel");
             cancel.setBackground(Color.BLUE);
             cancel.setForeground(Color.white);
             cancel.setBounds(450,650,100,30);
             cancel.addActionListener(this);
             add(cancel);
             
             
        setSize(750,800);
        setVisible(true);
        setLocation(50,0);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== submit)
        {
            String f=form;
            String account_type="";
            if(rd1.isSelected())
            {
                account_type="Saving Account";
            }
             if(rd2.isSelected())
            {
                account_type="Current Account";
            }
              if(rd3.isSelected())
            {
                account_type="Fixed Account";
            }
               if(rd4.isSelected())
            {
                account_type="Recuring Account";
            }
               
            Random ran=new Random();
            String num=""+Math.abs((ran.nextLong()%90000l))+06155000l;
            String num2=""+Math.abs((ran.nextLong()%9l))+615l;
            
            String facitilies="";
            if(ser1.isSelected())
            {
                facitilies=facitilies+"ATM CARD ";
            }
             if(ser2.isSelected())
            {
                facitilies=facitilies+"MOBILE BANKING ";
            }
              if(ser3.isSelected())
            {
                facitilies=facitilies+"CHECK BOOK ";
            }
               if(ser4.isSelected())
            {
                facitilies=facitilies+"EMAIL & MESSAGE NOTIFICATION ";
            }
                if(ser5.isSelected())
            {
                facitilies=facitilies+"INTERNATE BANKING ";
            }
              if(ser6.isSelected())
            {
                facitilies=facitilies+"E-STATEMENT ";
            }
              
            try
            {
                if(!need.isSelected())
                {
                    JOptionPane.showMessageDialog(null,"Please agree all the condition");
                }
                else if(account_type=="")
                 {
                     JOptionPane.showMessageDialog(null,"Please selece account type");
                 }
                else
                {
                   Conn vv=new Conn();
                  
                   String query="insert into accountdetail values('"+account_type+"','"+num+"','"+num2+"','"+facitilies+"')";
                  String query11="insert into login values('"+f+"','"+num+"','"+num2+"')";
                   vv.s.executeUpdate(query);
                    vv.s.executeUpdate(query11);
                    JOptionPane.showMessageDialog(null,"Card Number : "+num+"\n PIN : "+num2);
                     setVisible(false);
                     new Deposit(num2).setVisible(false);
                }
                
            }catch(Exception e)
            {
                System.out.println(e);
            }
            
        }
         if(ae.getSource()== cancel)
         {
             setVisible(false);
             new Login().setVisible(true);
         }
    }
   
    
    public static void main(String args[])
    {
        SignupThree st=new SignupThree("");
        
    }
}
