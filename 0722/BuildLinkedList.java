public class BuildLinkedList {
    public static void main(String[] args) {
        // 1. 建立 10、20、30、40 四個 Node
        IntNode head = new IntNode(10);
        head.next = new IntNode(20);
        head.next.next = new IntNode(30);
        head.next.next.next = new IntNode(40);

        // 2. 測試空串列狀況（防禦性寫法範例）
        System.out.println("=== 邊界測試：空串列檢查 ===");
        printAndCountList(null);

        // 3. 由 head 走訪輸出、計算節點數與總和
        System.out.println("\n=== 正式鏈結串列資料走訪 ===");
        printAndCountList(head);
    }

    public static void printAndCountList(IntNode head) {
        if (head == null) {
            System.out.println("鏈結串列為空 (head == null)");
            System.out.println("節點數：0");
            System.out.println("總和：0");
            return;
        }

        IntNode current = head;
        int count = 0;
        int sum = 0;

        System.out.print("鏈結內容：");
        while (current != null) {
            System.out.print(current.data + " -> ");
            sum += current.data;
            count++;
            current = current.next;
        }
        System.out.println("null");

        System.out.println("節點數：" + count);
        System.out.println("總和：" + sum);
    }
}