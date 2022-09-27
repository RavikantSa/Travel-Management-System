package travel.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class BookPackage extends JFrame implements ActionListener {
         Choice cpackage;
    JLabel labelusername , labelid , labelname , labelnumber , labelphone , labelprice , labelidnumber;
    JButton chechprice , book , back;
    JTextField tfperson;

String username;
    public BookPackage(String username) {
        this.username = username;
       setLayout(null);
        setBounds(300, 150, 1000, 550);
        getContentPane().setBackground(Color.white);


        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(350,50,700,300);
        add(la1);

        JLabel bookpackages = new JLabel("BOOK PACKAGE");
        bookpackages.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        bookpackages.setBounds(150, 5, 300, 53);
        bookpackages.setFont(  new Font("Yu Mincho", Font.BOLD, 25));
        add(bookpackages);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        lblusername.setBounds(30,60,150,20);
        add(lblusername);

        labelusername  = new JLabel();
        labelusername.setBounds(200,60,150,20);
        labelusername.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelusername);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        lblname.setBounds(30,100,150,20);
        add(lblname);
      labelname = new JLabel();
        labelname.setBounds(200,100,150,25);
        labelname.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelname);

        JLabel selectPackages = new JLabel("Select Packages");
        selectPackages.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        selectPackages.setBounds(30,140,150,20);
        add(selectPackages);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(200,140,150,20);
        add(cpackage);

        JLabel lbperson = new JLabel("Total Person");
        lbperson.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        lbperson.setBounds(30,180,150,20);
        add(lbperson);
        tfperson = new JTextField("1");
        tfperson.setBounds(200,180,150,25);
        tfperson.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        add(tfperson);

        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        lblid.setBounds(30,220,150,20);
        add(lblid);
    labelid = new JLabel();
        labelid.setBounds(200,220,150,25);
        labelid.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelid);


        JLabel lblNumber = new JLabel("ID Number");
        lblNumber.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        lblNumber.setBounds(30,260,150,20);
        add(lblNumber);
      labelidnumber = new JLabel();
        labelidnumber.setBounds(200,260,150,25);
        labelidnumber.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelidnumber);

          JLabel lblPhone = new JLabel("Phone Number");
        lblPhone.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        lblPhone.setBounds(30,300,150,20);
        add(lblPhone);
        labelphone = new JLabel();
        labelphone.setBounds(200,300,150,25);
        labelphone.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelphone);

        JLabel lblprice = new JLabel("Total Prise");
        lblprice.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        lblprice.setBounds(30,340,150,20);
        add(lblprice);
        labelprice = new JLabel();
        labelprice.setBounds(200,340,150,25);
        labelprice.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelprice);

        try {

            Conn conn = new Conn();
            String  query = "select * from customer where username = '"+username+"' ";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                labelid.setText(rs.getString("id"));
                labelidnumber.setText(rs.getString("idnumber"));
                labelphone.setText(rs.getString("phoneNo"));

            }
        }
        catch (Exception e){
            e.printStackTrace();;
        }

        chechprice = new JButton("Check Price");
        chechprice.setBackground(Color.black);
        chechprice.setForeground(Color.white);
        chechprice.setBounds(30 ,  400 , 200 , 30);
        chechprice.addActionListener(this);
        add(chechprice);

     book = new JButton("Book Package");
        book.setBackground(Color.black);
        book.setForeground(Color.white);
        book.setBounds(250 ,  400 , 200 , 30);
        book.addActionListener(this);
        add(book);

     back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(130 ,  450 , 200 , 30);
        back.addActionListener(this);
        add(back);
        setVisible(true);
    }
    public static void main(String[] args) {
        new BookPackage("");
    }

    @Override
   public void actionPerformed(ActionEvent e) {
        if( e.getSource() == book){
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values ('"+labelusername.getText()+"'  , '"+cpackage.getSelectedItem()+"' , '"+tfperson.getText()+"' , '"+labelid.getText()+"' ,  '"+labelidnumber.getText()+"' , '"+labelphone.getText()+"'  , '"+labelprice.getText()+"' ) ");

                JOptionPane.showMessageDialog(null , "Package Booked Succesfully");
                setVisible(false);
            }

            catch (Exception e1){
                e1.printStackTrace();
            }

        }
        else if( e.getSource() == chechprice){
            String cpackageSelectedItem = cpackage.getSelectedItem();
            int cost = 0;
            if( cpackageSelectedItem.equals("Gold Package")){
                cost += 12000;
            }
            else if( cpackageSelectedItem.equals("Silver Package") ){
                cost+= 25000;
            }
            else{
                cost+= 32000;
            }

            int person = Integer.parseInt( tfperson.getText());
            cost*=person;
            labelprice.setText("Rs " + cost);
        }
        else{
            setVisible(false);
        }
    }
}
