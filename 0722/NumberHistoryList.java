public class NumberHistoryList {
    private IntNode head;
    private int size;

    public NumberHistoryList() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // 1. 前端新增 (addFirst)
    public void addFirst(int value) {
        IntNode newNode = new IntNode(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // 2. 尾端新增 (addLast) - 處理空串列與走訪
    public void addLast(int value) {
        IntNode newNode = new IntNode(value);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        IntNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    // 3. 搜尋 (contains)
    public boolean contains(int target) {
        IntNode current = head;
        while (current != null) {
            if (current.data == target) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // 4. 刪除指定值 (removeValue) - 處理 head、中間、最後與找不到
    public boolean removeValue(int target) {
        if (head == null) {
            return false;
        }

        // 處理刪除 head 節點
        if (head.data == target) {
            head = head.next;
            size--;
            return true;
        }

        IntNode previous = head;
        IntNode current = head.next;
        while (current != null) {
            if (current.data == target) {
                previous.next = current.next;
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false; // 找不到資料，size 不變
    }

    // 5. 輸出完整串列
    public void print() {
        if (head == null) {
            System.out.println("null (空串列)");
            return;
        }
        IntNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // 6. 統計：總和 (Sum) - 處理空串列
    public int getSum() {
        if (head == null)
            return 0;
        int sum = 0;
        IntNode current = head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }

    // 7. 統計：最大值 (Max) - 空串列回傳 null 明確結果
    public Integer getMax() {
        if (head == null)
            return null;
        int max = head.data;
        IntNode current = head.next;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        return max;
    }

    // 8. 統計：最小值 (Min) - 空串列回傳 null 明確結果
    public Integer getMin() {
        if (head == null)
            return null;
        int min = head.data;
        IntNode current = head.next;
        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }
        return min;
    }

    // --- 主程式：至少測試 8 次操作與空串列統計 ---
    public static void main(String[] args) {
        NumberHistoryList list = new NumberHistoryList();

        System.out.println("=== 測試 1：初始空串列統計 ===");
        printStats(list);

        // 操作 1：尾端新增 20
        list.addLast(20);
        // 操作 2：前端新增 10
        list.addFirst(10);
        // 操作 3：尾端新增 40
        list.addLast(40);
        // 操作 4：尾端新增 30
        list.addLast(30);

        System.out.println("\n=== 測試 2：新增完成後輸出與統計 (已執行 4 次操作) ===");
        list.print();
        printStats(list);

        // 操作 5：搜尋存在的值 30
        System.out.println("\n[操作 5] 包含 30：" + list.contains(30));
        // 操作 6：搜尋不存在的值 99
        System.out.println("[操作 6] 包含 99：" + list.contains(99));

        // 操作 7：刪除中間節點 20
        list.removeValue(20);
        System.out.println("\n[操作 7] 刪除 20 後：");
        list.print();

        // 操作 8：刪除頭節點 10
        list.removeValue(10);
        System.out.println("[操作 8] 刪除 10 後：");
        list.print();
        printStats(list);
    }

    private static void printStats(NumberHistoryList list) {
        System.out.println("size：" + list.size() +
                " | 總和：" + list.getSum() +
                " | 最大值：" + list.getMax() +
                " | 最小值：" + list.getMin());
    }
}