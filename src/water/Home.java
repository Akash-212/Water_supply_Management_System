package water;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Home extends  JFrame implements ActionListener {
    JLabel dashboard, applyPolicy,histroy, avaPolicy,appedPolicy, pcategory, n1,n2,n3,n4, heading;
    JPanel sidepanel, smpanel1,smpanel2,smpanel3,smpanel4, toppanel,sp1,sp2,sp3,sp4,sp5,sp6;
    Conn conn = new Conn();
    Home(){
        Font f = new Font("Serif", Font.BOLD, 30);
        Font smpf = new Font("Serif", Font.BOLD, 18);
        Font nf = new Font("Serif", Font.BOLD, 30);
        Font smf = new Font("Bell MT", Font.BOLD, 14);

        //frame

        setSize(1400,850);
        setTitle("Dashboard - "+LoginPage.FULL_NAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);



//        background
        ImageIcon bg=new ImageIcon("image/home.jpg");
        Image img= bg.getImage();
        Image temp_img=img.getScaledInstance(1500,850,Image.SCALE_SMOOTH);
        bg= new ImageIcon(temp_img);
        JLabel background =new JLabel("",bg,JLabel.CENTER);

        toppanel=new JPanel();
        toppanel.setBounds(0,0,1500,90);
        toppanel.setBackground(Color.BLACK);
        toppanel.setLayout(new BorderLayout());

        heading= new JLabel("WATER MANAGEMENT SYSTEM",JLabel.CENTER);
        heading.setForeground(Color.YELLOW);
        heading.setFont(f);
        heading.setBounds(120,0, 600,60);
        toppanel.add(heading, BorderLayout.CENTER);



        sidepanel =new JPanel();
        sidepanel.setBounds(0,90,250,720);
        sidepanel.setBackground(new Color(131, 220, 171));
        sidepanel.setLayout(null);

        //side Content panel
        sp1= new JPanel();
        sp1.setBounds(15,20,220,80);
        sp1.setLayout(null);
        sp1.setBackground(Color.red);
        sp1.addMouseListener(new MouseAdapter() {
            Color color = sp1.getBackground();
            public void mouseEntered(MouseEvent me) {
                color = sp1.getBackground();
                sp1.setBackground(Color.yellow);// change the color to green when mouse over a button
            }
            public void mouseExited(MouseEvent me) {
                sp1.setBackground(color);
            }
        });
        sidepanel.add(sp1);
       //calculate bill file open
        sp2= new JPanel();
        sp2.setBounds(15,125,220,80);
        sp2.setBackground(Color.red);
        sp2.setLayout(null);
        sp2.addMouseListener(new MouseAdapter() {
            Color color = sp2.getBackground();
            public void mouseEntered(MouseEvent me) {
                color = sp2.getBackground();
                sp2.setBackground(Color.yellow); // change the color to green when mouse over a button
            }
            public void mouseExited(MouseEvent me) {
                sp2.setBackground(color);
            }
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == sp2){
                    new CalculateBill();
                    setVisible(false);
                }
            }
        });
        sidepanel.add(sp2);

        sp3= new JPanel();
        sp3.setBounds(15,225,220,80);
        sp3.setBackground(Color.red);
        sp3.setLayout(null);
        sp3.addMouseListener(new MouseAdapter() {
            Color color = sp3.getBackground();
            public void mouseEntered(MouseEvent me) {
                color = sp3.getBackground();
                sp3.setBackground(Color.yellow);// change the color to green when mouse over a button
            }
            public void mouseExited(MouseEvent me) {
                sp3.setBackground(color);
            }
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == sp3){
                    new Histroy();
                    setVisible(false);
                }
            }
        });
        sidepanel.add(sp3);


        dashboard = new JLabel("Dashboard");
        dashboard.setBounds(60,20,150,40);
        dashboard.setBackground(new Color(0, 44, 0, 0));
        dashboard.setFont(smf);
        dashboard.setForeground(new Color(0, 0, 0, 181));
        sp1.add(dashboard);

        applyPolicy = new JLabel("CalculateBill");
        applyPolicy.setBounds(60,30,100,20);
        applyPolicy.setFont(smf);
        applyPolicy.setBackground(new Color(0x000002C, true));
        applyPolicy.setForeground(new Color(0, 0, 0, 181));
        sp2.add(applyPolicy);

        histroy = new JLabel("History");
        histroy.setBounds(60,30,100,20);
        histroy.setFont(smf);
        histroy.setBackground(new Color(0x000002C, true));
        histroy.setForeground(new Color(0, 0, 0, 181));
        sp3.add(histroy);

        //end of Side bar

