public class Course {
    private String code;
    private String name;
    private int capacity;
    private int enrolled;

    public Course(String code, String name, int capacity) {
        this.code = code.trim();
        this.name = name.trim();
        this.capacity = Math.max(capacity, 1);
        this.enrolled = 0; // 初始選課人數為 0
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolled() {
        return enrolled;
    }

    // 規則：課程額滿後不可再增加人數
    public boolean enrollStudent() {
        if (enrolled >= capacity) {
            return false; // 額滿，選課失敗
        }
        enrolled++;
        return true;
    }

    public boolean dropStudent() {
        if (enrolled <= 0) {
            return false; // 目前無人選課，無法退選
        }
        enrolled--;
        return true;
    }

    public boolean isFull() {
        return enrolled >= capacity;
    }

    @Override
    public String toString() {
        String status = isFull() ? " [已額滿]" : "";
        return "代碼: " + code + " | 名稱: " + name + " | 容量: " + capacity + " | 目前人數: " + enrolled + status;
    }
}