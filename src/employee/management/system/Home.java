package employee.management.system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame {

    JButton btnAdd, btnView, btnUpdate, btnRemove;
    JLabel lblUser;
    static JLabel users;
    Home(){
        getContentPane().setBackground(Color.CYAN);

        initHome();
        actionListener();

        users = lblUser;

        setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }

    public void initHome(){
        ImageIcon h1 = new ImageIcon(ClassLoader.getSystemResource("icon/home.png"));
        Image h2 = h1.getImage().getScaledInstance(1120, 630,Image.SCALE_DEFAULT);
        ImageIcon h3 = new ImageIcon(h2);
        JLabel home = new JLabel(h3);
        home.setBounds(0, 0, 1120, 630);
        add(home);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(650, 20, 400, 40);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        home.add(heading);

        lblUser = new JLabel("Log Out Home");
        lblUser.setBounds(50, 20, 200, 30);
        lblUser.setForeground(Color.BLUE);
        lblUser.setFont(new Font("Raleway", Font.BOLD, 16));
        home.add(lblUser);

        btnAdd = new JButton("Add Employee");
        btnAdd.setBounds(650, 80, 180, 40);
        btnAdd.setBorder(new EmptyBorder(5, 3, 5, 3));
        btnAdd.setFont(new Font("Raleway", Font.BOLD, 18));
        btnAdd.setForeground(Color.BLUE);
        btnAdd.setOpaque(false);
        btnAdd.setBackground(new Color(255, 255, 255, 0));
        home.add(btnAdd);

        btnView = new JButton("View Employee");
        btnView.setBounds(850, 80, 180, 40);
        btnView.setBorder(new EmptyBorder(5, 3, 5, 3));
        btnView.setFont(new Font("Raleway", Font.BOLD, 18));
        btnView.setForeground(Color.BLUE);
        btnView.setOpaque(false);
        btnView.setBackground(new Color(255, 255, 255, 0));
        home.add(btnView);

        btnUpdate = new JButton("Update Employee");
        btnUpdate.setBounds(650, 130, 180, 40);
        btnUpdate.setBorder(new EmptyBorder(5, 3, 5, 3));
        btnUpdate.setFont(new Font("Raleway", Font.BOLD, 18));
        btnUpdate.setForeground(Color.BLUE);
        btnUpdate.setOpaque(false);
        btnUpdate.setBackground(new Color(255, 255, 255, 0));
        home.add(btnUpdate);

        btnRemove = new JButton("Remove Employee");
        btnRemove.setBounds(850, 130, 180, 40);
        btnRemove.setBorder(new EmptyBorder(5, 3, 5, 3));
        btnRemove.setFont(new Font("Raleway", Font.BOLD, 18));
        btnRemove.setForeground(Color.BLUE);
        btnRemove.setOpaque(false);
        btnRemove.setBackground(new Color(255, 255, 255, 0));
        home.add(btnRemove);

    }

    public void actionListener(){
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddEmployee();
                AddEmployee.user.setText(lblUser.getText());
            }
        });

        btnView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewEmployee();
                ViewEmployee.users.setText(lblUser.getText());
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewEmployee();
                ViewEmployee.users.setText(lblUser.getText());
            }
        });

        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RemoveEmployee();
                RemoveEmployee.users.setText(lblUser.getText());
            }
        });

        lblUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int result = JOptionPane.showConfirmDialog(null,"Do you want to log out?", "Log Out", JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_NO_OPTION){
                    System.exit(101);
                }else {
                    JOptionPane.showMessageDialog(null, "Do you want to keep your login?");
                }
            }
        });
    }

    public static void main(String[] args) {
        new Home();
    }
}
