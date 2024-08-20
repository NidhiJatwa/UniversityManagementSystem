
    
package university.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class AddTeacher extends JFrame implements ActionListener {
    
    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii, tfaadhar;
    JLabel labelempid; 
    JDateChooser dcdob;
    JComboBox<String> cbcourse, cbbranch;
    JButton submit, cancel;
    
    Random ran = new Random(); // Roll number auto-generated
    long first4 = Math.abs(ran.nextLong() % 9000L) + 1000L;
    
    AddTeacher() {
        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);
        
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        JLabel lblempid = new JLabel("Employee ID");
        lblempid.setBounds(50, 200, 200, 30);
        lblempid.setFont(new Font("serif", Font.BOLD, 20));
        add(lblempid);
        
        labelempid = new JLabel("101" + first4);
        labelempid.setBounds(200, 200, 200, 30);
        labelempid.setFont(new Font("serif", Font.BOLD, 20));
        add(labelempid);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        JLabel lblx = new JLabel("Class X(%)");
        lblx.setBounds(400, 300, 200, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);
        
        tfx = new JTextField();
        tfx.setBounds(600, 300, 150, 30);
        add(tfx);
        
        JLabel lblxii = new JLabel("Class XII(%)");
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);
        
        tfxii = new JTextField();
        tfxii.setBounds(200, 350, 150, 30);
        add(tfxii);
        
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(400, 350, 200, 30);
        lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        add(tfaadhar);
        
        JLabel lblcourse = new JLabel("Qualification");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);
        
        String[] course = {"B.Tech","P.H.D", "M.Tech", "BCA", "MCA", "B.Com", "M.Com", "BBA", "MBA", "BA", "MA"};
        cbcourse = new JComboBox<>(course);
        cbcourse.setBounds(200, 400, 150, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);
        
        String[] branch = {"Computer Science", "Mechanical", "Civil", "IT", "Electronics"};
        cbbranch = new JComboBox<>(branch);
        cbbranch.setBounds(600, 400, 150, 30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLUE);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submit) {
        String name = tfname.getText();
        String fname = tffname.getText();
        int empid = (int) (Math.abs(ran.nextLong() % 9000L) + 1000L); // Generate as integer
        String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
        String address = tfaddress.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String x = tfx.getText();
        String xii = tfxii.getText();
        String aadhar = tfaadhar.getText();
        String course = (String) cbcourse.getSelectedItem();
        String branch = (String) cbbranch.getSelectedItem();
        
        String query = "INSERT INTO teacher (name, fname, empid, dob, address, phone, email, class_x, class_xii, adhaar, Qualification, department) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem", "root", "*N@tw@*");
             PreparedStatement pstmt = con.prepareStatement(query)) {
             
            pstmt.setString(1, name);
            pstmt.setString(2, fname);
            pstmt.setInt(3, empid); // Use setInt if empid is an integer
            pstmt.setString(4, dob);
            pstmt.setString(5, address);
            pstmt.setString(6, phone);
            pstmt.setString(7, email);
            pstmt.setString(8, x);
            pstmt.setString(9, xii);
            pstmt.setString(10, aadhar);
            pstmt.setString(11, course);
            pstmt.setString(12, branch);
            
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Teacher's Details inserted Successfully");
            setVisible(false);
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error inserting teacher details: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    } else if (ae.getSource() == cancel) {
        setVisible(false);
    }
}

    public static void main(String[] args) {
        new AddTeacher();
    }
}
