import java.util.ArrayDeque;
import java.util.Deque;

public class TextEditorUndoSystem {
    private String content = "";
    private Deque<String> history = new ArrayDeque<>();

    public void append(String text) {
        history.push(content); // 修改前保存狀態
        content += text;
        System.out.println("新增文字：「" + content + "」");
    }

    public void deleteLast(int count) {
        if (count <= 0 || content.isEmpty())
            return;
        history.push(content); // 修改前保存狀態
        int newLength = Math.max(0, content.length() - count);
        content = content.substring(0, newLength);
        System.out.println("刪除字元，目前內容：「" + content + "」");
    }

    public void undo() {
        if (history.isEmpty()) {
            System.out.println("沒有可復原的歷史紀錄！");
            return;
        }
        content = history.pop();
        System.out.println("Undo 成功，目前內容：「" + content + "」");
    }

    public void show() {
        System.out.println("顯示內容：" + content);
    }

    public static void main(String[] args) {
        TextEditorUndoSystem editor = new TextEditorUndoSystem();

        editor.append("Java");
        editor.append(" Stack");
        editor.append(" Demo");
        editor.show();

        System.out.println("\n--- 連續 Undo 三次 ---");
        editor.undo();
        editor.undo();
        editor.undo();
        editor.show();

        System.out.println("\n--- 無歷史時的 Undo 測試 ---");
        editor.undo();
    }
}