public class Contact {
    private String code;
    private String name;
    private String phone;
    private String email;

    public Contact(String code, String name, String phone, String email) {
        this.code = code.trim();
        this.name = name.trim();
        this.phone = phone.trim();
        this.email = email.trim();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        if (phone != null && !phone.trim().isEmpty()) {
            this.phone = phone.trim();
        }
    }

    @Override
    public String toString() {
        return "代碼: " + code + " | 姓名: " + name + " | 電話: " + phone + " | 電郵: " + email;
    }
}