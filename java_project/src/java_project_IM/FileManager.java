package java_project_IM;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private final String filePath = "C:\\Users\\jaeja\\git\\repository\\java_project\\src\\IM_v3\\member\\users.txt"; // 사용자 정보를 저장할 파일 경로

    // 사용자 정보를 파일에서 로드
    public ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<>();
        File file = new File(filePath);
        
        // 파일이 없으면 새로 생성
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs(); // 경로에 필요한 모든 디렉토리 생성
                file.createNewFile(); // 파일 생성
            } catch (IOException e) {
                e.printStackTrace();
            }
            return users; // 빈 리스트 반환
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); // 쉼표로 구분된 데이터
                if (data.length == 6) { // 사용자 정보가 6개 항목인지 확인
                    users.add(new User(data[0], data[1], data[2], data[3], data[4], data[5]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    // 사용자 정보를 파일에 저장
    public void saveUsers(ArrayList<User> users) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (User user : users) {
                bw.write(user.getId() + "," +
                          user.getPassword() + "," +
                          user.getName() + "," +
                          user.getBirthDate() + "," +
                          user.getPhone() + "," +
                          user.getAddress());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
 // ID로 사용자 검색하는 메서드 추가
    public User getUserById(String id) {
        ArrayList<User> users = loadUsers(); // 모든 사용자 로드
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user; // ID가 일치하는 사용자 반환
            }
        }
        return null; // 해당 ID의 사용자가 없을 경우 null 반환
    }
}

