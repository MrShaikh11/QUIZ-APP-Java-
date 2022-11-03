package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 20;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
//        getContentPane().setBackground(Color.WHITE);
    getContentPane().setBackground( new Color(246, 182, 180) );
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 290);
        add(image);

//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
//        JLabel image = new JLabel(i1);
//        image.setBounds(0, 0, 600, 500);
//        add(image);
        
        qno = new JLabel();
        qno.setBounds(50, 450, 50, 30);
        qno.setFont(new Font("Arial Black", Font.PLAIN, 20));
        add(qno);
        
        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Arial Black", Font.PLAIN, 24));
        add(question);
        
        questions[0][0] = "Who is the prime minister of India?";
        questions[0][1] = "Rahul Gandhi";
        questions[0][2] = "Narendra Modi";//answer
        questions[0][3] = "Salman Khan";
        questions[0][4] = "MC Stan";

        questions[1][0] = "What is Mahatma Gandhi called?";
        questions[1][1] = "Father of the Nation";//answer
        questions[1][2] = "Donald Trump";
        questions[1][3] = "Bhaijaan";
        questions[1][4] = "Chacha Ji";

        questions[2][0] = "Who is the father of the Indian Constitution?";
        questions[2][1] = "Dr. B. R. Ambedkar";//answer
        questions[2][2] = "Emiway";
        questions[2][3] = "Salman Khan";
        questions[2][4] = "Jawaharlal Nehru";

        questions[3][0] = "Who was the first Prime Minister of India?";
        questions[3][1] = "Narendra Modi";
        questions[3][2] = "Bill Gates";
        questions[3][3] = "Jawaharlal Nehru";//answer
        questions[3][4] = "Abdul Kalam";

        questions[4][0] = "Who was the first woman prime minister of India";
        questions[4][1] = "Amit Shah";
        questions[4][2] = "Katrina Kaif";
        questions[4][3] = "Mary Kom";
        questions[4][4] = "Indira Gandhi";//answer

        questions[5][0] = "In what year did the quit India movement begin?";
        questions[5][1] = "1999";
        questions[5][2] = "1942";//answer
        questions[5][3] = "1947";
        questions[5][4] = "2022";

        questions[6][0] = "APJ Abdul Kalam was an ____?";
        questions[6][1] = "aerospace scientist";//answer
        questions[6][2] = "mechanic";
        questions[6][3] = "singer";
        questions[6][4] = "dancer";

        questions[7][0] = "In what year did India get Independence?";
        questions[7][1] = "2022";
        questions[7][2] = "1947";//answer
        questions[7][3] = "1919";
        questions[7][4] = "Never";

        questions[8][0] = "Who is the president of India?";
        questions[8][1] = "Droupadi Murmu";//answer
        questions[8][2] = "Imran Khan";
        questions[8][3] = "Kim Jon Un";
        questions[8][4] = "Misbah Mujawar";

        questions[9][0] = "Who is the education minister of India?";
        questions[9][1] = "Dharmendra Pradhan";//asnwer
        questions[9][2] = "Bradd Pitt";
        questions[9][3] = "Amit Shah";
        questions[9][4] = "Arvind Kejriwal";
        
        answers[0][1] = "Narendra Modi";
        answers[1][1] = "Father of the Nation";
        answers[2][1] = "Dr. B. R. Ambedkar";
        answers[3][1] = "Jawaharlal Nehru";
        answers[4][1] = "Indira Gandhi";
        answers[5][1] = "1942";
        answers[6][1] = "aerospace scientist";
        answers[7][1] = "1947";
        answers[8][1] = "Droupadi Murmu";
        answers[9][1] = "Dharmendra Pradhan";
        
        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.BLACK);
        opt4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        add(opt4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1100, 500, 200, 40);
        next.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        next.addActionListener(this);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 560, 200, 40);
        lifeline.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setBounds(1100, 620, 200, 40);
        submit.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        
        start(count);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            
            setVisible(false);
            new Score(name, score);
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Impact", Font.BOLD, 30));
        
        if (timer > 0) { 
            g.drawString(time, 1050, 500);
        } else {
            g.drawString("Times up!!", 1050, 500);
        }
        
        timer--; // 14
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ans_given == 1) {
            ans_given = 0;
            timer = 20;
        } else if (timer < 0) {
            timer = 20;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }
        
    }
    
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new Quiz("User");
    }
}