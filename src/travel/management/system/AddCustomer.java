package travel.management.system;
//lLecture 9
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener {
   ButtonGroup gendergroup;
    JRadioButton male, female;
    JLabel lblusername ,  lblname ,  gender;
    JTextField tfNumber , tfcountry , tfphone , tfemail;
    JComboBox comboid;
    JButton back, add;

    JLabel labelname  , labelusername ; // error
//  JTextField labelname  , labelusername;
String usrenamee;
    AddCustomer(String usrenamee){
     this.usrenamee = usrenamee;
        setLayout(null);
       getContentPane().setBackground(Color.white);
        setBounds(300 , 200 , 850 , 450);

        lblusername = new JLabel("Username :");
        lblusername.setForeground(Color.BLACK);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblusername.setBounds(50, 20, 300, 20);
        add(lblusername);

         labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelusername.setBounds(200, 20, 200, 20);
        add(labelusername);

        JLabel lblid = new JLabel("ID :");
        lblid.setForeground(Color.BLACK);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblid.setBounds(50, 60, 300, 20);
        add(lblid);

        comboid = new JComboBox(new String[] {"Aadhar Card" , "Passport", "Driving Licence" , "Others"  });
        comboid.setBounds(200, 60, 200, 20);
        comboid.setBackground(Color.white);
        add(comboid);


        JLabel lblnumber = new JLabel("ID Number:");
        lblnumber.setForeground(Color.BLACK);
        lblnumber.setFont((new Font("Tahoma", Font.PLAIN, 18)));
        lblnumber.setBounds(50, 100, 300, 20);
        add(lblnumber);

         tfNumber = new JTextField();
        tfNumber.setBounds(200, 100, 200, 20);
        tfNumber.setBackground(Color.white);
        add(tfNumber);

         lblname = new JLabel("Name :");
        lblname.setForeground(Color.BLACK);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblname.setBounds(50, 140, 300, 20);
        add(lblname);

        labelname = new JLabel();
//     labelname = new JTextField();
        labelname.setBounds(200, 140, 200, 20);
        labelname.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labelname);

        //gender
        gender = new JLabel("Gender :");
        gender.setFont(new Font("Tahoma", Font.PLAIN, 18));
        gender.setBounds(50, 180, 300, 20);
        add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font( "Tahoma" , Font.PLAIN, 18));
        male.setBounds(200, 180, 100, 20);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font( "Tahoma" , Font.PLAIN, 18));
        female.setBounds(300, 180, 100, 20);
        female.setBackground(Color.white);
        add(female);

// To select any one
        gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel lblcountry = new JLabel("Country:");
        lblcountry.setForeground(Color.BLACK);
        lblcountry.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblcountry.setBounds(50, 220, 300, 20);
        add(lblcountry);

       tfcountry = new JTextField();
        tfcountry.setBounds(200, 220, 200, 20);
        tfcountry.setBackground(Color.white);
        add(tfcountry);

        JLabel lblphone = new JLabel("Phone:");
        lblphone.setForeground(Color.BLACK);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblphone.setBounds(50, 265, 300, 25);
        add(lblphone);

        tfphone = new JTextField();
     tfphone.setBounds(200, 265, 200, 20);
     tfphone.setBackground(Color.white);
        add(tfphone);

     JLabel lblemail = new JLabel("Email:");
     lblemail.setForeground(Color.BLACK);
     lblemail.setFont(new Font("Tahoma", Font.PLAIN, 18));
     lblemail.setBounds(50, 310, 300, 25);
     add(lblemail);

      tfemail = new JTextField();
     tfemail.setBounds(200, 310, 200, 20);
     tfemail.setBackground(Color.white);
     add(tfemail);

      add = new JButton("Add");
     add.setForeground(Color.white);
     add.setBackground(Color.black);
     add.setBounds(150 , 350 , 100 , 30);
     add.addActionListener(this);
     add(add);

     back = new JButton("Back");
     back.setForeground(Color.white);
     back.setBackground(Color.black);
     back.setBounds(450 , 350 , 100 , 30);
     back.addActionListener(this);
     add(back);

     // To show un-writable username and name

    try {
         Conn c = new Conn();
        ResultSet rs =  c.s.executeQuery("select* from account where username = '"+usrenamee+"'  ");
        while (rs.next()){
         labelusername.setText(rs.getString("username"));
         labelname.setText(rs.getString("name"));
        }
     }
     catch (Exception e){
   e.printStackTrace();
     }

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,500 ,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,0,450,420);
        add(image);

        setVisible(true);
    }

 @Override
 public void actionPerformed(ActionEvent ae) {
          if(ae.getSource() == add){
            String username = labelusername.getText();
            String id = (String) comboid.getSelectedItem();
            String idNumber = tfNumber.getText();
            String name = labelname.getText();
            String  number = tfphone.getText();
            String email = tfemail.getText();
            String country = tfcountry.getText();
            String gender = null;
            if(male.isSelected()){
             gender = "Male";
            }
            else{
             gender = "Female";
            }

            try {
             Conn c = new Conn();
                String query = "insert into customer values( '"+username+"',  '"+id+"',  '"+idNumber+"' , '"+name+"' ,  '"+gender+"',  '"+country+"',  '"+number+"'  , '"+email+"'  )";
                c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null , "Customer Details Added Successfully");
            setVisible(false);
//            new Dashboard("");
            }
            catch (Exception e){
             e.printStackTrace();
            }

              }
          else {
               setVisible(false);
//              new Dashboard(usrenamee);
              }
    }

     public static void main(String[] args) {
        new AddCustomer("");
     }
}
