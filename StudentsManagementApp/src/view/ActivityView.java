package view;


import service.LoginService;
import service.TableService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActivityView extends JFrame {

    private JPanel contentPane;
    private JTextField from;
    private JTextField to;
    private JTable table;

    public ActivityView() throws Exception {


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1316, 530);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        from = new JTextField();
        from.setBounds(105, 94, 237, 34);
        contentPane.add(from);
        from.setColumns(10);

        to = new JTextField();
        to.setColumns(10);
        to.setBounds(105, 139, 237, 34);
        contentPane.add(to);


        JLabel lblProductId = new JLabel("From");
        lblProductId.setBounds(12, 94, 86, 34);
        contentPane.add(lblProductId);

        JLabel lblNewLabel = new JLabel("To");
        lblNewLabel.setBounds(12, 139, 81, 34);
        contentPane.add(lblNewLabel);


        JLabel lblNewLabel_1 = new JLabel("Activity PANEL");
        lblNewLabel_1.setFont(new Font("Constantia", Font.PLAIN, 24));
        lblNewLabel_1.setBounds(12, 25, 323, 46);
        contentPane.add(lblNewLabel_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(695, 25, 591, 298);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JButton btnLoad = new JButton("LOAD");
        btnLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String fromText = from.getText();
                String toText = to.getText();

                try {
                    table.setModel(TableService.readTableActivity(fromText, toText));
                    //	table=Managment.getTable("client");
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }


            }
        });
        btnLoad.setBounds(445, 94, 155, 34);
        contentPane.add(btnLoad);

        JLabel lblnoteThatFor = new JLabel("*Use the username");
        lblnoteThatFor.setBounds(12, 336, 736, 34);
        contentPane.add(lblnoteThatFor);

        JButton btnNewButton_1 = new JButton("HOME");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (LoginService.checkLogin(LoginView.puname, LoginView.ppaswd) == 0) {


                    RegularUserView regularUserView;
                    try {
                        regularUserView = new RegularUserView();
                        regularUserView.setVisible(true);
                        dispose();
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                } else if (LoginService.checkLogin(LoginView.puname, LoginView.ppaswd) == 1) {


                    AdminView adminView;
                    try {
                        adminView = new AdminView();
                        adminView.setVisible(true);
                        dispose();
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                }
            }
        });
        btnNewButton_1.setBounds(443, 186, 157, 34);
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

        JButton btnLoadAll = new JButton("LOAD ALL");
        btnLoadAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    table.setModel(TableService.readTableActivity());

                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btnLoadAll.setBounds(445, 144, 155, 34);
        contentPane.add(btnLoadAll);
    }
}
