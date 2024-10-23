package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

    

public class SignupTwo extends JFrame implements ActionListener{
   
    JTextField PanTextField,aadharTextField;
    JButton next;
    JRadioButton sno,syes;
    JComboBox religion,categorybox,incomebox,valEduQualbox,occupbox;
    String formno;
    
    SignupTwo(String formno){
        
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW  APPILICATION FORM - PAGE 2");
       
        
        JLabel personaldetails = new JLabel("Page 2: Additional Details");
        personaldetails.setFont(new Font("Raley",Font.BOLD,22));
        personaldetails.setBounds(260,20,600,40);
        add(personaldetails);
        
        JLabel Religion = new JLabel("Religion:");
        Religion.setFont(new Font("Raley",Font.BOLD,20));
        Religion.setBounds(100,70,100,30);
        add(Religion);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Chirstian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,70,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
              
        
        JLabel Category = new JLabel("Category:");
        Category.setFont(new Font("Raley",Font.BOLD,20));
        Category.setBounds(100,130,400,30);
        add(Category);
        
        String valCategory[] = {"General","OBC","SC","ST","Other"};
        categorybox = new JComboBox(valCategory);
        categorybox.setBounds(300,130,400,30);
        categorybox.setBackground(Color.white);
        add(categorybox);
        
        JLabel Income = new JLabel("Income:");
        Income.setFont(new Font("Raley",Font.BOLD,20));
        Income.setBounds(100,190,400,30);
        add(Income);
        
        
        String valincome[] = {"NULL","<1,50,000","<2,50,000","<5,00000","Upto 10,00,000",""};
        incomebox = new JComboBox(valincome);
        incomebox.setBounds(300,190,400,30);
        incomebox.setBackground(Color.white);
        add(incomebox);
        
        
        JLabel eductationalqual = new JLabel("Educational");
        eductationalqual.setFont(new Font("Raley",Font.BOLD,20));
        eductationalqual.setBounds(100,250,300,30);
        add(eductationalqual);
        
        JLabel qual = new JLabel("Qualification :");
        qual.setFont(new Font("Raley",Font.BOLD,20));
        qual.setBounds(100,280,300,30);
        add(qual);
        

        String valEduQual[] = {"Non-Graduaction","Graduate","Post-Graduation","Doctorate","Other"};
        valEduQualbox = new JComboBox(valEduQual);
        valEduQualbox.setBounds(300,260,400,30);
        valEduQualbox.setBackground(Color.white);
        add(valEduQualbox);
        
        JLabel martial = new JLabel("Occupation:");
        martial.setFont(new Font("Raley",Font.BOLD,20));
        martial.setBounds(100,330,300,30);
        add(martial);
        
        String Occupval[] = {"Salaried","Self-Employed","Business","Student","Retired","Other"};
        occupbox = new JComboBox(Occupval);
        occupbox.setBounds(300,330,400,30);
        occupbox.setBackground(Color.white);
        add(occupbox);
                
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raley",Font.BOLD,20));
        pan.setBounds(100,380,300,30);
        add(pan);
        
        PanTextField = new JTextField();
        PanTextField.setFont(new Font("Rafel",Font.BOLD,14));
        PanTextField.setBounds(300,380,400,30);
        add(PanTextField);
        
        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raley",Font.BOLD,20));
        aadhar.setBounds(100,430,300,30);
        add(aadhar);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Rafel",Font.BOLD,14));
        aadharTextField.setBounds(300,430,400,30);
        add(aadharTextField);
        
        JLabel srcitizen = new JLabel("Senior citizen:");
        srcitizen.setFont(new Font("Raley",Font.BOLD,20));
        srcitizen.setBounds(100,480,300,30);
        add(srcitizen);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,480,100,30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(400,480,100,30);
        sno.setBackground(Color.white);
        add(sno);
                 
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raley",Font.BOLD,20));
        pincode.setBounds(100,530,300,30);
        add(pincode);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,530,100,30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(400,530,100,30);
        sno.setBackground(Color.white);
        add(sno);
 
        
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,580,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String) religion.getSelectedItem();
        String category = (String) categorybox.getSelectedItem();
        String income = (String) incomebox.getSelectedItem();
        String educational = (String) valEduQualbox.getSelectedItem();
        String occupational = (String) occupbox.getSelectedItem();
        
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }else if (sno.isSelected()){
            seniorcitizen = "No";
        }
        String existingaccount = null;
        if(syes.isSelected()){
            existingaccount = "Yes";
        }else if(sno.isSelected()){
           existingaccount= "No";
        }
        
        String pan = PanTextField.getText();
        String aadharno = aadharTextField.getText();
        
        try {
            conn c = new conn();
            String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+category+"','"+income+"','"+educational+"','"+occupational+"','"+pan+"','"+aadharno+"','"+seniorcitizen+"','"+existingaccount+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        } catch (Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String args[]) {
        new SignupTwo("");
    }
}