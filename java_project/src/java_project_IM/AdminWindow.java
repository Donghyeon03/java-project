package java_project_IM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminWindow extends JFrame {
    private AdminManager adminManager;

    public AdminWindow(AdminManager adminManager) {
        this.adminManager = adminManager;

        setTitle("관리자 모드");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 회원 정보 표시 영역
        JTextArea userInfoArea = new JTextArea();
        userInfoArea.setEditable(false);
        loadUserInformation(userInfoArea);
        add(new JScrollPane(userInfoArea), BorderLayout.CENTER);

        // 회원 삭제 패널
        JPanel deletePanel = new JPanel();
        deletePanel.setLayout(new FlowLayout());

        JLabel deleteIdLabel = new JLabel("삭제할 회원 ID:");
        JTextField deleteIdField = new JTextField(10);
        JButton deleteButton = new JButton("회원 삭제");

        deletePanel.add(deleteIdLabel);
        deletePanel.add(deleteIdField);
        deletePanel.add(deleteButton);

        add(deletePanel, BorderLayout.SOUTH);

        // 회원 삭제 버튼 클릭 시
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idToDelete = deleteIdField.getText();
                adminManager.deleteUser(idToDelete);
                JOptionPane.showMessageDialog(null, "회원 삭제 완료!");
                loadUserInformation(userInfoArea); // 업데이트된 정보 다시 로드
            }
        });

        setVisible(true);
    }

    private void loadUserInformation(JTextArea userInfoArea) {
        userInfoArea.setText(""); // 기존 내용 지우기
        User[] users = adminManager.getUsers();
        for (User user : users) {
            userInfoArea.append(user.getInfo() + "\n\n");
        }
    }
}
