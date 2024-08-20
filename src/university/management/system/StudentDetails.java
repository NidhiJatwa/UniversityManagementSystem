package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentDetails extends JFrame  implements ActionListener{
    
    Choice crollno;
  
    //JComboBox<String> crollno; // Use JComboBox instead of Choice
    JTable  table;
    JButton search ,print,update,add,cancel;
    
    StudentDetails() {
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
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error accessing student details: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
        table = new JTable();
        
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM student");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error accessing student details: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
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
        
        
         add = new JButton("Add");
        add.setBounds(220,70,80,20);
        add.addActionListener(this);
        add(add);
        
        
         update = new JButton("Update");
        update.setBounds(320,70,80,20);
        update.addActionListener(this);
        add(update);
        
         
         cancel = new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
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
          String query =" select * from student where rollno = '"+crollno.getSelectedItem()+"'";  
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
        
        else if(ae.getSource() == add)
        {
            setVisible(false);
            new AddStudent();
        }
        else if(ae.getSource() == update)
        {
            setVisible(false);
            new UpdateStudent();
        }
        else
        {
            setVisible(false);
        }
        
        
        
        
    }
    
    public static void main(String[] args) {
        new StudentDetails();
    }

    private void adjustColumnWidths(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}