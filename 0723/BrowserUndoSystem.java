import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserUndoSystem {
    public static void main(String[] args) {
        Deque<String> history = new ArrayDeque<>();

        // 至少 8 次操作測試
        visitPage(history, "Home"); // 1
        visitPage(history, "Courses"); // 2
        visitPage(history, "Java"); // 3
        showCurrent(history); // 4
        visitPage(history, "Stack"); // 5
        showCurrent(history); // 6
        goBack(history); // 7
        goBack(history); // 8
        showCurrent(history); // 9

        // 測試空結構安全
        goBack(history);
        goBack(history);
        goBack(history);
    }

    public static void visitPage(Deque<String> history, String page) {
        history.push(page);
        System.out.println("開啟新頁：" + page);
    }

    public static void showCurrent(Deque<String> history) {
        if (history.isEmpty()) {
            System.out.println("目前沒有開啟任何頁面。");
        } else {
            System.out.println("目前頁面：" + history.peek());
        }
    }

    public static void goBack(Deque<String> history) {
        if (history.isEmpty()) {
            System.out.println("沒有上一頁可返回！");
            return;
        }
        String left = history.pop();
        System.out.println("返回上一頁，離開：" + left);
    }
}