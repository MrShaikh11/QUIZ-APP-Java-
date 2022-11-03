package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{

    String name;
    JButton start, back;
    
    Rules(String name) {
        this.name = name;
        getContentPane().setBackground( new Color(246, 182, 180) );
        
        setLayout(null);
        
        JLabel heading = new JLabel(name + ", these are the rules for the Marathon Quiz");
        heading.setBounds(140, 20, 1000, 50);
        heading.setFont(new Font("Phosphate", Font.BOLD, 39));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        JLabel rules = new JLabel();
        rules.setBounds(60, 80, 700, 400);
        rules.setFont(new Font("Impact", Font.PLAIN, 24));
        rules.setForeground(new Color(252,248,241));
        rules.setText(
            "<html>"+ 
                "1. You can use the 50/50 helpline only once" + "<br><br>" +
                "2. There is a timer of 15 seconds for each question" + "<br><br>" +
                "3. All the questions are compulsory" + "<br><br>" +
                "4. If you get all the answers correct you will receive a gift hamper" + "<br><br>" +
                "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                "6. Good Luck!"+"<br><br>" +
            "<html>"
        );
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(1000, 400, 80, 30);
        back.addActionListener(this);
        add(back);
        
        start = new JButton("Start");
        start.setBounds(1100, 400, 80, 30);
        start.addActionListener(this);
        add(start);
        
        setSize(1200, 500);
        setLocation(160, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args) {
        new Rules("User");
    }
}