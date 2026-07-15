
/**
修正紀錄：
  1. 錯誤位置: System.out.println("系統結束，年齡：" + age)
     錯誤類型: 編譯錯誤 (Syntax Error)
     原因: 結尾缺少分號 (;)
     修正方式: 補上分號。
  2. 錯誤位置: i <= scores.length
     錯誤類型: 執行錯誤 (Runtime Error - ArrayIndexOutOfBoundsException)
     原因: 索引範圍超過陣列長度 (最後一次迴圈 i 為 3)
     修正方式: 改為 i < scores.length。
  
  3. 錯誤位置: command == "exit"
     錯誤類型: 邏輯錯誤 (Logic Error)
     原因: Java 中字串比較內容應使用 equals()，== 會比較物件參考
     修正方式: 改為 "exit".equals(command)。
  
  4. 錯誤位置: total / scores.length
     錯誤類型: 邏輯錯誤 (Logic Error)
     原因: 整數除法會丟棄小數點
     修正方式: 強制轉型為 (double) total / scores.length。
  
  5. 錯誤位置: int age = sc.nextInt(); 之後
     錯誤類型: 邏輯錯誤 (Logic Error)
     原因: nextInt() 留下了換行字元，導致 nextLine() 讀取到空字串
     修正方式: 在兩者之間加入 sc.nextLine() 讀走換行。
  
  6. 截圖/文字記錄: 陣列越界發生時
  當 i = 3 時，存取 scores[3] 會導致程式崩潰，
  此時 scores.length 為 3，i 卻達到了 3，顯然超出了 0~2 的合法索引範圍。
 */

import java.util.Scanner;

public class DebuggingChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = { 80, 75, 92 };
        int total = 0;

        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }

        double average = (double) total / scores.length;
        System.out.printf("平均：%.2f%n", average);

        System.out.print("請輸入年齡：");
        int age = sc.nextInt();

        sc.nextLine();

        System.out.print("請輸入指令：");
        String command = sc.nextLine();

        if ("exit".equals(command)) {
            System.out.println("系統結束，年齡：" + age);
        }

        sc.close();
    }
}