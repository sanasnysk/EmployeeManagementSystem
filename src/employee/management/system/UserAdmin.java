package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserAdmin extends JFrame {

    JTextField user;
    JPasswordField pass, repass;
    JButton btnsignup, btncancel;
    Conn con = new Conn();
    UserAdmin(){
        initSignUp();
        buttonActionListener();
    }

    public void initSignUp(){
        getContentPane().setBackground(Color.CYAN);

        JLabel heading = new JLabel("User Admin Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("SAN_SERIE", Font.BOLD, 25));
        add(heading);



        JLabel name = new JLabel("User Name");
        name.setBounds(50, 150, 150, 30);
        name.setForeground(Color.BLUE);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        user = new JTextField();
        user.setBounds(200, 150, 150, 30);
        user.setForeground(Color.BLUE);
        user.setFont(new Font("serif", Font.BOLD, 16));
        add(user);

        JLabel pw = new JLabel("Password");
        pw.setBounds(50, 200, 150, 30);
        pw.setForeground(Color.BLUE);
        pw.setFont(new Font("serif", Font.BOLD, 20));
        add(pw);

        pass = new JPasswordField();
        pass.setBounds(200, 200, 150, 30);
        pass.setForeground(Color.BLUE);
        pass.setFont(new Font("serif", Font.BOLD, 16));
        add(pass);

        JLabel rpw = new JLabel("RePassword");
        rpw.setBounds(50, 250, 150, 30);
        rpw.setForeground(Color.BLUE);
        rpw.setFont(new Font("serif", Font.BOLD, 20));
        add(rpw);

        repass = new JPasswordField();
        repass.setBounds(200, 250, 150, 30);
        repass.setForeground(Color.BLUE);
        repass.setFont(new Font("serif", Font.BOLD, 16));
        add(repass);

        btnsignup = new JButton("Signup");
        btnsignup.setBounds(80, 350, 100, 20);
        btnsignup.setFont(new Font("serif", Font.BOLD,16));
        btnsignup.setForeground(Color.WHITE);
        btnsignup.setBackground(new Color(0, 0, 0));
        add(btnsignup);

        btncancel = new JButton("Cancel");
        btncancel.setBounds(220, 350, 100, 20);
        btncancel.setFont(new Font("serif", Font.BOLD,16));
        btncancel.setForeground(Color.WHITE);
        btncancel.setBackground(new Color(0, 0, 0));
        add(btncancel);

        ImageIcon s1 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image s2 = s1.getImage().getScaledInstance(600, 350,Image.SCALE_DEFAULT);
        ImageIcon s3 = new ImageIcon(s2);
        JLabel splash = new JLabel(s3);
        splash.setBounds(380, 30, 600, 350);
        add(splash);

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }

    public void buttonActionListener(){
        btnsignup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = user.getText();
                String pw = new String(pass.getPassword());
                String rpw = new String(repass.getPassword());
                String query = "INSERT INTO signin VALUES ('" + name + "', '" + pw + "')";

                if (name.equals("")){
                    JOptionPane.showMessageDialog(null, "Name Invalid");
                    return;
                }

                if (pw.equals("")){
                    JOptionPane.showMessageDialog(null, "Password Invalid");
                    return;
                }

                if (rpw.equals("")){
                    JOptionPane.showMessageDialog(null, "Repassword Invalid");
                    return;
                }

                if (!pw.equals(rpw)){
                    JOptionPane.showMessageDialog(null, "Password Invalid");

                }else {
                    int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to go to the login page?", "SIGN UP", JOptionPane.YES_NO_OPTION);

                    if (result == JOptionPane.YES_NO_OPTION){
                        try {
                            con.stmt.executeUpdate(query);
                            JOptionPane.showMessageDialog(null, "Admin User '" + name + "' Successfully");

                            dispose();
                            new Login();

                        }catch (Exception ex){
                            ex.printStackTrace();
                        }

                    }else {
                        JOptionPane.showMessageDialog(null, "not Sign up");
                    }
                }

            }
        });

        btncancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(102);
            }
        });
    }

    public static void main(String[] args) {
        new UserAdmin();
    }

}
