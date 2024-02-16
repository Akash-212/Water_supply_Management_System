package  water;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculateBill extends JFrame implements ActionListener {
    JLabel lblConsumerId, lblName, lblAddress, lblMobileNo, lblWaterUsage;
    JTextField txtConsumerId, txtName, txtAddress, txtMobileNo, txtWaterUsage;
    JButton btnCalculateBill,btnFetchDetails;
    String username2 = LoginPage.username2;
    Conn conn = new Conn();

    JLabel dashboard, applyPolicy,histroy, heading;
    JPanel sidepanel, toppanel,sp1,sp2,sp3,bpanel;
     CalculateBill() {
         Font f = new Font("Serif", Font.BOLD, 30);
         Font smpf = new Font("Serif", Font.BOLD, 18);
         Font nf = new Font("Serif", Font.BOLD, 30);
         Font smf = new Font("Bell MT", Font.BOLD, 14);

         //frame

         setSize(1400,850);
         setTitle("Calculate Bill");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         setResizable(false);



//        background
         ImageIcon bg=new ImageIcon("image/home.jpg");
         Image img= bg.getImage();
         Image temp_img=img.getScaledInstance(1400,850,Image.SCALE_SMOOTH);
         bg= new ImageIcon(temp_img);
         JLabel background =new JLabel("",bg,JLabel.CENTER);

         toppanel=new JPanel();
         toppanel.setBounds(0,0,1500,90);
         toppanel.setBackground(Color.black);
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
             public void mouseClicked(MouseEvent e) {
                 if (e.getSource() == sp1){
                     new Home();
                     setVisible(false);
                 }
             }
         });
         sidepanel.add(sp1);

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


         //bpanel starts here

         lblConsumerId = new JLabel("Consumer ID");
         lblConsumerId.setBounds(300,130,100,30);
         background.add(lblConsumerId);

         txtConsumerId = new JTextField();
         txtConsumerId.setBounds(430,130,200,40);
         txtConsumerId.setEditable(false);

         String query = "Select cid from addcust";
         try {
             ResultSet rs = conn.sta.executeQuery(query);
             while (rs.next()){
                 String cid = rs.getString(1);
                 int s= Integer.parseInt(cid);
                 int q= s+1;
                 txtConsumerId.setText(String.valueOf(q));

             }
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
         background.add(txtConsumerId);

         lblName = new JLabel("Consumer Name");
         lblName.setBounds(300,200,100,30);
         background.add(lblName);

         txtName = new JTextField();
         txtName.setBounds(430,200,200,40);
         background.add(txtName);

         lblAddress = new JLabel("Consumer Address");
         lblAddress.setBounds(300,270,160,30);
         background.add(lblAddress);

         txtAddress = new JTextField();
         txtAddress.setBounds(430,270,200,40);
         background.add(txtAddress);

         lblMobileNo = new JLabel("Consumer Mobile no");
         lblMobileNo.setBounds(300,340,160,30);
         background.add(lblMobileNo);

         txtMobileNo = new JTextField();
         txtMobileNo.setBounds(430,340,200,40);
         background.add(txtMobileNo);

         lblWaterUsage = new JLabel("water usage");
         lblWaterUsage.setBounds(300,410,160,30);
         background.add(lblWaterUsage);

         txtWaterUsage = new JTextField();
         txtWaterUsage.setBounds(430,410,200,40);
         background.add(txtWaterUsage);

         btnCalculateBill = new JButton("Calculate & Save");
         btnCalculateBill.setBounds(400,480,200,40);
         btnCalculateBill.addActionListener(this);
         background.add(btnCalculateBill);







         add(background);
         background.add(toppanel);
         background.add(sidepanel);
         setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalculateBill) {
            String consumerId = txtConsumerId.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            String mobileNo = txtMobileNo.getText();
            int waterUsage = Integer.parseInt(txtWaterUsage.getText());
            double bill = (waterUsage / 50.0) * 10;
            if (mobileNo.length() < 10) {
                JOptionPane.showMessageDialog(this, "Please enter a 10 digit mobile number.");
            } else {
                JOptionPane.showMessageDialog(this, "Consumer ID: " + consumerId + "\nName: " + name + "\nAddress: " + address + "\nMobile No: " + mobileNo + "\nWater Usage (in liters): " + waterUsage + "\nYour bill is Rs " + bill);
            }
            if(consumerId ==" "){
                JOptionPane.showMessageDialog(this, "Please enter Consumer id .");
            }
            if(mobileNo ==" "){
                JOptionPane.showMessageDialog(this, "Please enter a 10 digit mobile number.");
            }

            String query = "Select * from information_schema.tables where table_schema = 'water' and table_name = 'addcust'";
            try {
                ResultSet rs = conn.sta.executeQuery(query);
                if(rs.next()) {
                    String query2 = "insert into addcust values('" + consumerId + "','" + name + "','" + address + "','" + mobileNo + "','"+waterUsage+"','"+bill+"','"+username2+"')";
                    try {
                        int insertQuery = conn.sta.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null, "Save Successsfully", "Success", JOptionPane.PLAIN_MESSAGE);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Data Not Inserted", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else {
                    String query2 = "create table addcust(cid varchar(100), name varchar(100), address varchar(100),mobile varchar(10),waterUsage varchar(100), bill varchar(100),username varchar(100))";
                    int insertQuery = conn.sta.executeUpdate(query2);
                    System.out.println(insertQuery+"row/s upadted");
                    String query3 = "insert into addcust values('" + consumerId + "','" + name + "','" + address + "','" + mobileNo + "','"+waterUsage+"','"+bill+"','"+username2+"')";
                    try {
                        int insertQuery1 = conn.sta.executeUpdate(query3);
                        JOptionPane.showMessageDialog(null, "Save Successsfully", "Success", JOptionPane.PLAIN_MESSAGE);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Data Not Inserted", "Error", JOptionPane.ERROR_MESSAGE);
                    }


                }

            }catch (Exception ex){
                ex.printStackTrace();
            }



        }

    }

    public static void main(String[] args) {
       new CalculateBill();
    }
}
