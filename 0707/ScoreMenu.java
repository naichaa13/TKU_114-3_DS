import java.util.Scanner;

public class ScoreMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入姓名：");
        String name = sc.nextLine();

        System.out.print("請輸入 Java 成績：");
        double java = sc.nextDouble();
        System.out.print("請輸入 English 成績：");
        double english = sc.nextDouble();
        System.out.print("請輸入 Math 成績：");
        double math = sc.nextDouble();

        double average = (java + english + math) / 3.0;

        int choice = -1;
        while (choice != 0) {
            System.out.println("\n--- 選單 ---");
            System.out.println("1：顯示平均分數");
            System.out.println("2：顯示及格狀態");
            System.out.println("3：顯示等第");
            System.out.println("0：離開");
            System.out.print("請選擇功能：");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("姓名：" + name + "，平均分數：" + average);
                    break;
                case 2:
                    String status = (average >= 60) ? "及格" : "不及格";
                    System.out.println("及格狀態：" + status);
                    break;
                case 3:
                    char grade;
                    if (average >= 90)
                        grade = 'A';
                    else if (average >= 80)
                        grade = 'B';
                    else if (average >= 70)
                        grade = 'C';
                    else if (average >= 60)
                        grade = 'D';
                    else
                        grade = 'F';
                    System.out.println("等第為：" + grade);
                    break;
                case 0:
                    System.out.println("程式結束");
                    break;
                default:
                    System.out.println("選項錯誤，請重新輸入。");
            }
        }

        sc.close();
    }
}