package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground( new Color(246, 182, 180) );
        setLayout(null);
        
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
//        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(0, 200, 300, 250);
//        add(image);
        
        JLabel heading = new JLabel("Thank you " + name + " for playing Marathon Quiz!");
        heading.setBounds(80, 60, 10000, 150);
        heading.setFont(new Font("Phosphate", Font.BOLD, 44));
        heading.setForeground(new Color(252,248,241));
        add(heading);
        
        JLabel lblscore = new JLabel("Your score is: " + score);
        lblscore.setBounds(450, 200, 300, 30);
        lblscore.setFont(new Font("Phosphate", Font.PLAIN, 36));
        add(lblscore);
        
        JButton submit = new JButton("PLAY AGAIN!");
        submit.setBounds(520, 240, 120, 30);
        submit.addActionListener(this);
        add(submit);
        
        setSize(1200, 500);
        setLocation(160, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}