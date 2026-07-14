import java.util.Scanner;

public class SalesMatrix {

    public static void main(String[] args) {
        int[][] sales = new int[3][4];
        Scanner sc = new Scanner(System.in);

        inputSales(sc, sales);

        System.out.println("--- 銷售量矩陣 ---");
        printSales(sales);

        System.out.println("--- 商品銷售總量 ---");
        int[] productTotals = calculateProductTotals(sales);
        for (int i = 0; i < productTotals.length; i++) {
            System.out.println("商品 " + (i + 1) + "： " + productTotals[i]);
        }

        System.out.println("--- 每日銷售總量 ---");
        int[] dayTotals = calculateDayTotals(sales);
        for (int i = 0; i < dayTotals.length; i++) {
            System.out.println("第 " + (i + 1) + " 天： " + dayTotals[i]);
        }

        int bestProductIndex = findBestProduct(productTotals);
        System.out.println("銷售量最高的商品為：商品 " + (bestProductIndex + 1));

        sc.close();
    }

    public static void inputSales(Scanner sc, int[][] sales) {
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                do {
                    System.out.print("請輸入商品 " + (i + 1) + " 第 " + (j + 1) + " 天的銷售量：");
                    sales[i][j] = sc.nextInt();
                } while (sales[i][j] < 0);
            }
        }
    }

    public static void printSales(int[][] sales) {
        for (int[] row : sales) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }

    public static int[] calculateProductTotals(int[][] sales) {
        int[] totals = new int[sales.length];
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                totals[i] += sales[i][j];
            }
        }
        return totals;
    }

    public static int[] calculateDayTotals(int[][] sales) {
        int[] totals = new int[sales[0].length];
        for (int j = 0; j < sales[0].length; j++) {
            for (int i = 0; i < sales.length; i++) {
                totals[j] += sales[i][j];
            }
        }
        return totals;
    }

    public static int findBestProduct(int[] productTotals) {
        int bestIndex = 0;
        for (int i = 1; i < productTotals.length; i++) {
            if (productTotals[i] > productTotals[bestIndex]) {
                bestIndex = i;
            }
        }
        return bestIndex;
    }
}