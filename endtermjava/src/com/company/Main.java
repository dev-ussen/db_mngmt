package com.company;

import com.company.Employee.Department.*;

import com.company.Employee.EmployeeControl;
import com.company.ShipperControl.ShipperControl;
import com.company.database.IDB;
import com.company.database.PostgresDB;
import com.company.project.ProjectControl;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main implements ActionListener {
    //The listener interface for receiving action events.
    // The class that is interested in processing an action event implements this interface,
    // and the object created with that class is registered with a component, using the component's
    // addActionListener method. When the action event occurs, that object's actionPerformed method is invoked.
    private static JLabel userlabel;// for Username
    private static JTextField userText;// for inputting username text area
    private static JLabel passwordLabel;// for password
    private static JPasswordField passwordText;// for inputting password text area
    private static JButton button;// button
    private static JLabel success;// result of authorization
    public static void main(String[] args) {
        JFrame frame = new JFrame(); // we use SWING by making Frame
        JPanel panel = new JPanel(); // elements will be located in Panel
        frame.setSize(300, 300); // responsible for size of window
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // JFrame.DISPOSE_ON_CLOSE — Dispose of the frame object, but keep the application running.
        frame.setVisible(true);// responsible for visibility of frame
        frame.add(panel);// adding panel in frame
        panel.setLayout(null);// Layout responsible for location of components
        userlabel = new JLabel("Username"); // creating label USER
        userlabel.setBounds(10, 20, 80, 25); // coordinates of Label and size
        panel.add(userlabel); // adding USER label in panel
        userText = new JTextField(); // creating Text area, where we write username
        userText.setBounds(100,20,165,25); // location and size
        panel.add(userText);// adding text area in panel
        passwordLabel = new JLabel("Password"); // creating label Password
        passwordLabel.setBounds(10,50,80,25); // location and size of password label
        panel.add(passwordLabel); // adding in panel
        passwordText = new JPasswordField();// creating text area
        passwordText.setBounds(100, 50, 165, 25); // location and size
        panel.add(passwordText);//adding text area in panel
        button = new JButton("Login"); // creating button
        button.setBounds(10,80,80,25); // location and size
        button.addActionListener(new Main());
        panel.add(button); // adding button in panel
        success = new JLabel(""); // responsible for result inputting of username and password
        success.setBounds(10, 110, 1000, 25); // location and size
        panel.add(success);// adding object in panel
        frame.setVisible(true); // responsible for visibility of frame

        //Information about departments before user starts a work

        System.out.println("\n   Company's work divided to departments.\n" + Media.MediaInfo() + "\n" +
                Administration.AdminInfo() + "\n" + CommercialService.CommercialInfo() + "\n" +
                WorkerManagement.WorkerInfo() + "\n" + DepartmentOfReleaseAndAnalysis.RelAlINfo() + "\n" +
                TechnicalManagement.TechnicalInfo() );

        IDB db = new PostgresDB();//creating object of PostgresDB to get connection to database
        ShipperControl control = new ShipperControl(db);//creating object of ShipperControl with connection
        // to database(db) to use methods from class ShipperControl
        ProjectControl pcontrol = new ProjectControl(db);//creating object of ProjectControl with connection
        // to database(db) to use methods from class ProjectControl
        EmployeeControl mcontrol = new EmployeeControl(db);//creating object of EmployeeControl with connection
        // to database(db) to use methods from class EmployeeControl
        REYDI reydi = new REYDI(control, pcontrol, mcontrol); //REYDI - like application to
        reydi.startREYDI();//startREYDI starts application with options to take action
    }
    @Override
    public void actionPerformed(ActionEvent e) {// for run whenever we click that button
        String username = userText.getText();
        String password = passwordText.getText();
        if(username.equals("REYDI") && password.equals("qwerty123")){
            // It checks username and password; if it is true, it will output welcome
            success.setText("Welcome!");
        }
    }
}
