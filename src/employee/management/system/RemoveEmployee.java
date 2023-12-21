package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame {

    Choice empChoice;
    JLabel lblname, lblphone, lblemail;
    JButton btndelete, btnback;
    JLabel lbluser;
    static JLabel users;
    Conn con = new Conn();
    RemoveEmployee(){
        initRemoveEmployee();
        buttonActionListener();

        users = lbluser;
    }

    public void initRemoveEmployee(){
        getContentPane().setBackground(Color.CYAN);

        JLabel heading = new JLabel("Remove Employee Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("SAN_SERIE", Font.BOLD, 25));
        add(heading);

        lbluser = new JLabel("User Remove");
        lbluser.setBounds(800,5,200,20);
        lbluser.setForeground(Color.WHITE);
        lbluser.setFont(new Font("SAN_SERIE", Font.BOLD, 16));
        add(lbluser);

        JLabel empId = new JLabel("Employee Id");
        empId.setBounds(50, 100, 150, 20);
        empId.setFont(new Font("serif", Font.BOLD,20));
        empId.setForeground(Color.BLUE);
        add(empId);

        empChoice = new Choice();
        empChoice.setBounds(200, 100, 150, 20);
        empChoice.setFont(new Font("serif", Font.PLAIN,14));
        empChoice.setForeground(Color.BLUE);
        add(empChoice);

        choiceEmployeeId();

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setForeground(Color.BLUE);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        lblname.setForeground(Color.BLUE);
        lblname.setFont(new Font("serif", Font.BOLD, 16));
        add(lblname);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(50, 200, 150, 30);
        phone.setForeground(Color.BLUE);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        add(phone);

        lblphone = new JLabel();
        lblphone.setBounds(200, 200, 150, 30);
        lblphone.setForeground(Color.BLUE);
        lblphone.setFont(new Font("serif", Font.BOLD, 16));
        add(lblphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 250, 150, 30);
        email.setForeground(Color.BLUE);
        email.setFont(new Font("serif", Font.BOLD, 20));
        add(email);

        lblemail = new JLabel();
        lblemail.setBounds(200, 250, 150, 30);
        lblemail.setForeground(Color.BLUE);
        lblemail.setFont(new Font("serif", Font.BOLD, 16));
        add(lblemail);

        resultEmployee();
        choiceActionListener();

        btndelete = new JButton("Delete");
        btndelete.setBounds(80, 350, 100, 20);
        btndelete.setFont(new Font("serif", Font.BOLD,16));
        btndelete.setForeground(Color.WHITE);
        btndelete.setBackground(new Color(0, 0, 0));
        add(btndelete);

        btnback = new JButton("Back");
        btnback.setBounds(220, 350, 100, 20);
        btnback.setFont(new Font("serif", Font.BOLD,16));
        btnback.setForeground(Color.WHITE);
        btnback.setBackground(new Color(0, 0, 0));
        add(btnback);

        ImageIcon s1 = new ImageIcon(ClassLoader.getSystemResource("icon/delete.png"));
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
        btndelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String empId = empChoice.getSelectedItem();
                    String query = "DeLETE FROM employee WHERE empId = '" + empId + "'";

                    int result = JOptionPane.showConfirmDialog(null,"Employee Information Deleted", "DELETE", JOptionPane.YES_NO_OPTION);

                    if (result == JOptionPane.YES_NO_OPTION){
                        con.stmt.executeUpdate(query);

                        JOptionPane.showMessageDialog(null, "Employee Information Deleted Successfully");

                        dispose();
                        new Home();
                    }else {
                        JOptionPane.showMessageDialog(null, "Employee Information not Deleted");
                    }

                }catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        });

        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Home();
                Home.users.setText(lbluser.getText());
            }
        });
    }

    public void choiceActionListener(){
        empChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                resultEmployee();
            }
        });
    }

    public void resultEmployee(){
        try {
            String empId = empChoice.getSelectedItem();
            String query = "SELECT * FROM employee WHERE empId = '" + empId + "'";
            ResultSet rs = con.stmt.executeQuery(query);

            while (rs.next()){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void choiceEmployeeId(){

        try {
            String query = "SELECT * FROM employee";
            ResultSet rs = con.stmt.executeQuery(query);

            while (rs.next()){
                empChoice.add(rs.getString("empId"));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
