public class Equipment {
    private String code;
    private String name;
    private boolean available; // true 代表可借用，false 代表已借出

    public Equipment(String code, String name) {
        this.code = code.trim();
        this.name = name.trim();
        this.available = true;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean borrow() {
        if (!available) {
            return false; // 已經借出了，無法再借
        }
        available = false;
        return true;
    }

    public boolean returnEquipment() {
        if (available) {
            return false; // 已經在庫，無需歸還
        }
        available = true;
        return true;
    }

    @Override
    public String toString() {
        String status = available ? "可借用" : "已借出";
        return "代碼: " + code + " | 名稱: " + name + " | 狀態: " + status;
    }
}