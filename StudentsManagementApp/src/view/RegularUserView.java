package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegularUserView extends JFrame {

    private JPanel contentPane;

    public RegularUserView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 661, 389);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUser = new JLabel("Home");
        lblUser.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblUser.setBounds(27, 13, 95, 43);
        contentPane.add(lblUser);

        JButton btnNewButton = new JButton("Account Information");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                AccountView accountView;
                try {
                    accountView = new AccountView();
                    accountView.setVisible(true);
                    dispose();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(103, 60, 259, 25);
        contentPane.add(btnNewButton);

        JButton btnViewGrades = new JButton("View Grades");
        btnViewGrades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                GradeView gradeView;
                try {
                    gradeView = new GradeView();
                    gradeView.setVisible(true);
                    dispose();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        btnViewGrades.setBounds(103, 100, 259, 25);
        contentPane.add(btnViewGrades);

        JButton btnLogout = new JButton("LogOut");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginView log;
                try {
                    log = new LoginView();
                    log.setVisible(true);
                    dispose();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btnLogout.setBounds(103, 260, 259, 25);
        contentPane.add(btnLogout);
    }
}
