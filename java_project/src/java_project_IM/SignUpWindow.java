package java_project_IM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpWindow extends JFrame {
    private UserManager userManager;

    public SignUpWindow(UserManager userManager) {
        this.userManager = userManager;

        setTitle("회원가입");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2)); // 7행 2열의 GridLayout 사용

        // 라벨과 텍스트 필드 배열 생성
        JLabel idLabel = new JLabel("아이디:");
        JTextField idField = new JTextField();
        
        JLabel passwordLabel = new JLabel("비밀번호:");
        JPasswordField passwordField = new JPasswordField();
        
        JLabel nameLabel = new JLabel("이름:");
        JTextField nameField = new JTextField();
        
        JLabel birthDateLabel = new JLabel("생년월일(ex:20240915):");
        JTextField birthDateField = new JTextField();
        
        JLabel phoneLabel = new JLabel("전화번호(ex:010-0000-0000):");
        JTextField phoneField = new JTextField();
        
        JLabel addressLabel = new JLabel("주소:");
        JTextField addressField = new JTextField();
        
        JButton signUpButton = new JButton("회원가입");
        
        // 컴포넌트를 프레임에 추가
        add(idLabel);
        add(idField);
        
        add(passwordLabel);
        add(passwordField);
        
        add(nameLabel);
        add(nameField);
        
        add(birthDateLabel);
        add(birthDateField);
        
        add(phoneLabel);
        add(phoneField);
        
        add(addressLabel);
        add(addressField);
        
        add(new JLabel()); // 빈 라벨로 간격을 맞춤
        add(signUpButton);

        // 회원가입 버튼 클릭 시
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String password = new String(passwordField.getPassword());
                String name = nameField.getText();
                String birthDate = birthDateField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();

                try {
                    userManager.signUp(id, password, name, birthDate, phone, address);
                    JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
                    dispose(); // 창 닫기
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        setVisible(true);
    }
}
