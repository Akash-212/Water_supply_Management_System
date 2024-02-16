package water;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

import static water.LoginPage.username2;

public class Consumer extends JFrame {

    DefaultTableModel model;
    Conn conn = new Conn();
    JFrame frame;
    Consumer(){
        setSize(1000,600);
        setTitle("Fetch");
        setLocationRelativeTo(null);
        setResizable(false);




        String col[]={"Slno","Name","Address","Mobile","WaterUsage","Bill"};

        JTable table = new JTable();

        model = new DefaultTableModel();
        table.setModel(model);

        model.setColumnIdentifiers(col);
        JScrollPane pane  = new JScrollPane(table);
        pane.setBounds(0,0,1200,800);
        add(pane);

        int count =1;
        String query = "Select * from addcust";
        try {
            ResultSet rs = conn.sta.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString(2);
                String add = rs.getString(3);
                String mob = rs.getString(4);
                String wateru = rs.getString(5);
                String bill = rs.getString(6);

                model.addRow(new Object[]{count,name,add,mob, wateru, bill});
                count++;

            }
        }catch (Exception e){
            e.printStackTrace();
        }


        setVisible(true);
    }

    public static void main(String[] args) {
        new Consumer();
    }
}
