package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField t1,t2;
    JButton b1,b2;                               
    JLabel text,pintext,repin;
    String pinchange;
    PinChange(String pinchange){
        this.pinchange = pinchange;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(280,330,800,35);
        image.add(text);
        
        pintext = new JLabel("New PIN:");
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(180,390,150,35);
        image.add(pintext);
        
        repin = new JLabel("Re-Enter New PIN:");
        repin.setFont(new Font("System", Font.BOLD, 16));
        repin.setForeground(Color.WHITE);
        repin.setBounds(180,440,200,35);
        image.add(repin);
        
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        t1.setBounds(330,400,180,25);
        image.add(t1);
        
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        t2.setBounds(330,440,180,25);
        image.add(t2);
        
        b1 = new JButton("CHANGE");
        b1.setBounds(350,520,150,35);
        b1.addActionListener(this);
        image.add(b1);
        
        
        b2 = new JButton("BACK");
        b2.setBounds(180,520,150,35);
        b2.addActionListener(this);
        image.add(b2);     
        
        setLayout(null);
                 
        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String npin = t1.getText();
            String rpin = t2.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(ae.getSource()==b1){
                if (t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (t2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                conn c1 = new conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pinchange+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pinchange+"' ";
                String q3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinchange+"' ";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            
            }else if(ae.getSource()==b2){
                new Transactions(pinchange).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        new PinChange("").setVisible(true);
    }
}
