package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {
    JButton b1;
    JLabel l1;
    Font f, f1, f2;
    TextArea t1;
    String s;

    About(){
        setLayout(null);
        JButton b1 = new JButton("Exit");
        b1.setBounds(180, 430, 120, 20);
        setFont(new Font("RALEWAY", Font.BOLD, 180));
        b1.addActionListener(this);
        add(b1);

        s = "                                    About Projects          \n  "
                + "\n  The Project is Created By Ravikant Sahu     "
                + "\n        "
                + "\nThe objective of the Travel and Tourism Management System"
                + "project is to develop a system that automates the processes "
                + "and activities of a travel and the purpose is to design a "
                + "system using which one can perform all operations related to "
                + "traveling.\n\n"
                + "This application will help in accessing the information related "
                + "to the travel to the particular destination with great ease. "
                + "The users can track the information related to their tours with "
                + "great ease through this application. The travel agency information "
                + "can also be obtained through this application.\n\n"
                + "Advantages of Project:"
                + "\nGives accurate information"
                + "\nSimplifies the manual work"
                + "\nIt minimizes the documentation related work"
                + "\nProvides up to date information"
                + "\nFriendly Environment by providing warning messages."
                + "\ntravelers details can be provided"
                + "\nbooking confirmation notification"
        ;

        TextArea t1 = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        t1.setEditable(false);
        t1.setBounds(20, 100, 450, 300);
        t1.setFont( new Font("RALEWAY", Font.BOLD, 16));
        add(t1);

        Container contentPane = this.getContentPane();
        t1 = new TextArea();

        JLabel l1 = new JLabel("About Project");
        l1.setBounds(170, 10, 180, 80);
        l1.setForeground(Color.red);
        l1.setFont( new Font("RALEWAY", Font.BOLD, 20));
        add(l1);

        setBounds(300, 120, 500, 550);

        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        dispose();
        setVisible(false);
    }

    public static void main(String[] args) {
        new About();
    }


}
