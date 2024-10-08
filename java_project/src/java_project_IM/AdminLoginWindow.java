package java_project_IM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginWindow extends JFrame {
    private AdminManager adminManager;

    public AdminLoginWindow(AdminManager adminManager) {
        this.adminManager = adminManager;

        setTitle("관리자 로그인");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 3));

        JLabel idLabel = new JLabel("관리자 ID:");
        JTextField idField = new JTextField();
        JButton loginButton = new JButton("로그인");
        JLabel passwordLabel = new JLabel("비밀번호:");
        JPasswordField passwordField = new JPasswordField();
        

        add(idLabel);
        add(idField);
        add(loginButton);
        add(passwordLabel);
        add(passwordField);
       

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String password = new String(passwordField.getPassword());
                if (adminManager.login(id, password)) {
                    JOptionPane.showMessageDialog(null, "관리자 로그인 성공!");
                    new AdminWindow(adminManager); // 관리자 창 열기
                    dispose(); // 로그인 창 닫기
                } else {
                    JOptionPane.showMessageDialog(null, "로그인 실패!");
                }
            }
        });

        setVisible(true);
    }
}
