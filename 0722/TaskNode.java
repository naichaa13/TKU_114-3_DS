public class TaskNode {
    private String code;
    private String description;
    private boolean completed; // true 代表已完成，false 代表未完成
    public TaskNode next;

    public TaskNode(String code, String description) {
        this.code = code.trim();
        this.description = description.trim();
        this.completed = false; // 預設新工作為未完成
        this.next = null;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        String status = completed ? "[已完成]" : "[未完成]";
        return "代碼: " + code + " | 說明: " + description + " | 狀態: " + status;
    }
}