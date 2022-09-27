package travel.management.system;
import javax.swing.*;
import java.awt.*;

public class Splash  extends JFrame implements Runnable {
    // interface Runnable we had used
    Thread thread;

    Splash(){
//        setSize(1200 , 600); // setting frame dimension but frame not visible because by defalult it is hidden
//        setLocation(50 , 100);  // opening window should be in what location

        // to set  icon we use ImageIcon  class and make object of it by name i1
        // to get image from source file we use class named {classLoder} and use function get systemresource
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dest9.jpg"));

        // from awt we use image class to scale it properly
        Image i2 = i1.getImage().getScaledInstance(1900 , 1200 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        // Jlabel
        JLabel image = new JLabel(i1);
        // to place at frame we use add function
        add(image);
        // image is not scalled property

        setVisible(true);  // now frame will be visible  but location will be top left

        thread = new Thread(this);
        thread.start();
    }
    // IMPLEMNT RUNAMBLE  TO STOP FRAME OR PANNEL IN 7 SEC
    @Override
    public void run() {
        try {
            thread.sleep(7000);
            setVisible(false);
            new login("");
        } catch (Exception e) {
//            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
       Splash frame =  new Splash();
       int x=1;
       for( int i= 1 ; i<= 700 ; x+=7 , i+=10){
           frame.setLocation(650 - (x +i)/2 ,350 -(i)/2);  // location move's
           frame.setSize(i+x , i);
           try{
               Thread.sleep(10);
           }
           catch(Exception e){}
       }
    }



}
