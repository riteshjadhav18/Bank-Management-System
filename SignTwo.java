
package bankmanagementsystem;


//package bankmanagementsystem;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignTwo extends JFrame implements ActionListener {
    
    JTextField incometext,pan,adhartext;
   
    JRadioButton act,act2,sr1,sr2;
    JComboBox comboReg,combocat,combedu,combocc;
    JButton next1;
    String formno;
    SignTwo(String formno)
    {
        this.formno=formno;
        setTitle("New Application Form : 2");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
       
        JLabel formno11=new JLabel("Application Form no :"+formno);
        formno11.setFont(new Font("Times New Roman",Font.BOLD,30));
        formno11.setBounds(200,20,400,30);
        add(formno11);
        
        JLabel additionaldetail=new JLabel("page :2 Additional Details ");
        additionaldetail.setFont(new Font("Times New Roman",Font.BOLD,20));
        additionaldetail.setBounds(280,50,300,30);
        add(additionaldetail);
        
        JLabel religion=new JLabel("Religion :");
        religion.setFont(new Font("Times New Roman",Font.BOLD,20));
        religion.setBounds(150,90,300,30);
        add(religion);
        
        String valReligion[]={"Hindu","Muslim","Seek","Christan","Other"};
        comboReg=new JComboBox(valReligion);
        comboReg.setBounds(350,90,300,30);
        add(comboReg);
        
        JLabel category=new JLabel("Category :");
        category.setFont(new Font("Times New Roman",Font.BOLD,20));
        category.setBounds(150,130,300,30);
        add(category);
        
         String valcat[]={"OBC","SC","ST","OPEN","EWS","Other"};
        combocat=new JComboBox(valcat);
        combocat.setBounds(350,130,300,30);
        add(combocat);
        
        JLabel income=new JLabel("Income :");
        income.setFont(new Font("Times New Roman",Font.BOLD,20));
        income.setBounds(150,170,300,30);
        add(income);
        
        incometext=new JTextField();
        incometext.setBounds(350,170,300,30);
        add(incometext);
        
        
        JLabel gender=new JLabel("Educational  :");
        gender.setFont(new Font("Times New Roman",Font.BOLD,20));
        gender.setBounds(150,210,300,30);
        add(gender);
        
        JLabel quali=new JLabel("Qualification ");
        quali.setFont(new Font("Times New Roman",Font.BOLD,20));
        quali.setBounds(150,225,300,30);
        add(quali);
        
         String valedu[]={"Under Graguate","Post Graguate","MBBS","Other"};
        combedu=new JComboBox(valedu);
        combedu.setBounds(350,220,300,30);
        add(combedu);
        
          JLabel occupation=new JLabel("Occupition :");
        occupation.setFont(new Font("Times New Roman",Font.BOLD,20));
        occupation.setBounds(150,265,300,30);
        add(occupation);
        String occ[]={"Farmer","Engineer","Doctor","Police","Constructor","Other"};
        combocc=new JComboBox(occ);
        combocc.setBounds(350,265,300,30); 
       
        add(combocc);
       
      
         
        
         JLabel pannum=new JLabel("PAN Number :");
        pannum.setFont(new Font("Times New Roman",Font.BOLD,20));
        pannum.setBounds(150,305,300,30);
        add(pannum);
        
         pan=new JTextField("");
        pan.setBounds(350,305,300,30);
        add(pan);
        
         JLabel city=new JLabel("Adhar Number :");
        city.setFont(new Font("Times New Roman",Font.BOLD,20));
        city.setBounds(150,345,300,30);
        add(city);
        
         adhartext=new JTextField("");
        adhartext.setBounds(350,345,300,30);
        add(adhartext);
        
         JLabel state=new JLabel("Senior Citizen :");
        state.setFont(new Font("Times New Roman",Font.BOLD,20));
        state.setBounds(150,385,300,30);
        add(state);
        
        sr1=new JRadioButton("Yes");
        sr2=new JRadioButton("No");
      
        sr1.setBounds(350,385,140,30);
        add(sr1);
         sr2.setBounds(510,385,140,30);
        add(sr2);
        ButtonGroup bg=new ButtonGroup();
        bg.add(sr1);
        bg.add(sr2);
         JLabel pincode=new JLabel("Existing Account :");
        pincode.setFont(new Font("Times New Roman",Font.BOLD,20));
        pincode.setBounds(150,425,300,30);
        add(pincode);
        
        act=new JRadioButton("Yes");
        act2=new JRadioButton("No");
      
        act.setBounds(350,425,140,30);
        add(act);
         act2.setBounds(510,425,140,30);
        add(act2);
        ButtonGroup bg2=new ButtonGroup();
        bg2.add(act);
        bg2.add(act2);
        
        
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
        //String formno=" "+randnum;
        String regionselect=(String)comboReg.getSelectedItem();
        String category=(String)combocat.getSelectedItem();
        String income1=incometext.getText();
       String eduqualification=(String)combedu.getSelectedItem();
       String occuption=(String)combocc.getSelectedItem();
       String panno=pan.getText();
       String adharno=adhartext.getText();
       String srcitizen=null;
        if(sr1.isSelected())
        {
            srcitizen="Yes";
        }
        else if(sr2.isSelected())
        {
            srcitizen="No";
        }
         String account=null;
        if(act.isSelected())
        {
            account="Yes";
        }
        else if(act2.isSelected())
        {
            account="No";
        }  
        try
        {
            if(category.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Category not choosen! ! !");
            }
            else
            {
                Conn c2=new Conn();
                //String query1="insert into signuppage2 values('"+formno+"','"+regionselect+"','"+category+"','"+income1"','"+eduqualification+"','"+occuption+"','"+panno+"','"+adharno+"','"+srcitizen+"','"+account+"')";
                String str="insert into signuppage2 values('"+formno+"','"+regionselect+"','"+category+"','"+income1+"','"+eduqualification+"','"+occuption+"','"+panno+"','"+adharno+"','"+srcitizen+"','"+account+"')";
                c2.s.executeUpdate(str);
                 setVisible(false);
                new SignupThree(formno);
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String args[])
    {
        SignTwo s1=new SignTwo("");
    }
  
}

