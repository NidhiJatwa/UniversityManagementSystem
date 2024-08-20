
package university.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,cancel;//global decleration of login and cancel button 
    JTextField tfusername,tfpassword;//global decleration
    
    Login()
{
    getContentPane().setBackground(Color.white);
    
    setLayout(null);
    JLabel lblusername = new JLabel("Username");
    lblusername.setBounds(40,20,100,20);
    add(lblusername);
    
     tfusername = new JTextField();//global decleration above
    tfusername.setBounds(150,20,150,20);
    add(tfusername);
    
    JLabel lblpassword = new JLabel("Password");
    lblpassword.setBounds(40,70,100,20);
    add(lblpassword);
    
    tfpassword = new JPasswordField();
    tfpassword.setBounds(150,70,150,20);
    add(tfpassword);
    
    login = new JButton("Login");
    login.setBounds(40,170,120,30);
    login.setBackground(Color.BLUE);
    login.setForeground(Color.white);
    login.setFont(new Font("Tahoma", Font.BOLD ,15));
    login.addActionListener(this);
    add(login);
    
    cancel = new JButton("cancel");
    cancel.setBounds(180,170,120,30);
    cancel.setBackground(Color.BLUE);
    cancel.setForeground(Color.white);
    cancel.setFont(new Font("Tahoma", Font.BOLD ,15));
    cancel.addActionListener(this);
    add(cancel);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3;
        i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0, 200 , 200);// as the layout is null so we have to use setbound here otherwise it will not be visible ,in the splash class we have used birder layout in which there is no need of setbound so we have not used it
        add(image);
        
        
    
setSize(600,300);
setLocation(500,250);
setVisible(true);
}
   // @Override
    //public void actionPerformed(ActionEvent ae)
   // {
      //  if(ae.getSource()==login)
        //{
            //String username = tfusername.getText();
           // String password = tfpassword.getText();

       
        
        // if (username.equals("admin") && password.equals("*N@tw@*;")) {
            //    System.out.println("Credentials correct. Opening Project frame.");
             //   setVisible(false); // Hide the current frame
             //   new Project(); // Open the Project frame
            //} else {
            //    JOptionPane.showMessageDialog(this, "Invalid username or password");
            //    System.out.println("Invalid credentials");
            

public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String correctUsername = System.getenv("DB_USERNAME"); // Get from environment
            String correctPassword = System.getenv("DB_PASSWORD"); // Get from environment
            
            String inputUsername = tfusername.getText(); // Get username from input field
            String inputPassword = new String(tfpassword.getText()); // Get password from input field
            
            // Validate credentials
            if (inputUsername.equals(correctUsername) && inputPassword.equals(correctPassword)) {
                System.out.println("Credentials correct. Opening Project frame.");
                setVisible(false); // Hide the current frame
                new Project().setVisible(true); // Open the Project frame
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
                System.out.println("Invalid credentials");
            }     
        }
         
else if (ae.getSource()==cancel)    
{
setVisible(false);
}
      
}          

    
public static void main(String[]args)
{
new Login();
}
}
