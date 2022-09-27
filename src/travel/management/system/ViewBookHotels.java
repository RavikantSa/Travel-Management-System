package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewBookHotels extends JFrame   implements ActionListener {
    JButton back;
    JLabel labelusername , labelhotel , labelpersons , labelAC , labelfood  , labelprice,labelgender ;
    String username;
    public ViewBookHotels(String username) {
        this.username = username;
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(300 , 200 , 850 , 500);

        JLabel heading = new JLabel("BOOKED HOTEL DETAILS");
        heading.setFont(new Font("Yu Mincho", Font.BOLD, 25));
        heading.setBounds(70,0,550,25);
        add(heading);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        labelusername  = new JLabel();
        labelusername.setBounds(200,50,150,20);
        labelusername.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelusername);


        JLabel lblhotel = new JLabel("Hotel");
        lblhotel.setBounds(30,100,150,25);
        add(lblhotel);

        labelhotel = new JLabel();
        labelhotel.setBounds(200,100,150,25);
        labelhotel.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelhotel);

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30,150,150,25);
        add(lblpersons);
        labelpersons = new JLabel();
        labelpersons.setBounds(200,150,150,25);
        labelpersons.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelpersons);


        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setBounds(30,200,150,25);
        add(lbldays);
        JLabel labeldays = new JLabel();
        labeldays.setBounds(200,200,150,25);
        labeldays.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labeldays);

        JLabel lblAC= new JLabel("AC/ Non-AC");
        lblAC.setBounds(30,250,150,25);
        add(lblAC);
        labelAC = new JLabel();
        labelAC.setBounds(200,250,150,25);
        labelAC.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelAC);

        JLabel lblfood = new JLabel("Meal Included");
        lblfood.setBounds(30,300,150,25);
        add(lblfood);
        labelfood = new JLabel();
        labelfood.setBounds(200,300,150,25);
        labelfood.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelfood);

        JLabel lblprice = new JLabel("Total Price");
        lblprice.setBounds(30,350,150,25);
        add(lblprice);

        labelprice = new JLabel();
        labelprice.setBounds(200,350,150,25);
        labelprice.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelprice);


        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(150,400,200,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel8.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,-250,400,900);
        add(image);



        try {

            Conn conn = new Conn();
            String  query = "select * from bookhotel where username = '"+username+"' ";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                labelhotel.setText(rs.getString("Hotel"));
                labelpersons.setText(rs.getString("person"));
                labeldays.setText(rs.getString("days"));
                labelAC.setText(rs.getString("AC"));
                labelfood.setText(rs.getString("food"));
                labelprice.setText(rs.getString("price"));

            }
        }
        catch (Exception e){
            e.printStackTrace();;
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewBookHotels("");
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back ){
            setVisible(false);
//            new Dashboard(username);
        }
    }
}
