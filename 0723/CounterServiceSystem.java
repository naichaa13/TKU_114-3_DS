import java.util.ArrayDeque;
import java.util.Deque;

public class CounterServiceSystem {
    public static void main(String[] args) {
        Deque<String> queue = new ArrayDeque<>();
        Deque<String> history = new ArrayDeque<>();

        takeNumber(queue, "A001 Amy");
        takeNumber(queue, "A002 Ben");
        takeNumber(queue, "A003 Cara");

        showStatus(queue);
        callNext(queue, history);
        callNext(queue, history);
        showStatus(queue);

        // 空 Queue 叫號安全測試
        callNext(queue, history);
        callNext(queue, history);

        System.out.println("處理紀錄：" + history);
    }

    public static void takeNumber(Deque<String> queue, String customer) {
        queue.offer(customer);
        System.out.println("取號成功：" + customer);
    }

    public static void callNext(Deque<String> queue, Deque<String> history) {
        String customer = queue.poll();
        if (customer == null) {
            System.out.println("目前無人等待。");
        } else {
            System.out.println("叫號服務：" + customer);
            history.push(customer);
        }
    }

    public static void showStatus(Deque<String> queue) {
        System.out.println("下一位：" + (queue.peek() != null ? queue.peek() : "無") + " | 等待人數：" + queue.size());
    }
}