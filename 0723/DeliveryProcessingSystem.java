import java.util.ArrayDeque;
import java.util.Deque;

public class DeliveryProcessingSystem {
    private Deque<DeliveryTask> waitingQueue = new ArrayDeque<>();
    private Deque<DeliveryTask> completedStack = new ArrayDeque<>();

    // 1. 新增
    public void addTask(String taskId, String destination) {
        DeliveryTask task = new DeliveryTask(taskId, destination);
        waitingQueue.offer(task);
        System.out.println("[新增任務] 已加入待配送佇列：" + task);
    }

    // 2. 完成下一筆工作 (從 Queue 取出並 push 到 Stack 紀錄)
    public void processNextTask() {
        if (waitingQueue.isEmpty()) {
            System.out.println("[處理提醒] 目前沒有等待中的配送任務。");
            return;
        }
        DeliveryTask task = waitingQueue.poll();
        completedStack.push(task);
        System.out.println("[完成配送] 任務 " + task.getTaskId() + " 已完成，已移至完成紀錄。");
    }

    // 3. 查看下一筆待配送工作
    public void peekNextTask() {
        if (waitingQueue.isEmpty()) {
            System.out.println("[下一筆任務] 目前佇列為空。");
        } else {
            System.out.println("[下一筆待配送] " + waitingQueue.peek());
        }
    }

    // 4. 復原最近完成的工作（從 Stack pop，並 offer 回等待 Queue 尾端）
    public void undoLastCompleted() {
        if (completedStack.isEmpty()) {
            System.out.println("[復原失敗] 沒有已完成的任務可供復原。");
            return;
        }
        DeliveryTask task = completedStack.pop();
        waitingQueue.offer(task); // 復原後工作回到等待 Queue 尾端
        System.out.println("[復原任務] 已將任務 " + task.getTaskId() + " 撤銷，放回等待佇列尾端。");
    }

    // 5. 輸出等待數、完成數與所有處理紀錄
    public void showSystemStatus() {
        System.out.println("\n=== 配送系統狀態總覽 ===");
        System.out.println("等待配送數量：" + waitingQueue.size() + " 筆");
        System.out.println("已完成紀錄數量：" + completedStack.size() + " 筆");

        System.out.println("\n--- 【等待佇列明細 (Queue)】 ---");
        if (waitingQueue.isEmpty()) {
            System.out.println("(無)");
        } else {
            int i = 1;
            for (DeliveryTask t : waitingQueue) {
                System.out.println(i + ". " + t);
                i++;
            }
        }

        System.out.println("\n--- 【完成紀錄明細】 ---");
        if (completedStack.isEmpty()) {
            System.out.println("(無)");
        } else {
            int i = 1;
            for (DeliveryTask t : completedStack) {
                System.out.println(i + ". " + t);
                i++;
            }
        }
        System.out.println("\n---------------------");
    }

    public static void main(String[] args) {
        DeliveryProcessingSystem system = new DeliveryProcessingSystem();

        System.out.println("=== 測試配送工作流程系統 ===\n");
        system.addTask("D01", "台北市信義路一段 100 號");
        system.addTask("D02", "台中市西屯區台灣大道三段");
        system.addTask("D03", "高雄市前鎮區中山二路");

        system.showSystemStatus();

        System.out.println("\n--- 執行完成工作 ---");
        system.processNextTask();
        system.processNextTask();

        system.showSystemStatus();

        System.out.println("\n--- 執行復原最近完成 (Undo) ---");
        system.undoLastCompleted(); // 將 D02 放回等待 Queue 尾端

        system.showSystemStatus();
    }
}