public class TaskLinkedList {
    private TaskNode head;
    private int size;

    public TaskLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    // 計算未完成數量
    public int getIncompleteCount() {
        int count = 0;
        TaskNode current = head;
        while (current != null) {
            if (!current.isCompleted()) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

    // 1. 緊急工作加到前端 (addFirst)
    public boolean addTaskFirst(String code, String description) {
        if (code == null || code.trim().isEmpty() || findByCode(code) != null) {
            return false; // 代碼為空或重複，拒絕新增
        }

        TaskNode newNode = new TaskNode(code, description);
        newNode.next = head;
        head = newNode;
        size++;
        return true;
    }

    // 2. 一般工作加到尾端 (addLast)
    public boolean addTaskLast(String code, String description) {
        if (code == null || code.trim().isEmpty() || findByCode(code) != null) {
            return false; // 代碼為空或重複，拒絕新增
        }

        TaskNode newNode = new TaskNode(code, description);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    // 3. 支援完成工作 (依代碼標記為已完成)
    public boolean completeTask(String code) {
        TaskNode task = findByCode(code);
        if (task != null) {
            task.setCompleted(true);
            return true;
        }
        return false;
    }

    // 4. 支援刪除工作 (支援刪除 head、中間與最後一首)
    public boolean removeTask(String code) {
        if (head == null || code == null) {
            return false;
        }

        // 若要刪除的是 head 節點
        if (head.getCode().equalsIgnoreCase(code.trim())) {
            head = head.next;
            size--;
            return true;
        }

        TaskNode previous = head;
        TaskNode current = head.next;

        while (current != null) {
            if (current.getCode().equalsIgnoreCase(code.trim())) {
                previous.next = current.next;
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }

        return false; // 找不到對應代碼
    }

    // 5. 列出未完成工作
    public void printIncompleteTasks() {
        TaskNode current = head;
        boolean found = false;
        int index = 1;
        while (current != null) {
            if (!current.isCompleted()) {
                System.out.println(index + ". " + current);
                found = true;
            }
            current = current.next;
            index++;
        }
        if (!found) {
            System.out.println("目前沒有未完成的工作！");
        }
    }

    public void printAllTasks() {
        if (head == null) {
            System.out.println("工作清單目前是空的。");
            return;
        }

        TaskNode current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current);
            current = current.next;
            index++;
        }
    }

    public TaskNode findByCode(String code) {
        if (code == null)
            return null;
        TaskNode current = head;
        while (current != null) {
            if (current.getCode().equalsIgnoreCase(code.trim())) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}