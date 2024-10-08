package java_project_IM;

public class User {
    private String id;
    private String password;
    private String name;
    private String birthDate;
    private String phone;
    private String address;

    public User(String id, String password, String name, String birthDate, String phone, String address) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getInfo() {
        return "ID: " + id + "\n이름: " + name + "\n생년월일: " + birthDate + 
               "\n전화번호: " + phone + "\n주소: " + address;
    }

    // 수정 메서드 추가
    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
