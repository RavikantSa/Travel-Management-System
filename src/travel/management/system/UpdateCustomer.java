
package travel.management.system;
//lLecture 11
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class  UpdateCustomer extends JFrame implements ActionListener {

        JLabel labelname  , labelusername ; // error
//        JTextField labelusername;   // if i want to update username


    JButton back, update;

    JTextField tfNumber , tfcountry , tfphone , tfemail , tfid , tfgender;

    JLabel lblusername ,  lblname ,  gender;
    String usrename;


    UpdateCustomer(String usrename){
        this.usrename = usrename;

        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(300 , 200 , 850 , 450);

        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 22));
        text.setBounds(450 , 0 , 500 , 30);
        add(text);

        lblusername = new JLabel("Username");
        lblusername.setForeground(Color.BLACK);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblusername.setBounds(50, 20, 300, 20);
        add(lblusername);

         labelusername = new JLabel();
//        labelusername = new JTextField();
        labelusername.setBounds(200, 20, 200, 20);
        add(labelusername);

        JLabel lblid = new JLabel("ID :");
        lblid.setForeground(Color.BLACK);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblid.setBounds(50, 60, 300,  20);
        add(lblid);

            tfid = new JTextField();
        tfid.setBounds(200, 60, 200, 20);
        tfid.setBackground(Color.white);
        add(tfid);



        JLabel lblnumber = new JLabel("ID Number:");
        lblnumber.setForeground(Color.BLACK);
        lblnumber.setFont((new Font("Tahoma", Font.PLAIN, 18)));
        lblnumber.setBounds(50, 100, 300, 20);
        add(lblnumber);

        tfNumber = new JTextField();
        tfNumber.setBounds(200, 100, 200, 20);
        tfNumber.setBackground(Color.white);
        add(tfNumber);

        lblname = new JLabel("Name");
        lblname.setForeground(Color.BLACK);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblname.setBounds(50, 140, 300, 20);
        add(lblname);

        labelname = new JLabel();
//        labelname = new JTextField();
        labelname.setBounds(200, 140, 200, 20);
        add(labelname);

        //gender
        gender = new JLabel("Gender :");
        gender.setFont(new Font("Tahoma", Font.PLAIN, 18));
        gender.setBounds(50, 180, 300, 20);
        add(gender);

         tfgender = new JTextField();
        tfgender.setBounds(200, 180, 200, 20);
        tfgender.setBackground(Color.white);
        add(tfgender);

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



        update = new JButton("Update");
        update.setForeground(Color.white);
        update.setBackground(Color.black);
        update.setBounds(150 , 350 , 100 , 30);
        update.addActionListener(this);
        add(update);


        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setBounds(450 , 350 , 100 , 30);
        back.addActionListener(this);
        add(back);


    try {
         Conn c = new Conn();
        ResultSet rs =  c.s.executeQuery("select * from customer where username = '"+usrename+"'  ");
        while (rs.next()){
         labelusername.setText(rs.getString("username"));
         labelname.setText(rs.getString("name"));
         tfid.setText( rs.getString("id"));
         tfNumber.setText( rs.getString("idnumber"));
         tfcountry.setText( rs.getString("country"));
         tfemail.setText( rs.getString("email"));
         tfphone.setText( rs.getString("phoneNo"));
        tfgender.setText(rs.getString("gender"));
        }
     }
     catch (Exception e){
   e.printStackTrace();
     }

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(200,300 ,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,0,450,420);
        add(image);


        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == update){
            String username = labelusername.getText();
            String id =  tfid.getText();
            String idNumber = tfNumber.getText();
            String name = labelname.getText();
            String  number = tfphone.getText();
            String email = tfemail.getText();
            String country = tfcountry.getText();
            String gender = tfgender.getText();


            try {
                Conn c = new Conn();
                String query = "update customer set username = '"+username+"', id =  '"+id+"', idnumber = '"+idNumber+"' , name =  '"+name+"' , gender = '"+gender+"', country =  '"+country+"', phoneNo = '"+number+"'  ,email = '"+email+"'  ";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null , "Customer Details Updated Successfully");
                setVisible(false);
//                new ViewCustomer(username);
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
        else {
            setVisible(false);
//            new Dashboard(usrename);
        }
    }

    public static void main(String[] args) {
        new  UpdateCustomer("");
    }


}
