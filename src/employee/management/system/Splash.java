package employee.management.system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame {

    JButton clickHere;
    JLabel heading;
    Splash(){
        super("EMPLOYEE MANAGEMENT SYSTEM");
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/emp_icon.png"));
        setIconImage(icon.getImage());
        getContentPane().setBackground(Color.CYAN);

        initSplash();
        buttonActionListener();

        setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);

        actionHeading();
    }

    public void initSplash(){
        heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80, 30, 1050, 60);
        heading.setForeground(Color.RED);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        add(heading);

        ImageIcon s1 = new ImageIcon(ClassLoader.getSystemResource("icon/splash.png"));
        Image s2 = s1.getImage().getScaledInstance(1100, 700,Image.SCALE_DEFAULT);
        ImageIcon s3 = new ImageIcon(s2);
        JLabel splash = new JLabel(s3);
        splash.setBounds(50, 100, 1070, 500);
        add(splash);

        clickHere = new JButton("CLICK HERE TO CONTINUE");
        clickHere.setBorder(new EmptyBorder(5, 3, 5, 3));
        clickHere.setBounds(400, 400, 300, 30);
        clickHere.setFont(new Font("serif", Font.BOLD, 18));
        clickHere.setForeground(Color.WHITE);
        clickHere.setOpaque(false);
        clickHere.setBackground(new Color(255, 255, 255, 0));
        splash.add(clickHere);

    }

    public void buttonActionListener(){
        clickHere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //setVisible(false);
                dispose();
                new Login();
            }
        });
    }

    public void actionHeading(){
        while (true){
            heading.setVisible(false);
            try {
                Thread.sleep(1000);
            }catch (Exception ex){
                ex.printStackTrace();
            }
            heading.setVisible(true);
            try {
                Thread.sleep(1000);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
