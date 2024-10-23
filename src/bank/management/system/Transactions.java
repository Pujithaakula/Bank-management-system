package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
     
    JButton deposit,Withdrawl,fastcash,ministatement,balanceenquiry,pinchange,exit;
    String pin;
    
       Transactions(String pin) {
           this.pin = pin;
           
           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
           Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
           ImageIcon i3 = new ImageIcon(i2);
           JLabel image = new JLabel(i3);
           add(image);
           
           JLabel text = new JLabel("Please select your Transactions");
           text.setBounds(210,310,700,35);
           text.setForeground(Color.white);
           text.setFont(new Font("System",Font.BOLD,16));
           image.add(text);
           
           deposit = new JButton("Deposit");
           deposit.setBounds(170,420,150,30);
           deposit.addActionListener(this);
           image.add(deposit);
           
           Withdrawl = new JButton("Cash Withdrawal");
           Withdrawl.setBounds(355,420,150,30);
           Withdrawl.addActionListener(this);
           image.add(Withdrawl);
           
           fastcash = new JButton("Fast Cash");
           fastcash.setBounds(170,455,150,30);
           fastcash.addActionListener(this);
           image.add(fastcash);
           
           ministatement = new JButton("Mini Statement");
           ministatement.setBounds(355,455,150,30);
           ministatement.addActionListener(this);
           image.add(ministatement);
           
           
           
           balanceenquiry = new JButton("Balance Enquiry");
           balanceenquiry.setBounds(170,490,150,30);
           balanceenquiry.addActionListener(this);
           image.add(balanceenquiry);
           
           pinchange = new JButton("Pin Change");
           pinchange.setBounds(355,490,150,30);
           pinchange.addActionListener(this);
           image.add(pinchange);
           
           exit = new JButton("Exit");
           exit.setBounds(355,525,150,30);
           exit.addActionListener(this);
           image.add(exit );
           
           setSize(900,900);
           setLocation(300,0);
           setUndecorated(true);
           setVisible(true);
       }
       
       public void actionPerformed(ActionEvent ae){
           if(ae.getSource() == exit){
               System.exit(0);          
            }else if(ae.getSource() == deposit){
                setVisible(false);
                new Deposit(pin).setVisible(true);
            }else if(ae.getSource() == Withdrawl){
                setVisible(false);
                new Withdrawl(pin).setVisible(true);
            }else if(ae.getSource() == fastcash){
                setVisible(false);
                new FastCash(pin).setVisible(true);
            }else if(ae.getSource() == pinchange){
                setVisible(false);
                new PinChange(pin).setVisible(true);
            }else if (ae.getSource() == balanceenquiry){
                setVisible(false);
                new BalanceEnquiry(pin).setVisible(true);
            }else if(ae.getSource() == ministatement){
                setVisible(false);
                new MiniStatement(pin).setVisible(true);
            }
           
        } 
   public static void main(String args[]) {
       new Transactions("");
       
    }
}
