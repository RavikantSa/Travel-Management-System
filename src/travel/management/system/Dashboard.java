package travel.management.system;
// lecture 8
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JButton addPersonalDetails , viewPersonalDetails , updatePersonalDetails , chechpackages , bookPackages , deletePersonalDetails;
    JButton logout , calculator , about , payment , Destinations , viewBookedHotels  , bookHotels , viewHotels ,viewPackages;
    String username;
    Dashboard(String username){
        this.username = username;
//    setBounds(0,0,1250,700);
       setExtendedState(JFrame.MAXIMIZED_BOTH); // to fit according to my screen
    setLayout(null);

    JPanel p1 = new JPanel();
    p1.setLayout(null);
    p1.setBackground(new Color(0 , 0 ,102));
    p1.setBounds(0,0,1400 , 65);
    add(p1);

    JLabel heading = new JLabel("Dashboard");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 40));
        heading.setBounds(70, 5, 500, 50);
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0 , 0 ,102));
        p2.setBounds(0,65,300 , 900);
        add(p2);

        addPersonalDetails = new JButton("Add personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground( new Color( 0,0,102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        addPersonalDetails.setMargin( new Insets(0,0,0,70));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.setBackground( new Color( 0,0,102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        updatePersonalDetails.setMargin( new Insets(0,0,0,50));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);   
        
        viewPersonalDetails = new JButton("View Personal Details");
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.setBackground( new Color( 0,0,102));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        viewPersonalDetails.setMargin( new Insets(0,0,0,70));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

         deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,150,300,50);
        deletePersonalDetails.setBackground( new Color( 0,0,102));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        deletePersonalDetails.setMargin( new Insets(0,0,0,50));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);
        
        chechpackages = new JButton("Check Packages");
        chechpackages.setBounds(0,200,300,50);
        chechpackages.setBackground( new Color( 0,0,102));
        chechpackages.setForeground(Color.WHITE);
        chechpackages.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        chechpackages.setMargin( new Insets(0,0,0,110));
        chechpackages.addActionListener(this);
        p2.add(chechpackages);

         bookPackages = new JButton("Book Packages");
        bookPackages.setBounds(0,250,300,50);
        bookPackages.setBackground( new Color( 0,0,102));
        bookPackages.setForeground(Color.WHITE);
        bookPackages.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        bookPackages.setMargin( new Insets(0,0,0,110));
        bookPackages.addActionListener(this);
        p2.add(bookPackages);

         viewPackages = new JButton("View Booked Package");
        viewPackages.setBounds(0,300,350,50);
        viewPackages.setBackground( new Color( 0,0,102));
        viewPackages.setForeground(Color.WHITE);
        viewPackages.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        viewPackages.setMargin( new Insets(0,0,0,110));
        viewPackages.addActionListener(this);
        p2.add(viewPackages);

         viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(0,350,300,50);
        viewHotels.setBackground( new Color( 0,0,102));
        viewHotels.setForeground(Color.WHITE);
        viewHotels.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        viewHotels.setMargin( new Insets(0,0,0,150));
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        bookHotels = new JButton("Booked Hotels");
        bookHotels.setBounds(0,400,300,50);
        bookHotels.setBackground( new Color( 0,0,102));
        bookHotels.setForeground(Color.WHITE);
        bookHotels.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        bookHotels.setMargin( new Insets(0,0,0,130));
        bookHotels.addActionListener(this);
        p2.add(bookHotels);

        viewBookedHotels = new JButton("View  Booked Hotels");
        viewBookedHotels.setBounds(-7,450,350,50);
        viewBookedHotels.setBackground( new Color( 0,0,102));
        viewBookedHotels.setForeground(Color.WHITE);
        viewBookedHotels.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        viewBookedHotels.setMargin( new Insets(0,0,0,110));
        viewBookedHotels.addActionListener(this);
        p2.add(viewBookedHotels);

         Destinations = new JButton("Destinations");
        Destinations.setBounds(0,500,300,50);
        Destinations.setBackground( new Color( 0,0,102));
        Destinations.setForeground(Color.WHITE);
        Destinations.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        Destinations.setMargin( new Insets(0,0,0,155));
        Destinations.addActionListener(this);
        p2.add(Destinations);

         payment = new JButton("Payments");
        payment.setBounds(0,550,300,50);
        payment.setBackground( new Color( 0,0,102));
        payment.setForeground(Color.WHITE);
        payment.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        payment.setMargin( new Insets(0,0,0,175));
        payment.addActionListener(this);
        p2.add(payment);
        
       calculator = new JButton("Calculator");
        calculator.setBounds(0,550,300,50);
        calculator.setBackground( new Color( 0,0,102));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        calculator.setMargin( new Insets(0,0,0,175));
        calculator.addActionListener(this);
        p2.add(calculator);

        about = new JButton("About");
        about.setBounds(0,600,300,40);
        about.setBackground( new Color( 0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        about.setMargin( new Insets(0,0,0,195));
        about.addActionListener(this);
        p2.add(about);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
        NewLabel.setBounds(250, 50, 1150, 700);
        add(NewLabel);

        JLabel showname = new JLabel("Welcome "+username+"");
        showname.setBounds(600 , 15 , 500 , 35);
        showname.setForeground(Color.white);
        showname.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 35));
//        showname.setFont(new Font("Raleway" , Font.BOLD , 35));
        p1.add(showname);

         logout = new JButton("Logout");
        logout.setForeground(Color.ORANGE );
        logout.setBackground( new Color( 0,0,102));
        logout.setBounds(1000 , 15 , 200 , 45);
        logout.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
        logout.addActionListener(this);
        logout.setMargin(new Insets(0 , 0 , 0 , 0));
        p1.add(logout);

        JLabel l1 = new JLabel("Travel and Tourism Management System");
        l1.setForeground(new Color(162, 48, 124));
        l1.setFont(new Font("Tahoma", Font.PLAIN, 45));
        l1.setBounds(150, 50, 1000, 55);
        NewLabel.add(l1);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() ==addPersonalDetails ){
            new AddCustomer(username);
        }
        else if( ae.getSource() == logout){
            setVisible(false);
            new login("");
        }
        else if( ae.getSource() == viewPersonalDetails){
            new ViewCustomer(username).setVisible(true);
        }
        else if( ae.getSource() == updatePersonalDetails){
            new UpdateCustomer(username).setVisible(true);
        }
        else if( ae.getSource() == chechpackages){
            new CheckPackage().setVisible(true);
        }
        else if( ae.getSource() == bookPackages){
            new BookPackage(username);
        }
        else if( ae.getSource() ==  viewPackages){
            new ViewPackage(username);
        }
        else if( ae.getSource() == viewHotels){
          new CheckHotels();
        }
        else if( ae.getSource() == Destinations){
          new Destination();
        }
        else if( ae.getSource() == bookHotels ){
          new BookHotels(username);
        }
        else if( ae.getSource() == viewBookedHotels ){
          new ViewBookHotels(username);
        }
        else if( ae.getSource() == payment  ){
         new payment();
            try {
                Runtime.getRuntime().exec("calc.exe");
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if( ae.getSource() == about  ){
                new About();
        }
        else if( ae.getSource() == deletePersonalDetails ){
                new DeleteCustomerDetails(username);
        }
    }

    public static void main(String[] args) {
        new Dashboard("");
    }
}

