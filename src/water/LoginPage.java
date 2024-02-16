package water;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class LoginPage extends JFrame implements ActionListener {
    JButton log_button;
    JButton signup;
    JPanel heading, login;
    JLabel name;
    JTextField username;
    JPasswordField password;
    JLabel lsign, lcreate;
    public static String username2, password2;
    public static String FULL_NAME;
    LoginPage(){
        Font f = new Font("Serif", Font.BOLD, 30);
        //HEADER
        heading = new JPanel();
        heading.setBackground(Color.BLACK);
        heading.setBounds(0, 0, 1200, 100);
        heading.setLayout(null);

        name = new JLabel();
        name.setText("WATER MANAGEMENT SYSTEM");
        name.setForeground(Color.YELLOW);
        name.setBounds(0,20,1200,50);
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setFont(new Font("sanserif",Font.BOLD,45));
        heading.add(name);


        //LOGIN PANEL
        login = new JPanel();
        login.setLayout(null);
        login.setBackground(Color.black);
        login.setBounds(100, 175, 400, 300);

        JLabel log = new JLabel("Login");
        log.setBounds(30,30,200,40);
        log.setFont(new Font("Century Gothic",Font.BOLD,32));
        log.setForeground(Color.WHITE);
        login.add(log);

        username = new JTextField();
        username.setBackground(new Color(250, 242, 244));
        username.setForeground(Color.BLUE);
        username.setBorder(null);
        username.setOpaque(true);
        username.setBounds(50, 90, 300, 40);
        username.setText("Enter Your Username");
        username.addFocusListener(new FocusListener() {

            public void focusGained(FocusEvent e) {
                if(username.getText().equals("Enter Your Username")){
                    username.setText("");
                }
            }


            public void focusLost(FocusEvent e) {
                if(username.getText().equals("")){
                    username.setText("Enter Your Username");
                }

            }
        });
        login.add(username);

        password = new JPasswordField();
        password.setBackground(new Color(250, 242, 244));
        password.setForeground(Color.BLACK);
        password.setOpaque(true);
        password.setBorder(null);
        password.setBounds(50, 150, 300, 40);
        password.setText("Enter Your Password");
        password.addFocusListener(new FocusListener() {

            public void focusGained(FocusEvent e) {
                if(password.getText().equals("Enter Your Password")){
                    password.setText("");
                }
            }


            public void focusLost(FocusEvent e) {
                if(password.getText().equals("")){
                    password.setText("Enter Your Password");
                }


            }
        });
        login.add(password);

        log_button = new JButton("Login");
        log_button.setBounds(140, 200, 100, 50);
        log_button.setBackground(Color.yellow);
        log_button.setOpaque(true);
        log_button.setBorder(null);

        log_button.addActionListener(this);
        login.add(log_button);

        lsign = new JLabel("Not Registered? ");
        lsign.setBounds(40, 260, 200, 50);
        lsign.setHorizontalAlignment(JLabel.CENTER);
        lsign.setForeground(Color.yellow);
        lsign.setFont(new Font("Calibri Light",Font.ITALIC,17));
        login.add(lsign);
        lcreate = new JLabel("Create an account");
        lcreate.setBounds(200, 260, 300, 50);
        lcreate.setForeground(new Color(34, 117, 5));
        lcreate.setFont(new Font("Calibri Light",Font.PLAIN,17));
        lcreate.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new Signup();
                setVisible(false);
            }
        });
        Font font = lcreate.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lcreate.setFont(font.deriveFont(attributes));
        login.add(lcreate);


        //FRAME
        setSize(1200, 650);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        ImageIcon imageIcon = new ImageIcon("Logo.png");
        setIconImage(imageIcon.getImage());
        setTitle("WATER MANAGEMENT SYSTEM USER");

       // BACKGROUND
        ImageIcon background_image = new ImageIcon("image/login.jpeg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1200, 650, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);

        background.add(login);
        background.add(heading);
        background.setBounds(0, 0, 1200, 650);
        add(background);
        setVisible(true);

    }

    public static void main(String[] args) {
        new LoginPage();
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == log_button){
            loginx();
        }

    }

    void  loginx() {
        username2 = username.getText();
        password2 = password.getText();

        Conn conn = new Conn();

        String query = "Select * from signup where UserName ='"+username2+"' and PassWord = '"+password2+"'";
        try {
            ResultSet rs = conn.sta.executeQuery(query);
            if (rs.next()){

                new Home();
                setVisible(false);
            }else {
                JOptionPane.showMessageDialog(this, "Account doesn't exist", "Error",JOptionPane.ERROR_MESSAGE);
            }

        }catch (SQLException throwables){
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(this, "Some Error Occurred...", "Error",JOptionPane.ERROR_MESSAGE);
        }


    }

}
