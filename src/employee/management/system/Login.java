package employee.management.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame {

    JTextField txtUser;
    JPasswordField pass;
    JButton login, cancel, signup;
    Conn con = new Conn();
    Login(){
        getContentPane().setBackground(Color.CYAN);

        initLogin();
        buttonActionListener();

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);

    }

    public void initLogin(){
        // 테두리선이 없는 Border
        EmptyBorder emb = new EmptyBorder(5, 3, 5, 3);
        // 테두리선과 색깔 지정 Border
        LineBorder lib = new LineBorder(Color.BLACK, 3);
        //테두리에 홈이 파여있는 느낌 Border
        EtchedBorder etb = new EtchedBorder();
        //튀어나오는 느낌 Border
        BevelBorder beb = new BevelBorder(BevelBorder.RAISED);
        //들어간 느낌의 Border
        SoftBevelBorder sob = new SoftBevelBorder(SoftBevelBorder.LOWERED);
        //테두리의 크기를 조정할수 있는 Border
        MatteBorder mab = new MatteBorder(5,10,15,20,Color.CYAN);
        //Border내에 제목을 넣을 수있는 Border
        TitledBorder tib = new TitledBorder("타이틀제목");
        //Border를 섞어서 나타낼수 있는 Border
        SoftBevelBorder b8 = new SoftBevelBorder(SoftBevelBorder.RAISED);
        TitledBorder b9 = new TitledBorder("컴파운드제목");
        CompoundBorder b10 = new CompoundBorder(b8,b9);


        JLabel lblUsername = new JLabel("User Name");
        lblUsername.setBounds(40, 20, 100, 30);
        lblUsername.setFont(new Font("serif", Font.BOLD, 18));
        lblUsername.setForeground(Color.BLUE);
        add(lblUsername);

        txtUser = new JTextField();
        txtUser.setBounds(150, 20, 150, 30);
        txtUser.setForeground(Color.BLUE);
        txtUser.setFont(new Font("serif", Font.PLAIN,18));
        add(txtUser);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(40, 70, 100, 30);
        lblPassword.setFont(new Font("serif", Font.BOLD, 18));
        lblPassword.setForeground(Color.BLUE);
        add(lblPassword);

        pass = new JPasswordField();
        pass.setBounds(150, 70, 150, 30);
        pass.setForeground(Color.BLUE);
        pass.setFont(new Font("serif", Font.PLAIN,18));
        add(pass);

        cancel = new JButton("CANCEL");
        cancel.setBounds(40, 140, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif", Font.BOLD, 18));
        cancel.setBorder(lib);
        add(cancel);

        login = new JButton("LOGIN");
        login.setBounds(180, 140, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("serif", Font.BOLD, 18));
        login.setBorder(lib);
        add(login);

        signup = new JButton("CLICK HERE TO SIGN UP");
        signup.setBounds(100, 240, 300, 30);
        signup.setFont(new Font("serif", Font.BOLD, 18));
        signup.setForeground(Color.MAGENTA);
        signup.setOpaque(false);
        signup.setBackground(new Color(255, 255, 255, 0));
        signup.setBorder(emb);
        add(signup);

        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image l2 = l1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon l3 = new ImageIcon(l2);
        JLabel login = new JLabel(l3);
        login.setBounds(350, 10, 200, 200);
        add(login);
    }

    public void buttonActionListener(){
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String user = txtUser.getText();
                    String pw = new String(pass.getPassword());
                    String query = "SELECT * FROM signin WHERE username = '" +user + "' AND password = '" + pw + "'";
                    ResultSet rs = con.stmt.executeQuery(query);
                    if (rs.next()){
                        //setVisible(false);
                        dispose();
                        new Home();
                        Home.users.setText("Logout " + txtUser.getText());

                    }else {
                        JOptionPane.showMessageDialog(null, "Invalid User Name or Password");

                    }

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(101);
            }
        });

        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new UserAdmin();
            }
        });
    }

    public static void main(String[] args) {
        new Login();
    }
}
