package travel.management.system;
///*
import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements  Runnable{
    Thread t;
    private JProgressBar bar;

String usernamee;
    public void setUploading() {
        setVisible(false);
        t.start();
    }

    public void run() {
        try {
            for (int i = 0; i < 200; i++) {

                int m =  bar.getMaximum();
                int v =  bar.getValue();
                if (v < m) {
                    bar.setValue( bar.getValue() + 1);
                } else {
                    i = 201;
                    setVisible(false);
                    new Dashboard(usernamee).setVisible(true);
//                    new Home(username).setVisible(true);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    Loading( String usernamee){
        this.usernamee = usernamee;
        // run method ko call krta h thread class
        /// creat threat obj
        t = new Thread( this);

        setBounds( 500 , 200 , 650 , 400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel text = new JLabel("Travel and tourisam Application");
        text.setBounds(50 , 20 , 600 , 40);
        text.setForeground(new Color(72, 209, 204));
        text.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        add(text);

        // prgress bar
        bar = new JProgressBar();
        bar.setFont(new Font("Tahoma", Font.BOLD, 12));
        bar.setStringPainted(true);
        bar.setBounds(150 , 100 , 300 , 35);
        bar.setStringPainted(true);
        add(bar);

        // please wait
        JLabel loading = new JLabel("Loading Please wait...");
        loading.setBounds(180 , 140 , 350 , 30);
        loading.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        loading.setForeground(new Color(160, 82, 45));
        add(loading);

        JLabel username = new JLabel("Welcome "+usernamee+"");
        username.setBounds(40 , 310 , 400 , 30);
        username.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
        username.setFont(new Font("Raleway" , Font.BOLD , 35));
        add(username);

        t.start();
        setVisible(true);

    }
    public static void main(String[] args) {
        new Loading("");
    }
}
//*/

/*
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable {

    private JPanel contentPane;
    private JProgressBar progressBar;
    Connection conn;
    String username;
    int s;
    Thread th;

    public static void main(String[] args) {
        new Loading("").setVisible(true);
    }

    public void setUploading() {
        setVisible(false);
        th.start();
    }

    public void run() {
        try {
            for (int i = 0; i < 200; i++) {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if (v < m) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 201;
                    setVisible(false);
//                    new Home(username).setVisible(true);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Loading(String username) {
        this.username = username;
        th = new Thread((Runnable) this);

        setBounds(600, 300, 600, 400);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(51,204, 255));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbllibraryManagement = new JLabel("Travel and Toursim Application");
        lbllibraryManagement.setForeground(new Color(72, 209, 204));
        lbllibraryManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        lbllibraryManagement.setBounds(50, 46, 700, 35);
        contentPane.add(lbllibraryManagement);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130, 135, 300, 25);
        contentPane.add(progressBar);

        JLabel lblNewLabel_2 = new JLabel("Please Wait....");
        lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lblNewLabel_2.setForeground(new Color(160, 82, 45));
        lblNewLabel_2.setBounds(200, 165, 150, 20);
        contentPane.add(lblNewLabel_2);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(10, 10, 580, 380);
        contentPane.add(panel);

        setUndecorated(true);
        setUploading();
    }
}
*/
