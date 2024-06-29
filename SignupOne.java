
package bankmanagementsystem;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener {
    static long randnum;
    JTextField nametext,fathertext,emailtext,addresstext,citytext,statetext,pincodetext;
    JDateChooser dob;
    JRadioButton femal,mal,married,unmarried;
    JButton next1;
    SignupOne()
    {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        Random ran=new Random();
        randnum=Math.abs((ran.nextLong()%9000l)+1000l);
        JLabel formno=new JLabel("Application Form no :"+randnum);
        formno.setFont(new Font("Times New Roman",Font.BOLD,30));
        formno.setBounds(200,20,400,30);
        add(formno);
        
        JLabel personaldetail=new JLabel("Personal Detail page 1");
        personaldetail.setFont(new Font("Times New Roman",Font.BOLD,20));
        personaldetail.setBounds(280,50,300,30);
        add(personaldetail);
        
        JLabel name=new JLabel("Name :");
        name.setFont(new Font("Times New Roman",Font.BOLD,20));
        name.setBounds(150,90,300,30);
        add(name);
        
        nametext=new JTextField("");
        nametext.setBounds(350,90,300,30);
        add(nametext);
        
        JLabel father=new JLabel("Father's Name :");
        father.setFont(new Font("Times New Roman",Font.BOLD,20));
        father.setBounds(150,130,300,30);
        add(father);
        
        fathertext=new JTextField("");
        fathertext.setBounds(350,130,300,30);
        add(fathertext);
        
        JLabel dathofbirth=new JLabel("DOB :");
        dathofbirth.setFont(new Font("Times New Roman",Font.BOLD,20));
        dathofbirth.setBounds(150,170,300,30);
        add(dathofbirth);
        
        dob=new JDateChooser();
        dob.setBounds(350,170,300,30);
        add(dob);
        
        
        JLabel gender=new JLabel("Gender :");
        gender.setFont(new Font("Times New Roman",Font.BOLD,20));
        gender.setBounds(150,210,300,30);
        add(gender);
        
        femal=new JRadioButton("Femal");
        femal.setBounds(350,210,145,30);
        femal.setBackground(Color.WHITE);
        add(femal);
         mal=new JRadioButton("Male");
        mal.setBounds(510,210,145,30);
        mal.setBackground(Color.WHITE);
        add(mal);
        ButtonGroup gender1=new ButtonGroup();
        gender1.add(mal);
        gender1.add(femal);
                
        
        JLabel email=new JLabel("Email :");
        email.setFont(new Font("Times New Roman",Font.BOLD,20));
        email.setBounds(150,250,300,30);
        add(email);
        
         emailtext=new JTextField("");
        emailtext.setBounds(350,250,300,30);
        add(emailtext);
        
          JLabel marital=new JLabel("Marital status :");
        marital.setFont(new Font("Times New Roman",Font.BOLD,20));
        marital.setBounds(150,290,300,30);
        add(marital);
          married=new JRadioButton("Married");
        married.setBounds(350,290,145,30);
        married.setBackground(Color.WHITE);
        add(married);
          unmarried=new JRadioButton("UnMarried");
         unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(510,290,145,30);
        add(unmarried);
        ButtonGroup married1=new ButtonGroup();
        married1.add(married);
        married1.add(unmarried);
         
        
         JLabel address=new JLabel("Address :");
        address.setFont(new Font("Times New Roman",Font.BOLD,20));
        address.setBounds(150,330,300,30);
        add(address);
        
         addresstext=new JTextField("");
        addresstext.setBounds(350,330,300,30);
        add(addresstext);
        
         JLabel city=new JLabel("City :");
        city.setFont(new Font("Times New Roman",Font.BOLD,20));
        city.setBounds(150,370,300,30);
        add(city);
        
          citytext=new JTextField("");
        citytext.setBounds(350,370,300,30);
        add(citytext);
        
         JLabel state=new JLabel("State :");
        state.setFont(new Font("Times New Roman",Font.BOLD,20));
        state.setBounds(150,410,300,30);
        add(state);
        
          statetext=new JTextField("");
        statetext.setBounds(350,410,300,30);
        add(statetext);
        
         JLabel pincode=new JLabel("Pin-Code :");
        pincode.setFont(new Font("Times New Roman",Font.BOLD,20));
        pincode.setBounds(150,450,300,30);
        add(pincode);
        
          pincodetext=new JTextField("");
        pincodetext.setBounds(350,450,300,30);
        add(pincodetext);
        
         next1=new JButton("Next");
        next1.setBounds(550,550,100,30);
        next1.setBackground(Color.BLUE);
        next1.setForeground(Color.WHITE);
        next1.addActionListener(this);
        add(next1);
        
        setSize(850,800);
        setVisible(true);
        setLocation(100,50);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String formnonn=" "+randnum;
        String name2=nametext.getText();
        String father=fathertext.getText();
        String dob1=((JTextField) dob.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(mal.isSelected())
        {
            gender="Male";
        }
        else if(femal.isSelected())
        {
            gender="Female";
        }
        String email=emailtext.getText();
        String marital=null;
        if(married.isSelected())
        {
            marital="Mrried";
        }
        else if(unmarried.isSelected())
        {
            marital="UnMarried";
        }
        String address=addresstext.getText();
        String city=citytext.getText();
        String state=statetext.getText();
        String pin=pincodetext.getText();
        
        try
        {
            if(name2.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Name not Filled ! ! !");
            }
            else
            {
                Conn c=new Conn();
                String query="insert into signup values('"+formnonn+"','"+name2+"','"+father+"','"+dob1+"','"+gender+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignTwo(formnonn).setVisible(true);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static void main(String args[])
    {
        SignupOne s1=new SignupOne();
    }
}
