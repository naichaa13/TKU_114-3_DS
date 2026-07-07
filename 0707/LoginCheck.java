public class LoginCheck {
    public static void main(String[] args) {
        String username = "admin";
        String password = "1234";

        String inputUsername = "admin";
        String inputPassword = "1234";

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("登入成功");
        } else {
            System.out.println("帳號或密碼錯誤");
        }
    }
}
