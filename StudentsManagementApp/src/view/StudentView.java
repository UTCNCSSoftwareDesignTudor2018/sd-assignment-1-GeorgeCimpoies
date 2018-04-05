package view;

import service.ActivityService;
import service.LoginService;
import service.StudentService;
import service.TableService;
import utils.CustomTextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StudentView extends JFrame {

    private JPanel contentPane;
    private CustomTextField name;
    private CustomTextField identityCardNumber;
    private CustomTextField personalNumericCode;
    private CustomTextField address;
    private CustomTextField group;
    private CustomTextField username;
    private CustomTextField password;
    private JTable table;

    public StudentView() throws Exception {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1316, 530);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        name = new CustomTextField(10);
        name.setBounds(105, 94, 237, 34);
        name.setPlaceholder("Name");
        contentPane.add(name);

        identityCardNumber = new CustomTextField(10);
        identityCardNumber.setBounds(105, 139, 237, 34);
        identityCardNumber.setPlaceholder("Identity Card Number");
        contentPane.add(identityCardNumber);

        personalNumericCode = new CustomTextField(10);
        personalNumericCode.setBounds(105, 186, 237, 34);
        personalNumericCode.setPlaceholder("Personal Numerical Code");
        contentPane.add(personalNumericCode);

        address = new CustomTextField(10);
        address.setBounds(105, 233, 237, 34);
        address.setPlaceholder("Address");
        contentPane.add(address);

        group = new CustomTextField(10);
        group.setBounds(105, 278, 237, 34);
        group.setPlaceholder("Group");
        contentPane.add(group);

        username = new CustomTextField(10);
        username.setBounds(105, 323, 237, 34);
        username.setPlaceholder("Username");
        contentPane.add(username);

        password = new CustomTextField(10);
        password.setBounds(105, 368, 237, 34);
        password.setPlaceholder("Password");
        contentPane.add(password);

        JLabel lblNewLabel_1 = new JLabel("Student Panel");
        lblNewLabel_1.setFont(new Font("Constantia", Font.PLAIN, 24));
        lblNewLabel_1.setBounds(12, 25, 323, 46);
        contentPane.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("ADD");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nameText = name.getText();
                String identityCardNumberText = identityCardNumber.getText();
                String personalNumericCodeText = personalNumericCode.getText();
                String addressText = address.getText();
                String groupText = group.getText();
                String usernameText = username.getText();
                String passwordText = password.getText();

                StudentService.addStudent(nameText, identityCardNumberText, personalNumericCodeText, addressText, groupText, usernameText, passwordText);
                ActivityService.addActivity("Added new student", LoginView.puname);

                try {
                    table.setModel(TableService.readTableStudents());
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
        });
        btnNewButton.setBounds(445, 139, 155, 34);
        contentPane.add(btnNewButton);

        JButton btnRemove = new JButton("REMOVE");
        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String personalNumericCodeText = personalNumericCode.getText();
                StudentService.removeStudent(Integer.parseInt(personalNumericCodeText));
                ActivityService.addActivity("Deleted client", LoginView.puname);
                try {
                    table.setModel(TableService.readTableStudents());
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btnRemove.setBounds(445, 186, 155, 34);
        contentPane.add(btnRemove);

        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nameText = name.getText();
                String identityCardNumberText = identityCardNumber.getText();
                String personalNumericCodeText = personalNumericCode.getText();
                String addressText = address.getText();
                String groupText = group.getText();
                String usernameText = username.getText();
                String passwordText = password.getText();

                StudentService.updateStudent(nameText, identityCardNumberText, personalNumericCodeText, addressText, groupText, usernameText, passwordText);
                ActivityService.addActivity("Updated student", LoginView.puname);

                try {
                    table.setModel(TableService.readTableStudents());
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btnUpdate.setBounds(445, 233, 155, 34);
        contentPane.add(btnUpdate);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(695, 25, 591, 320);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JButton btnLoad = new JButton("LOAD");
        btnLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    table.setModel(TableService.readTableStudents());
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btnLoad.setBounds(445, 94, 155, 34);
        contentPane.add(btnLoad);

        JLabel lblnoteThatFor = new JLabel("**Note that for UPDATE and ADD all fields must be completed while for REMOVE only the Personal Numerical Code must be filled out.");
        lblnoteThatFor.setBounds(12, 435, 736, 34);
        contentPane.add(lblnoteThatFor);

        JButton btnNewButton_1 = new JButton("HOME");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (LoginService.checkLogin(LoginView.puname, LoginView.ppaswd) == 1) {
                    AdminView paneladmin;
                    try {
                        paneladmin = new AdminView();
                        paneladmin.setVisible(true);
                        dispose();
                    } catch (Exception ex) {
                        // TODO Auto-generated catch block
                        ex.printStackTrace();
                    }

                } else if (LoginService.checkLogin(LoginView.puname, LoginView.ppaswd) == 0) {

                    RegularUserView regularUserView;
                    try {
                        regularUserView = new RegularUserView();
                        regularUserView.setVisible(true);
                        dispose();
                    } catch (Exception exc) {
                        // TODO Auto-generated catch block
                        exc.printStackTrace();
                    }
                }
            }
        });
        btnNewButton_1.setBounds(445, 280, 157, 34);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("LogOut");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginView loginView;
                try {
                    loginView = new LoginView();
                    loginView.setVisible(true);
                    dispose();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_2.setBounds(1201, 358, 97, 25);
        contentPane.add(btnNewButton_2);
    }
}