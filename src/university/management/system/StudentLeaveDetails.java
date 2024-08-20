package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentLeaveDetails extends JFrame  implements ActionListener{
    
    Choice crollno;
  
    //JComboBox<String> crollno; // Use JComboBox instead of Choice
    JTable  table;
    JButton search ,print,update,add,cancel;
    
    StudentLeaveDetails() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
        add(crollno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM student");
            
            while (rs.next()) {
                crollno.add(rs.getString("rollno")); // Add roll number to JComboBox
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
        table = new JTable();
        
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM studentleave");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } 
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
      
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,1000,600);
        add(jsp);
        
       // JScrollPane jsp = new JScrollPane(table);
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
     
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
         
         cancel = new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        
       
        setSize(1000, 1000);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == search)
        {
          String query =" select * from studentleave where rollno = '"+crollno.getSelectedItem()+"'";  
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
             adjustColumnWidths(table);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       }
        else if(ae.getSource() == print)
        {
            try
            {
              table.print() ; 
            }catch(Exception e )
            {
                e.printStackTrace();
            }
        }
        

        else
        {
            setVisible(false);
        }
        
        
        
        
    }
    
    
    
    
    public static void main(String[] args) {
        new StudentLeaveDetails();
    }

    private void adjustColumnWidths(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}