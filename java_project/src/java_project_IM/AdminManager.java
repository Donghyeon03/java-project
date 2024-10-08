package java_project_IM;

import java_project_IM.UserManager;

public class AdminManager {
    private UserManager userManager;
    private String adminId = "manager";
    private String adminPassword = "0000";

    public AdminManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public boolean login(String id, String password) {
        return adminId.equals(id) && adminPassword.equals(password);
    }

    public void changeAdminCredentials(String newId, String newPassword) {
        adminId = newId;
        adminPassword = newPassword;
    }

    public User[] getUsers() {
        return userManager.getAllUsers();
    }

    public void deleteUser(String id) {
        userManager.deleteUser(id);
    }
}