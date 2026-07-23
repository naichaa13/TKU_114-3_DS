import java.util.ArrayDeque;
import java.util.Deque;

public class ClinicQueueSystem {
    private Deque<Patient> queue = new ArrayDeque<>();
    private int totalServed = 0;

    public boolean isExists(String number) {
        for (Patient p : queue) {
            if (p.getNumber().equalsIgnoreCase(number))
                return true;
        }
        return false;
    }

    public void register(String number, String name, String department) {
        if (isExists(number)) {
            System.out.println("掛號失敗：號碼 " + number + " 已存在！");
            return;
        }
        queue.offer(new Patient(number, name, department));
        System.out.println("掛號成功：" + number + " " + name);
    }

    public void callNext() {
        Patient p = queue.poll();
        if (p == null) {
            System.out.println("目前無人等待。");
        } else {
            totalServed++;
            System.out.println("叫號：" + p);
        }
    }

    public void peekNext() {
        Patient p = queue.peek();
        System.out.println("下一位：" + (p != null ? p : "無"));
    }

    public void showStats() {
        int internal = 0, surgery = 0, pediatrics = 0;
        for (Patient p : queue) {
            if (p.getDepartment().equals("內科"))
                internal++;
            else if (p.getDepartment().equals("外科"))
                surgery++;
            else if (p.getDepartment().equals("小兒科"))
                pediatrics++;
        }
        System.out.println("\n--- 統計報表 ---");
        System.out.println("總服務人數：" + totalServed);
        System.out
                .println("等待人數：" + queue.size() + " (內科:" + internal + ", 外科:" + surgery + ", 小兒科:" + pediatrics + ")");
    }

    public static void main(String[] args) {
        ClinicQueueSystem clinic = new ClinicQueueSystem();
        clinic.register("01", "Amy", "內科");
        clinic.register("02", "Ben", "小兒科");
        clinic.register("03", "Cara", "外科");

        clinic.peekNext();
        clinic.callNext();
        clinic.callNext();

        clinic.showStats();
    }
}