import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;

class Voting_Machine extends JFrame implements ActionListener {
    JFrame fa;
    JTextField t[] = new JTextField[10];
    JButton b[]=new JButton[10];
    JTextField tc[] = new JTextField[10];
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JButton b9;
    JButton b10;
    JButton b11;
    JTextField tw;
    Scanner input = new Scanner(System.in);
    Font f = new Font("Courier New", Font.BOLD, 15);
    Font f1 = new Font("Algerian", Font.BOLD, 18);
    Font f2 = new Font("Adobe Caslon Pro Bold", Font.BOLD, 15);
    Font f3 = new Font("Adobe Caslon Pro Bold", Font.BOLD, 25);
    int i, high_Vote = 0,limit=0;
    int click[] = new int[10];
    Integer count[] = new Integer[10];
    Voting_Machine() {
        System.out.print("Enter The Number Of Candidates(Maximum 8 Candidates):");
        limit = input.nextInt();
        if(limit>8){
            System.out.println("Voting Machine Unable To Set-Up!!!(Limit Exceeded)");
            setVisible(false);
        }
        else{
        setLayout(null);
        setSize(680, 700);
        setVisible(true);
        // Labelling Part
        l1 = new JLabel("Candidate List");
        l1.setBounds(50, 50, 100, 50);
        l1.setFont(f2);
        l2 = new JLabel("Click To Vote");
        l2.setBounds(270, 50, 100, 50);
        l2.setFont(f2);
        l3 = new JLabel("Total Count");
        l3.setBounds(450, 50, 100, 50);
        l3.setFont(f2);
        l4 = new JLabel("ELECTRONIC VOTING MACHINE");
        l4.setFont(f1);
        l4.setBounds(180, 10, 300, 60);
        l5 = new JLabel("Winner");
        l5.setFont(f3);
        l5.setBounds(150, 520, 100, 50);
        
        int addT = 100;
        // Candidtae TextField Area
        for (i = 0; i < limit; i++) {
            t[i] = new JTextField();
            t[i].setBounds(50, addT, 150, 30);
            t[i].setFont(f);
            t[i].setHorizontalAlignment(JTextField.CENTER);
            add(t[i]);
            addT = addT + 50;
        }
        // Press Button Area
        int addB=105;
        for (i = 0; i < limit; i++)
        {
            b[i] = new JButton("Press");
            b[i].setBounds(270, addB, 70, 20);
            b[i].setBorder(new RoundedBorder(15));
            b[i].addActionListener(this);
            add(b[i]);
            addB = addB + 50;
        }
        // Result Button
        b9 = new JButton("Result");
        b9.setBounds(40, 600, 150, 40);
        b9.setBorder(new RoundedBorder(20));
        // Clear Button
        b10 = new JButton("Clear");
        b10.setBounds(400, 600, 150, 40);
        b10.setBorder(new RoundedBorder(20));
        // Vote Button
        b11 = new JButton("Vote");
        b11.setBounds(250, 600, 100, 40);
        b11.setBorder(new RoundedBorder(25));
        for (i = 0; i < 8; i++)
            count[i] = 0;
        for (i = 0; i < 8; i++)
            click[i] = 0;
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(b9);
        add(b10);
        add(b11);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        }
    }
    private static class RoundedBorder implements Border {

        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

    public void display_Result() {
        int res = 105;
        for (i = 0; i < this.limit; i++) {
            tc[i] = new JTextField();
            tc[i].setBounds(460, res, 50, 20);
            tc[i].setFont(f);
            tc[i].setHorizontalAlignment(JTextField.CENTER);
            add(tc[i]);
            res = res + 50;
        }

        for (i = 0; i < this.limit; i++) {
            add(tc[i]);
            tc[i].setText(count[i].toString());
        }
        tw = new JTextField();
        tw.setBounds(260, 528, 250, 30);
        add(tw);
        for (i = 0; i < this.limit;i++) {
            if (count[i] > high_Vote)
                high_Vote = count[i];
        }
        for (i = 0; i < this.limit; i++) {
            if (high_Vote == count[i]) {
                tw.setText(t[i].getText() + " With " + high_Vote + " Votes ");
                tw.setHorizontalAlignment(JTextField.CENTER);
                tw.setFont(f);
                break;
            }
        }
        JOptionPane.showMessageDialog(fa, "ThankYou For Using The App!!");
    }

    public void reset_Count() {
        for (i = 0; i < this.limit; i++) {
            count[i] = 0;
            tc[i].setText("");
        }
        for(i=0;i<this.limit;i++){
            b[i].setBackground(new JButton().getBackground());
        }
        tw.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b[0]) {
            if (click[0] != 0)
                JOptionPane.showMessageDialog(fa, "Not More Than One Vote Please!!");
            else {
                click[0]++;
                count[0]++;
                Toolkit.getDefaultToolkit().beep();
                b[0].setBackground(Color.green);
            }
        } else if (e.getSource() == b[1]) {
            if (click[1] != 0)
                JOptionPane.showMessageDialog(fa, "Not More Than One Vote Please!!");
            else {
                click[1]++;
                count[1]++;
                Toolkit.getDefaultToolkit().beep();
                b[1].setBackground(Color.green);
            }
        } else if (e.getSource() == b[2]) {
            if (click[2] != 0)
                JOptionPane.showMessageDialog(fa, "Not More Than One Vote Please!!");
            else {
                click[2]++;
                count[2]++;
                Toolkit.getDefaultToolkit().beep();
                b[2].setBackground(Color.green);
            }
        } else if (e.getSource() == b[3]) {
            if (click[3] != 0)
                JOptionPane.showMessageDialog(fa, "Not More Than One Vote Please!!");
            else {
                click[3]++;
                count[3]++;
                Toolkit.getDefaultToolkit().beep();
                b[3].setBackground(Color.green);
            }
        } else if (e.getSource() == b[4]) {
            if (click[4] != 0)
                JOptionPane.showMessageDialog(fa, "Not More Than One Vote Please!!");
            else {
                click[4]++;
                count[4]++;
                Toolkit.getDefaultToolkit().beep();
                b[4].setBackground(Color.green);
            }
        } else if (e.getSource() == b[5]) {
            if (click[5] != 0)
                JOptionPane.showMessageDialog(fa, "Not More Than One Vote Please!!");
            else {
                click[5]++;
                count[5]++;
                Toolkit.getDefaultToolkit().beep();
                b[5].setBackground(Color.green);
            }
        } else if (e.getSource() == b[6]) {
            if (click[6] != 0)
                JOptionPane.showMessageDialog(fa, "Not More Than One Vote Please!!");
            else {
                click[6]++;
                count[6]++;
                Toolkit.getDefaultToolkit().beep();
                b[6].setBackground(Color.green);
            }
        } else if (e.getSource() == b[7]) {
            if (click[7] != 0)
                JOptionPane.showMessageDialog(fa, "Not More Than One Vote Please!!");
            else {
                click[7]++;
                count[7]++;
                Toolkit.getDefaultToolkit().beep();
                b[7].setBackground(Color.green);
            }
        } else if (e.getSource() == b9) {
            display_Result();
        } else if (e.getSource() == b10)
            reset_Count();
        else if (e.getSource() == b11) {
            for(i=0;i<this.limit;i++){
                b[i].setBackground(new JButton().getBackground());
            }
            for (i = 0; i <this.limit; i++)
                click[i] = 0;
        }
    }

    public static void main(String args[]) {
        new Voting_Machine();
    }
}