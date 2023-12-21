package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame {

    JTable table;
    JScrollPane sp;
    JLabel lbluser;
    static JLabel users;
    Choice empChoice;
    JButton btnSearch, btnPrint, btnUpdate, btnBack;
    Conn con = new Conn();
    ViewEmployee(){
        getContentPane().setBackground(Color.CYAN);

        initViewEmployee();
        buttonActionListener();
        users = lbluser;

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(1220, 700);
        setLocation(300, 100);
        setVisible(true);

    }

    public void initViewEmployee(){
        JLabel heading = new JLabel("View Employee Details");
        heading.setBounds(600, 30, 500, 30);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("SAN_SERIE", Font.BOLD, 25));
        add(heading);

        tableEmployee();

        JLabel search = new JLabel("Search by Employee Id");
        search.setBounds(20, 20, 150, 20);
        search.setFont(new Font("serif", Font.PLAIN,14));
        search.setForeground(Color.BLUE);
        add(search);

        empChoice = new Choice();
        empChoice.setBounds(180, 20, 150, 20);
        empChoice.setFont(new Font("serif", Font.PLAIN,14));
        empChoice.setForeground(Color.BLUE);
        add(empChoice);

        choiceEmployeeId();

        lbluser = new JLabel("User View");
        lbluser.setBounds(1100,5,200,20);
        lbluser.setForeground(Color.WHITE);
        lbluser.setFont(new Font("SAN_SERIE", Font.BOLD, 16));
        add(lbluser);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(20, 70, 80, 20);
        btnSearch.setFont(new Font("serif", Font.PLAIN,14));
        btnSearch.setForeground(Color.BLUE);
        add(btnSearch);

        btnPrint = new JButton("Print");
        btnPrint.setBounds(120, 70, 80, 20);
        btnPrint.setFont(new Font("serif", Font.PLAIN,14));
        btnPrint.setForeground(Color.BLUE);
        add(btnPrint);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(220, 70, 80, 20);
        btnUpdate.setFont(new Font("serif", Font.PLAIN,14));
        btnUpdate.setForeground(Color.BLUE);
        add(btnUpdate);

        btnBack = new JButton("Back");
        btnBack.setBounds(320, 70, 80, 20);
        btnBack.setFont(new Font("serif", Font.PLAIN,14));
        btnBack.setForeground(Color.BLUE);
        add(btnBack);

    }

    public void buttonActionListener(){
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchEmployee();
            }
        });

        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    table.print();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new UpdateEmployee(empChoice.getSelectedItem());
                UpdateEmployee.users.setText(lbluser.getText());
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Home();
                Home.users.setText(lbluser.getText());
            }
        });

        empChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                searchEmployee();
            }
        });
    }

    public void searchEmployee(){
        table = new JTable();
        table.setFont(new Font("serif", Font.PLAIN,14));
        table.setForeground(Color.BLUE);
        String search = empChoice.getSelectedItem();

        try {
            String query = "SELECT * FROM employee WHERE empId = '" + search + "'";
            ResultSet rs = con.stmt.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception ex){
            ex.printStackTrace();
        }

        sp = new JScrollPane(table);
        sp.setBounds(5, 100, 1210, 595);
        add(sp);
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

    public void tableEmployee(){
        table = new JTable();
        table.setFont(new Font("serif", Font.PLAIN,14));
        table.setForeground(Color.BLUE);

        try {
            String query = "SELECT * FROM employee";
            ResultSet rs = con.stmt.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception ex){
            ex.printStackTrace();
        }

        sp = new JScrollPane(table);
        sp.setBounds(5, 100, 1210, 595);
        add(sp);
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
