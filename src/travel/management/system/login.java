package travel.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JButton password , login , signup;
    JTextField  tfusername , tfupassword ;
//    String username;
    login(String usernamee){
        setSize(900 , 400);
        setLocation(220 , 120);

        setLayout(null); // mot want to use swing layout
//        getContentPane().setBackground(Color.white);

        // left pannel
        JPanel p1 = new JPanel();
        p1.setBackground(new Color( 131,193,233));
        p1.setBounds( 0 , 0 , 450 , 400);  // location on pannel
        p1.setLayout(null);
        add(p1);

// PUT image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200 , 200 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(120 ,85,200,200);
        p1.add(image);


        // RIGHT PANEL
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(450,0,450,400);
        p2.setBackground(Color.LIGHT_GRAY);
        add(p2);

        //  Text Pannel or Label
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60 ,30,100,25);
        lblusername.setFont(new Font("SAN_SERIF" , Font.PLAIN, 22));
        p2.add(lblusername);

        // input box , textfield
        tfusername = new JTextField();
        tfusername.setBounds(60,70, 300 , 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);


        //password
        //  Text Pannel or Label
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60 ,120,100,25);
        lblpassword.setFont(new Font("SAN_SERIF" , Font.PLAIN, 22));
        p2.add(lblpassword);

        // input box , textfield -> fill usrername
         tfupassword = new JTextField();
        tfupassword.setBounds(60,160, 300 , 30);
        tfupassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfupassword);

        // creat Buttons for login
        login = new JButton("Login");
        login.setBounds(60,220 , 120,35);
        login.setBackground(new Color( 133, 193,233)); // background colour change
        login.setForeground(Color.BLACK);  // font background
        login.setBorder(new LineBorder( new Color(133 , 193 ,233)));
        login.addActionListener(this);
        p2.add(login);

        // creat Buttons for Signup
        signup = new JButton("Sigup");
        signup.setBounds(240,220 , 120,35);
        signup.setBackground(new Color( 133, 193,233)); // background colour change
        signup.setForeground(Color.BLACK);  // font background
        signup.setBorder(new LineBorder( new Color(133 , 193 ,233)));
        signup.addActionListener(this);
        p2.add(signup);

        // creat Buttons for Signup
         password = new JButton("Forget Password");
        password.setBounds(150,280 , 120,35);
        password.setBackground(new Color( 133, 193,233)); // background colour change
        password.setForeground(Color.BLACK);  // font background
        password.setBorder(new LineBorder( new Color(133 , 193 ,233)));
        password.addActionListener(this);
        p2.add(password);

        // sidr message
        JLabel text = new JLabel("Troubel in Login..");
        text.setBounds(280 ,290,120,20);
        text.setForeground(Color.RED);
        text.setFont(new Font("SAN_SERIF" , Font.PLAIN, 15));
        p2.add(text);



        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
//            setVisible(false);
            try{
              String  username = tfusername.getText();
                String pass = tfupassword.getText();

                String query = "select * from account where username =  '"+ username+"' AND password ='"+pass+"'  ";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Loading(username);
                }
                else{
                    JOptionPane.showMessageDialog(null , "Incorrect username or password");
                }

            }
            catch(Exception ae){
                ae.printStackTrace();
            }


        }
        else if( e.getSource() == signup){
            setVisible(false);
            Signup su = new Signup();
            su.setVisible(true);
        }
        else if(e.getSource() == password ){
            setVisible(false);
            Forgetpassword forgot = new Forgetpassword();
            forgot.setVisible(true);
        }
    }
    public static void main(String[] args) {
        new login("").setVisible(true);
    }


}
