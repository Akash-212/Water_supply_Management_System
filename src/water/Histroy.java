package  water;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Histroy extends JFrame implements ActionListener {
    JTextField txtConsumerId, txtName, txtAddress, txtMobileNo, txtWaterUsage, txtBill;
    JButton btnCalculateBill,btnFetchDetails;
    String username2 = LoginPage.username2;
    JTextField namel,namef,userfield, passfield, waterUsage, bill;
    Conn conn = new Conn();
    JButton submit;


    Histroy() {
        setTitle("Fetch Details");
        setSize(650,700);
        setLocation(400, 100);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel bg=new JLabel();
        ImageIcon i=new ImageIcon("project\\images\\pexels-jess-bailey-designs-1172849.jpg");
        Image img=i.getImage().getScaledInstance(650,700,Image.SCALE_DEFAULT);
        ImageIcon ii=new ImageIcon(img);
        bg.setIcon(ii);
        bg.setBounds(0,0,650,700);
        add(bg);

        JLabel head=new JLabel("Fetch Details");
        head.setBounds(190,50,300,50);
        head.setFont(new Font("Serif",Font.BOLD,40));
        bg.add(head);

        JLabel fname=new JLabel("Consumer ID");
        fname.setBounds(130,150,100,30);
        fname.setFont(new Font("Raleway",Font.BOLD,19));
        bg.add(fname);

        txtConsumerId=new JTextField();
        txtConsumerId.setBounds(260,150,200,30);
        txtConsumerId.setFont(new Font("Raleway",Font.BOLD,15));
        bg.add(txtConsumerId);

        JLabel lname =new JLabel("Name:");
        lname.setBounds(130,220,100,30);
        lname.setFont(new Font("Raleway",Font.BOLD,19));
        bg.add(lname);

        txtName=new JTextField();
        txtName.setBounds(260,220,200,30);
        txtName.setFont(new Font("Raleway",Font.BOLD,15));
        bg.add(txtName);


        JLabel water =new JLabel("WaterUsage:");
        water.setBounds(130,250,100,30);
        water.setFont(new Font("Raleway",Font.BOLD,19));
        bg.add(water);

        txtWaterUsage=new JTextField();
        txtWaterUsage.setBounds(260,250,200,30);
        txtWaterUsage.setFont(new Font("Raleway",Font.BOLD,15));
        bg.add(txtWaterUsage);

        JLabel bill =new JLabel("Bill:");
        bill.setBounds(130,280,100,30);
        bill.setFont(new Font("Raleway",Font.BOLD,19));
        bg.add(bill);

        txtBill=new JTextField();
        txtBill.setBounds(260,280,200,30);
        txtBill.setFont(new Font("Raleway",Font.BOLD,15));
        bg.add(txtBill);


        JLabel user=new JLabel("Address");
        user.setBounds(92,370,290,30);
        user.setFont(new Font("Raleway",Font.BOLD,19));
        bg.add(user);

        txtAddress=new JTextField();
        txtAddress.setBounds(260,370,200,30);
        txtAddress.setFont(new Font("Raleway",Font.BOLD,19));
        bg.add(txtAddress);

        JLabel pass=new JLabel("Mobile");
        pass.setBounds(92,420,290,30);
        pass.setFont(new Font("Raleway",Font.BOLD,19));
        bg.add(pass);

        txtMobileNo=new JTextField();
        txtMobileNo.setBounds(260,420,200,30);
        txtMobileNo.setFont(new Font("Raleway",Font.BOLD,19));
        bg.add(txtMobileNo);



        btnCalculateBill=new JButton("Back");
        btnCalculateBill.setBounds(220,580,150,30);
        btnCalculateBill.setFont(new Font("Arial",Font.BOLD,18));
        btnCalculateBill.setBackground(Color.BLACK);
        btnCalculateBill.setForeground(Color.WHITE);
        btnCalculateBill.addActionListener(this);
        bg.add(btnCalculateBill);

        btnFetchDetails=new JButton("FetchDetails");
        btnFetchDetails.setBounds(360,580,150,30);
        btnFetchDetails.setFont(new Font("Arial",Font.BOLD,18));
        btnFetchDetails.setBackground(Color.BLACK);
        btnFetchDetails.setForeground(Color.WHITE);
        btnFetchDetails.addActionListener(this);
        bg.add(btnFetchDetails);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalculateBill) {
                    new Home();
                    setVisible(false);
        }
        if (e.getSource() == btnFetchDetails){
           String cid = txtConsumerId.getText();

           String query = "Select * from addcust where cid ='"+cid+"' and username ='"+username2+"'";
            try {
                ResultSet rs = conn.sta.executeQuery(query);
                if (rs.next()){
                    String name = rs.getString(2);
                    String add = rs.getString(3);
                    String mob = rs.getString(4);
                    String wateru = rs.getString(5);
                    String bill = rs.getString(6);

                    txtName.setText(name);
                    txtAddress.setText(add);
                    txtMobileNo.setText(mob);
                    txtWaterUsage.setText(wateru);
                    txtBill.setText(bill);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }

    }

    public static void main(String[] args) {
        new Histroy();
    }
}
