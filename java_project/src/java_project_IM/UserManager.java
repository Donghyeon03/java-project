package java_project_IM;

import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> users;
    private FileManager fileManager;

    public UserManager(FileManager fileManager) {
        this.fileManager = fileManager;
        users = fileManager.loadUsers(); // 사용자 정보를 파일에서 불러오기
    }

    public void signUp(String id, String password, String name, String birthDate, String phone, String address) {
        User newUser = new User(id, password, name, birthDate, phone, address);
        users.add(newUser);
        fileManager.saveUsers(users); // 사용자 정보를 파일에 저장
    }
    
    // ID 존재 여부 확인 메서드
    public boolean isUserExists(String id) {
        return fileManager.getUserById(id) != null;
    }

    public User login(String id, String password) {
        for (User user : users) {
            if (user.getId().equals(id) && user.getPassword().equals(password)) {
                return user; // 로그인 성공
            }
        }
        return null; // 로그인 실패
    }

    public User[] getAllUsers() {
        return users.toArray(new User[0]); // ArrayList를 배열로 변환하여 반환
    }

    public void deleteUser(String id) {
        users.removeIf(user -> user.getId().equals(id)); // ID가 일치하는 사용자 삭제
        fileManager.saveUsers(users); // 사용자 정보를 파일에 저장
    }

    // 사용자 정보 수정 메서드 추가
    public void updateUser(String id, String name, String birthDate, String phone, String address) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                user.setName(name);
                user.setBirthDate(birthDate);
                user.setPhone(phone);
                user.setAddress(address);
                fileManager.saveUsers(users); // 변경 사항 저장
                return; // 수정 후 메서드 종료
            }
        }
        throw new IllegalArgumentException("사용자를 찾을 수 없습니다."); // 사용자가 없을 경우 예외 발생
    }
    
    //회원탈퇴
    public void deleteUser_user(String id) {
        ArrayList<User> users = fileManager.loadUsers(); // 기존 사용자 로드
        users.removeIf(user -> user.getId().equals(id)); // 해당 ID의 사용자 삭제
        fileManager.saveUsers(users); // 수정된 사용자 목록 저장
    }

}