//            small panel 1 details
        smpanel1 = new JPanel();
        smpanel1.setVisible(true);
        smpanel1.setBounds(260,100,200,100);
        smpanel1.setBackground(Color.blue);
        smpanel1.setLayout(null);
        smpanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == smpanel1) {
                    new Consumer();
                }
            }
        });
        background.add(smpanel1);

        avaPolicy= new JLabel("Total Consumer");
        avaPolicy.setBounds(5,10,150,40);
        avaPolicy.setForeground(Color.WHITE);
        avaPolicy.setFont(smpf);
        smpanel1.add(avaPolicy);

        n1 = new JLabel();
        n1.setBounds(130,40,70,60);
        n1.setHorizontalAlignment(JLabel.CENTER);
        n1.setForeground(Color.WHITE);
        n1.setFont(nf);
        //checking table
        String myquery = "select * from information_schema.tables where table_schema='water' and table_name='addcust';";
        try{
            ResultSet myrs = conn.sta.executeQuery(myquery);
            if (myrs.next()){
                String query3 ="select count(*) from addcust;";
                try {
                    ResultSet rs = conn.sta.executeQuery(query3);
                    if (rs.next()){
                        int i = Integer.parseInt(rs.getString(1));
                        n1.setText(String.valueOf(i));
                    }
                }catch (Exception e){
                    e.printStackTrace();

                }
            }else {
                n1.setText("0");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        smpanel1.add(n1);


//          small panel 2 details
        smpanel2 = new JPanel();
        smpanel2.setVisible(true);
        smpanel2.setBounds(480,100,200,100);
        smpanel2.setBackground(Color.blue);
        smpanel2.setLayout(null);
        background.add(smpanel2);

        appedPolicy= new JLabel("Total Water Consume");
        appedPolicy.setBounds(5,10,150,40);
        appedPolicy.setForeground(Color.WHITE);
        appedPolicy.setFont(smpf);
        smpanel2.add(appedPolicy);

        n2 = new JLabel();
        n2.setBounds(110,40,70,60);
        n2.setForeground(Color.WHITE);
        n2.setFont(nf);
        String myquery1 = "select * from information_schema.tables where table_schema='water' and table_name='addcust';";
        try {
            ResultSet myrs1 = conn.sta.executeQuery(myquery1);
            if (myrs1.next()){
                String query4 ="select sum(waterUsage) from addcust;";
                try {
                    ResultSet rs = conn.sta.executeQuery(query4);
                    if (rs.next()){
                        double i = Double.parseDouble(rs.getString(1));
                        n2.setText(String.valueOf(i));
                    }
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }else {
                n2.setText("0");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        n2.setHorizontalAlignment(JLabel.RIGHT);
        smpanel2.add(n2);

        smpanel3 = new JPanel();
        smpanel3.setVisible(true);
        smpanel3.setBounds(700,100,200,100);
        smpanel3.setBackground(Color.BLUE);
        smpanel3.setLayout(null);
        background.add(smpanel3);

        pcategory= new JLabel("Total Bill");
        pcategory.setBounds(5,10,150,40);
        pcategory.setForeground(Color.WHITE);
        pcategory.setFont(smpf);
        smpanel3.add(pcategory);

        n3 = new JLabel();
        n3.setBounds(110,40,70,60);
        n3.setForeground(Color.WHITE);
        n3.setFont(nf);
        String myquery2 = "select * from information_schema.tables where table_schema='water' and table_name='addcust';";
        try {
            ResultSet rs2 = conn.sta.executeQuery(myquery2);
            if (rs2.next()){
                String query5 ="select sum(bill) from addcust;";
                try {
                    ResultSet rs = conn.sta.executeQuery(query5);
                    if (rs.next()){
                        double i = Double.parseDouble(rs.getString(1));
                        n3.setText(String.valueOf(i));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                n3.setText("0");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        n3.setHorizontalAlignment(JLabel.RIGHT);
        smpanel3.add(n3);


        add(background);
        background.add(toppanel);
        background.add(sidepanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}