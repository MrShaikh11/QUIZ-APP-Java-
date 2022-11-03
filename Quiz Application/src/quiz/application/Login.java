package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
 
    JButton rules, back;
    JTextField tfname;
    
    Login() {
//        getContentPane().setBackground(Color.WHITE);
        getContentPane().setBackground( new Color(246, 182, 180) );

        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login2.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 600, 500);
        add(image);
        
        JLabel heading = new JLabel("ENTER YOU NAME!");
        heading.setBounds(660, 60, 800, 150);
        heading.setFont(new Font("Phosphate", Font.BOLD, 60));
        heading.setForeground(new Color(252,248,241));
        add(heading);
        
//        JLabel name = new JLabel("Enter your name");
//        name.setBounds(810, 150, 300, 20);
//        name.setFont(new Font("Times New Roman", Font.BOLD, 18));
//        name.setForeground(Color.BLACK);
//        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(745, 200, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);
        
        rules = new JButton("RULES");
        rules.setBounds(765, 240, 120, 25);
        rules.addActionListener(this);
        add(rules);
        
        back = new JButton("EXIT");
        back.setBounds(915, 240, 120, 25);
 

        back.addActionListener(this);
        add(back);
        
        setSize(1200, 500);
        setLocation(160, 150);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}