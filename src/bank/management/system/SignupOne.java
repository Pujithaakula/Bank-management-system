package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

    

public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser dateChooser;
    
    SignupOne(){
        
        setLayout(null);
        Random ran = new Random();
        random = Math.abs(ran.nextLong()% 9000L + 1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO."+random);
        
        formno.setFont(new Font("Raley",Font.BOLD,21));
        formno.setBounds(260,20,600,40);
        add(formno);
        
        JLabel personaldetails = new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("Raley",Font.BOLD,18));
        personaldetails.setBounds(290,60,400,30);
        add(personaldetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raley",Font.BOLD,20));
        name.setBounds(100,110,100,30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raley",Font.BOLD,14));
        nameTextField.setBounds(300,110,400,30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raley",Font.BOLD,20));
        fname.setBounds(100,160,400,30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raley",Font.BOLD,14));
        fnameTextField.setBounds(300,160,400,30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raley",Font.BOLD,20));
        dob.setBounds(100,210,400,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,210,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raley",Font.BOLD,20));
        gender.setBounds(100,260,300,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,260,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450,260,120,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raley",Font.BOLD,20));
        email.setBounds(100,310,300,30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Rafel",Font.BOLD,14));
        emailTextField.setBounds(300,310,400,30);
        add(emailTextField);
        
        JLabel martial = new JLabel("Martial Status:");
        martial.setFont(new Font("Raley",Font.BOLD,20));
        martial.setBounds(100,360,300,30);
        add(martial);
        
        married = new JRadioButton("married");
        married.setBounds(300,360,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(460,360,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(630,360,100,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup martialgp = new ButtonGroup();
        martialgp.add(married);
        martialgp.add(unmarried);
        martialgp.add(other);
                
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raley",Font.BOLD,20));
        address.setBounds(100,410,300,30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Rafel",Font.BOLD,14));
        addressTextField.setBounds(300,410,400,30);
        add(addressTextField);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raley",Font.BOLD,20));
        city.setBounds(100,460,300,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Rafel",Font.BOLD,14));
        cityTextField.setBounds(300,460,400,30);
        add(cityTextField);
                 
        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raley",Font.BOLD,20));
        pincode.setBounds(100,510,300,30);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Rafel",Font.BOLD,14));
        pincodeTextField.setBounds(300,510,400,30);
        add(pincodeTextField);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raley",Font.BOLD,20));
        state.setBounds(100,560,300,30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Rafel",Font.BOLD,14));
        stateTextField.setBounds(300,560,400,30);
        add(stateTextField);
        
        
        
        
        
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(650,610,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formno = ""+ random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if (female.isSelected()){
            gender = "Female";
        }
        String email = emailTextField.getText();
        String martial = null;
        if(married.isSelected()){
            martial = "Married";
        }else if(unmarried.isSelected()){
            martial = "Unmarried";
        }else if(other.isSelected()){
              martial = "Other"; 
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pincodeTextField.getText();
        
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else{
                conn c = new conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+martial+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String args[]) {
        new SignupOne();
    }
}