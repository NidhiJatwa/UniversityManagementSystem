package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherLeaveDetails extends JFrame  implements ActionListener{
    
    Choice cEmpId;
  
    //JComboBox<String> crollno; // Use JComboBox instead of Choice
    JTable  table;
    JButton search ,print,cancel;
    
    TeacherLeaveDetails() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Employee Id");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        cEmpId = new Choice();
        cEmpId.setBounds(180, 20, 150, 20);
        add(cEmpId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM teacher");
            
            while (rs.next()) {
                cEmpId.add(rs.getString("empid")); // Add roll number to JComboBox
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
        table = new JTable();
        
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM teacherleave");
            
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
          String query =" select * from teacherleave where empid = '"+cEmpId.getSelectedItem()+"'";  
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
        new TeacherLeaveDetails();
    }

    private void adjustColumnWidths(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}