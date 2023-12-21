package employee.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame {
    JTextField txteducation, txtffname, txtsalary, txtaddress, txtphone, txtemail, txtdesignation;
    JLabel lblempId;
    JLabel lbluser, lblname, lbldob, lblaadhar;
    static JLabel users;
    JButton btnAdd, btnBack;
    Conn con = new Conn();
    String empId;
    UpdateEmployee(String empId){
        this.empId = empId;
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);

        initUpdateEmployee();
        resultEmployee();
        buttonActionListener();
        users = lbluser;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void initUpdateEmployee(){
        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("SAN_SERIE", Font.BOLD, 25));
        add(heading);

        lbluser = new JLabel("User Update");
        lbluser.setBounds(10,5,200,30);
        lbluser.setForeground(Color.WHITE);
        lbluser.setFont(new Font("SAN_SERIE", Font.BOLD, 16));
        add(lbluser);

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

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setForeground(Color.BLUE);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        add(fname);

        txtffname = new JTextField();
        txtffname.setBounds(600, 150, 150, 30);
        txtffname.setForeground(Color.BLUE);
        txtffname.setFont(new Font("serif", Font.BOLD, 16));
        add(txtffname);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setForeground(Color.BLUE);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        add(dob);

        lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        lbldob.setForeground(Color.BLUE);
        lbldob.setFont(new Font("serif", Font.BOLD, 16));
        add(lbldob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setForeground(Color.BLUE);
        salary.setFont(new Font("serif", Font.BOLD, 20));
        add(salary);

        txtsalary = new JTextField();
        txtsalary.setBounds(600, 200, 150, 30);
        txtsalary.setForeground(Color.BLUE);
        txtsalary.setFont(new Font("serif", Font.BOLD, 16));
        add(txtsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setForeground(Color.BLUE);
        address.setFont(new Font("serif", Font.BOLD, 20));
        add(address);

        txtaddress = new JTextField();
        txtaddress.setBounds(200, 250, 150, 30);
        txtaddress.setForeground(Color.BLUE);
        txtaddress.setFont(new Font("serif", Font.BOLD, 16));
        add(txtaddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setForeground(Color.BLUE);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        add(phone);

        txtphone = new JTextField();
        txtphone.setBounds(600, 250, 150, 30);
        txtphone.setForeground(Color.BLUE);
        txtphone.setFont(new Font("serif", Font.BOLD, 16));
        add(txtphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setForeground(Color.BLUE);
        email.setFont(new Font("serif", Font.BOLD, 20));
        add(email);

        txtemail = new JTextField();
        txtemail.setBounds(200, 300, 150, 30);
        txtemail.setForeground(Color.BLUE);
        txtemail.setFont(new Font("serif", Font.BOLD, 16));
        add(txtemail);

        JLabel education = new JLabel("Higest Education");
        education.setBounds(400, 300, 200, 30);
        education.setForeground(Color.BLUE);
        education.setFont(new Font("serif", Font.BOLD, 20));
        add(education);

        txteducation = new JTextField();
        txteducation.setBounds(600, 300, 150, 30);
        txteducation.setForeground(Color.BLUE);
        txteducation.setFont(new Font("serif", Font.BOLD, 16));
        add(txteducation);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setForeground(Color.BLUE);
        designation.setFont(new Font("serif", Font.BOLD, 20));
        add(designation);

        txtdesignation = new JTextField();
        txtdesignation.setBounds(200, 350, 150, 30);
        txtdesignation.setForeground(Color.BLUE);
        txtdesignation.setFont(new Font("serif", Font.BOLD, 16));
        add(txtdesignation);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setForeground(Color.BLUE);
        aadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(aadhar);

        lblaadhar = new JLabel();
        lblaadhar.setBounds(600, 350, 150, 30);
        lblaadhar.setForeground(Color.BLUE);
        lblaadhar.setFont(new Font("serif", Font.BOLD, 16));
        add(lblaadhar);

        JLabel empId = new JLabel("Employee ID");
        empId.setBounds(50, 400, 150, 30);
        empId.setForeground(Color.BLUE);
        empId.setFont(new Font("serif", Font.BOLD, 20));
        add(empId);

        lblempId = new JLabel();
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setForeground(Color.BLUE);
        lblempId.setFont(new Font("serif", Font.BOLD, 18));
        add(lblempId);

        btnAdd = new JButton("Update Details");
        btnAdd.setBounds(250, 550, 150, 40);
        btnAdd.setBorder(new LineBorder(Color.BLACK, 3));
        btnAdd.setFont(new Font("Raleway", Font.BOLD, 18));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setBackground(new Color(0, 0, 0));
        add(btnAdd);

        btnBack = new JButton("Back View");
        btnBack.setBounds(450, 550, 150, 40);
        btnBack.setBorder(new LineBorder(Color.BLACK, 3));
        btnBack.setFont(new Font("Raleway", Font.BOLD, 18));
        btnBack.setForeground(Color.WHITE);
        btnBack.setBackground(new Color(0, 0, 0));
        add(btnBack);

    }

    public void buttonActionListener(){
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fname = txtffname.getText();
                String salary = txtsalary.getText();
                String address = txtaddress.getText();
                String phone = txtphone.getText();
                String email = txtemail.getText();
                String education = txteducation.getText();
                String designation = txtdesignation.getText();

                try {
                    String query = "UPDATE employee SET fname = '" + fname + "',  salary =  '" + salary + "'," +
                            " address = '" + address + "', phone = '" + phone + "', email = '" + email + "'," +
                            " education =  '" + education + "', designation =  '" + designation + "'" +
                            " WHERE empId =  '" + empId + "'";
                    con.stmt.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Details Update Employee Successfully");

                    dispose();
                    new Home();
                    Home.users.setText(lbluser.getText());

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewEmployee();
                ViewEmployee.users.setText(lbluser.getText());
            }
        });
    }

    public void resultEmployee(){
        try {
            String query = "SELECT * FROM employee WHERE empId = '" + empId + "'";
            ResultSet rs = con.stmt.executeQuery(query);

            while (rs.next()){
                lblname.setText(rs.getString("name"));
                txtffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                txtsalary.setText(rs.getString("salary"));
                txtaddress.setText(rs.getString("address"));
                txtphone.setText(rs.getString("phone"));
                txtemail.setText(rs.getString("email"));
                txteducation.setText(rs.getString("education"));
                txtdesignation.setText(rs.getString("designation"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
