package java_project_IM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private UserManager userManager;
    private AdminManager adminManager;

    public Main() {
        FileManager fileManager = new FileManager();
        userManager = new UserManager(fileManager);
        adminManager = new AdminManager(userManager);

        setTitle("정보관리 프로그램");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        // 로그인 패널
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(2, 3));

        JLabel idLabel = new JLabel("아이디:");
        JTextField idField = new JTextField();
        JLabel passwordLabel = new JLabel("비밀번호:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("로그인");

        loginPanel.add(idLabel);
        loginPanel.add(idField);
        loginPanel.add(loginButton);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
    
        add(loginPanel);

        // 회원가입 및 관리자 모드 버튼
        JButton signUpButton = new JButton("회원가입");
        JButton adminModeButton = new JButton("관리자모드");
        add(signUpButton);
        add(adminModeButton);

     // 로그인 버튼 클릭 시
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String password = new String(passwordField.getPassword());

                if (!userManager.isUserExists(id)) {
                    // ID가 없으면 등록된 정보가 없다고 출력
                    JOptionPane.showMessageDialog(null, "등록된 정보 없음!");
                } else {
                    // ID는 존재하지만 비밀번호가 틀리면 경고 출력
                    User user = userManager.login(id, password);
                    if (user != null) {
                        JOptionPane.showMessageDialog(null, "로그인 성공!");
                        new UserInfoWindow(userManager, user); // 사용자 정보 창 열기
                    } else {
                        JOptionPane.showMessageDialog(null, "비밀번호를 잘못 입력하셨습니다!");
                    }
                }
            }
        });
        
     // 회원가입 버튼 클릭 시
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SignUpWindow(userManager);
            }
        });


        // 관리자 모드 버튼 클릭 시
        adminModeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdminLoginWindow(adminManager);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}
