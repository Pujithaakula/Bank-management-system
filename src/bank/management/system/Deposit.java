package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposit,back;
    JLabel text;
    String pin;
    Deposit(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0, 0, 900,900);
        add(image);
        
        text = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(185,300,400,35);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(190,370,320,25);
        image.add(amount);
        
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(350,450,150,35);
        image.add(deposit);
        deposit.addActionListener(this);
        
        
        back= new JButton("BACK");
        back.setBounds(350,490,150,35);
        image.add(back);       
        back.addActionListener(this);
        
        setSize(900,900);
        setUndecorated(true);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==deposit){
                String number = amount.getText();
                Date date = new Date();
                if(text.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    try{
                    conn c1 = new conn();
                    String query = "insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+number+"')";
                    c1.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+number+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }catch(Exception e)
                {
                   System.out.println(e);
                }
            }
}           else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }
    
    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}
