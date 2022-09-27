
package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

import static java.awt.Color.black;
import static java.awt.Color.blue;

// to store my data in data we implennts ActionLIstener --?>import java.awt.event.*;
public class Signup extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField tfUserName;
    private JTextField tfName;
    private JTextField tfPassword;
    JTextField tfAnswer;
     JButton creat, back;
   JComboBox comboBox;
    Choice security;


    public static void main(String[] args) {
        new Signup().setVisible(true);
    }

    public Signup() {
        setBounds(330, 150, 720, 406);
        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        // user Name
        JLabel lblUsername = new JLabel("Username :");
        lblUsername.setForeground(Color.DARK_GRAY);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsername.setBounds(100, 86, 90, 26);
        contentPane.add(lblUsername);

        tfUserName = new JTextField();
        tfUserName.setBounds(265, 91, 148, 20);
//        textField.setColumns(10);
        tfUserName.setBorder(BorderFactory.createLineBorder(blue));
//        textField.setBorder(BorderFactory.createEmptyBorder()); // border empty
        contentPane.add(tfUserName);

        // NAme
        JLabel lblName = new JLabel("Name :");
        lblName.setForeground(Color.DARK_GRAY);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(100, 123, 90, 26);
        contentPane.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(265, 128, 148, 20);
        tfName.setBorder(BorderFactory.createLineBorder(blue));
        contentPane.add(tfName);

        //Password
        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setForeground(Color.DARK_GRAY);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(100, 160, 90, 26);
        contentPane.add(lblPassword);

        tfPassword = new JTextField();
//        textField_2.setColumns(10);
        tfPassword.setBounds(265, 165, 148, 20);
        tfPassword.setBorder(BorderFactory.createLineBorder(blue));
        contentPane.add(tfPassword);

        // Answer
        JLabel lblAnswer = new JLabel("Answer :");
        lblAnswer.setForeground(Color.DARK_GRAY);
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAnswer.setBounds(100, 234, 90, 26);
        contentPane.add(lblAnswer);


        tfAnswer = new JTextField();
//        textField_3.setColumns(10);
        tfAnswer.setBounds(265,  239, 148, 20);
        tfAnswer.setBorder(BorderFactory.createLineBorder(blue));
        contentPane.add(tfAnswer);

       /* // choice
        security = new Choice();
        security.add("Your NickName ?");
        security.add("Your Lucky Number ?");
        security.add("Your child SuperHero ?");
        security.add("Your childhood Name ?");
        security.setBounds(265, 202, 148, 20);
        contentPane.add(security);
        */

        // check Box
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
                "Your child SuperHero?", "Your childhood Name ?" }));
        comboBox.setBounds(265, 202, 148, 20);
        contentPane.add(comboBox);

        JLabel lblSecurityQuestion = new JLabel("Security Question :");
        lblSecurityQuestion.setForeground(Color.DARK_GRAY);
        lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSecurityQuestion.setBounds(99, 197, 140, 26);
        contentPane.add(lblSecurityQuestion);

        // add all text-field


        // add button
        creat = new JButton("Create");
        creat.addActionListener(this);  // --> to get action by this button  --> calls action perform method
        creat.setFont(new Font("Tahoma", Font.BOLD, 13));
        creat.setBounds(140, 289, 100, 30);
        creat.setBackground(Color.BLACK);
        creat.setForeground(Color.WHITE);
        contentPane.add(creat);

        back = new JButton("Back");
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 13));
        back.setBounds(300, 289, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        contentPane.add(back);

        // Image
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i1 = c1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
// NOTE:  image ko sidha jlabel me add nahi kr sakte usko image icon bnana pdta h
        JLabel l6 = new JLabel(i2);
        l6.setBounds(460, 70, 200, 200);
        add(l6);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
//        panel.setForeground(new Color(0x35358E));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create-Account",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
        panel.setBounds(31, 30, 640, 310);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);

        setVisible(true);
    }

    // abstract method of ActionListener
    public void actionPerformed(ActionEvent ae){

            if(ae.getSource() == creat){
                String username = tfUserName.getText();
                String name = tfName.getText();
                String password = tfPassword.getText();
                String question = (String) comboBox.getSelectedItem();
                String answer = tfAnswer.getText();

                try{
                    Conn c = new Conn(); // make connection stablest in cone class
                    // Executing the MySQL queries
                    String query = "insert into account values('"+username+"'  , '"+name+"'  , '"+password+"' , '"+question+"' , '"+answer+"' )  ";

                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null , "Account Created Successfully");
                    setVisible(false);
                    new login("");

                }catch (Exception e){
                    e.printStackTrace();
                }

               /* String sql = "insert into account(username, name, password, question, answer) values(?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, textField_1.getText());
                st.setString(3, textField_2.getText());
                st.setString(4, (String) comboBox.getSelectedItem());
                st.setString(5, textField_3.getText());

                int i = st.executeUpdate();
                if (i > 0){
                    JOptionPane.showMessageDialog(null, "Account Created Successfully ");
                }

                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");*/
            }
            else if(ae.getSource() == back){
                this.setVisible(false);
                new login("").setVisible(true);

            }


    }
}
