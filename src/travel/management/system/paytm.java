package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.ECField;

public class paytm extends JFrame implements  ActionListener {
    JButton back;
    paytm(){
//        setLayout(null);
//        getContentPane().setBackground(Color.white);
        setBounds(300 , 100 , 850 , 650);

        // jtext area  and   jeditior
        JEditorPane j = new JEditorPane();
        j.setEnabled(false);

        try{
//        j.setPage( "https://paytm.com/rent-payment" );
////        j.setPage( "https://paytm.me/k1-gsFn" );

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Offline Merchant.png"));
            Image i2 = i1.getImage().getScaledInstance(450 , 600 , Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(30 ,0,450,600);
            j.add(image);

        }
        catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load</html>");
        }

        // add Scroll bar
        JScrollPane scrollPane = new JScrollPane(j);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(scrollPane);

        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setBounds(600 , 30 , 100 , 30);
        back.addActionListener(this);
       j.add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new paytm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}
