package view;

import service.LoginService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    public static String puname;
    public static String ppaswd;
    JButton blogin = new JButton("Login");
    JPanel panel = new JPanel();
    JTextField txuser = new JTextField(15);
    JPasswordField pass = new JPasswordField(15);
    JLabel userlabel = new JLabel("USER:");
    JLabel passlabel = new JLabel("PASSWORD:");

    LoginView() {
        super("Login Autentification");
        setSize(300, 200);
        setLocation(500, 280);
        panel.setLayout(null);


        txuser.setBounds(70, 30, 150, 20);
        pass.setBounds(70, 65, 150, 20);
        blogin.setBounds(110, 100, 80, 20);
        userlabel.setBounds(70, 10, 150, 20);
        passlabel.setBounds(70, 45, 150, 20);

        panel.add(blogin);
        panel.add(txuser);
        panel.add(pass);
        panel.add(userlabel);
        panel.add(passlabel);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        actionlogin();
    }

    public static void main(String[] args) {
        LoginView frameTabel = new LoginView();
    }

    public void actionlogin() {
        blogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                puname = txuser.getText();
                ppaswd = pass.getText();
                if (LoginService.checkLogin(puname, ppaswd) == 1) {
                    AdminView paneladmin;
                    try {
                        paneladmin = new AdminView();
                        paneladmin.setVisible(true);
                        dispose();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                } else if (LoginService.checkLogin(puname, ppaswd) == 0) {

                    RegularUserView regularUserView;
                    try {
                        regularUserView = new RegularUserView();
                        regularUserView.setVisible(true);
                        dispose();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Wrong Username / Password");
                    txuser.setText("");
                    pass.setText("");
                    txuser.requestFocus();
                }
            }
        });
    }
}