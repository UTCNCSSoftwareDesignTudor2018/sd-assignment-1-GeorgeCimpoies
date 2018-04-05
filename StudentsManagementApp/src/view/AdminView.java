package view;

import model.Exam;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminView extends JFrame {

    private JPanel contentPane;

    public AdminView() {
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

        JButton btnNewButton = new JButton("Students");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                StudentView studentView;
                try {
                    studentView = new StudentView();
                    studentView.setVisible(true);
                    dispose();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(103, 60, 259, 25);
        contentPane.add(btnNewButton);

        JButton btnNewButton_2 = new JButton("Teachers");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                TeacherView teacherView;
                try {
                    teacherView = new TeacherView();
                    teacherView.setVisible(true);
                    dispose();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_2.setBounds(103, 100, 259, 25);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Activities");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ActivityView activityView;
                try {
                    activityView = new ActivityView();
                    activityView.setVisible(true);
                    dispose();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_3.setBounds(103, 140, 259, 25);
        contentPane.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("Courses");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CourseView courseView;
                try {
                    courseView = new CourseView();
                    courseView.setVisible(true);
                    dispose();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_4.setBounds(103, 180, 259, 25);
        contentPane.add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("Enrollments");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EnrollmentView enrollmentView;
                try {
                    enrollmentView = new EnrollmentView();
                    enrollmentView.setVisible(true);
                    dispose();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_5.setBounds(103, 220, 259, 25);
        contentPane.add(btnNewButton_5);

        JButton btnNewButton_6 = new JButton("Exams");
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ExamView examView;
                try {
                    examView = new ExamView();
                    examView.setVisible(true);
                    dispose();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_6.setBounds(103, 260, 259, 25);
        contentPane.add(btnNewButton_6);

        JButton btnNewButtonLogout = new JButton("LogOut");
        btnNewButtonLogout.addActionListener(new ActionListener() {
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
        btnNewButtonLogout.setBounds(103, 300, 259, 25);
        contentPane.add(btnNewButtonLogout);
    }
}
