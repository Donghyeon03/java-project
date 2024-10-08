package java_project_IM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInfoWindow extends JFrame {
    private UserManager userManager;
    private User user;

    public UserInfoWindow(UserManager userManager, User user) {
        this.userManager = userManager;
        this.user = user;

        setTitle("회원 정보");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // 회원 정보 입력 패널
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(6, 2)); // 6행 2열의 그리드 레이아웃

        // 회원 정보 입력 필드
        JLabel idLabel = new JLabel("아이디:");
        JTextField idField = new JTextField(user.getId());
        idField.setEditable(false); // ID는 수정 불가

        JLabel nameLabel = new JLabel("이름:");
        JTextField nameField = new JTextField(user.getName());

        JLabel birthDateLabel = new JLabel("생년월일:");
        JTextField birthDateField = new JTextField(user.getBirthDate());

        JLabel phoneLabel = new JLabel("전화번호:");
        JTextField phoneField = new JTextField(user.getPhone());

        JLabel addressLabel = new JLabel("주소:");
        JTextField addressField = new JTextField(user.getAddress());

        // 컴포넌트를 infoPanel에 추가
        infoPanel.add(idLabel);
        infoPanel.add(idField);
        infoPanel.add(nameLabel);
        infoPanel.add(nameField);
        infoPanel.add(birthDateLabel);
        infoPanel.add(birthDateField);
        infoPanel.add(phoneLabel);
        infoPanel.add(phoneField);
        infoPanel.add(addressLabel);
        infoPanel.add(addressField);

        // 버튼 패널 추가
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout()); // 수평으로 배치
        JButton saveButton = new JButton("저장");
        JButton cancelButton = new JButton("취소");
        JButton deleteButton = new JButton("회원 탈퇴"); // 회원 탈퇴 버튼 추가

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(deleteButton); // 회원 탈퇴 버튼 추가

        // 패널을 프레임에 추가
        add(infoPanel, BorderLayout.CENTER); // 회원 정보 입력 패널
        add(buttonPanel, BorderLayout.SOUTH); // 버튼 패널

        // 저장 버튼 클릭 시
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String birthDate = birthDateField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();

                // 사용자 정보를 수정하고 저장
                userManager.updateUser(user.getId(), name, birthDate, phone, address);
                JOptionPane.showMessageDialog(null, "정보가 수정되었습니다.");
            }
        });

        // 취소 버튼 클릭 시
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // 창 닫기
            }
        });

        // 회원 탈퇴 버튼 클릭 시
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "정말로 회원탈퇴 하시겠습니까?", "회원 탈퇴", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    userManager.deleteUser(user.getId()); // 사용자 삭제 메서드 호출
                    JOptionPane.showMessageDialog(null, "회원 탈퇴가 완료되었습니다.");
                    dispose(); // 창 닫기
                }
            }
        });

        setVisible(true);
    }
}


