public class TaskLinkedListSystem {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        System.out.println("=== 1. 測試空串列狀態 ===");
        taskList.printAllTasks();
        System.out.println("工作總數：" + taskList.size() + " | 未完成數量：" + taskList.getIncompleteCount());

        System.out.println("\n=== 2. 測試新增工作 (一般工作加到尾端，緊急工作加到前端) ===");
        taskList.addTaskLast("T01", "寫 Java 數據結構作業");
        taskList.addTaskLast("T02", "準備下午的組員會議");
        taskList.addTaskFirst("T00", "【緊急】修復登入系統的重大 Bug"); // 加到前端

        taskList.printAllTasks();
        System.out.println("工作總數：" + taskList.size() + " | 未完成數量：" + taskList.getIncompleteCount());

        System.out.println("\n=== 3. 測試將部分工作標記為「已完成」(完成 T01) ===");
        taskList.completeTask("T01");
        taskList.printAllTasks();

        System.out.println("\n=== 4. 測試列出「未完成」工作清單 ===");
        taskList.printIncompleteTasks();

        System.out.println("\n=== 5. 測試刪除工作 (刪除第一項緊急工作 T00) ===");
        taskList.removeTask("T00");
        taskList.printAllTasks();

        System.out.println("\n=== 6. 測試刪除最後一項工作 (刪除 T02) ===");
        taskList.removeTask("T02");
        taskList.printAllTasks();

        System.out.println("\n=== 7. 最終統計結果 ===");
        System.out.println("工作總數：" + taskList.size() + " 筆");
        System.out.println("未完成數量：" + taskList.getIncompleteCount() + " 筆");
    }
}