public class PriceMaxMin {
    public static void main(String[] args) {
        int price1 = 30;
        int price2 = 95;
        int price3 = 60;

        int max = price1;
        int min = price1;

        if (price2 > max) {
            max = price2;
        }
        if (price2 < min) {
            min = price2;
        }

        if (price3 > max) {
            max = price3;
        }
        if (price3 < min) {
            min = price3;
        }

        System.out.println("Highest price: " + max);
        System.out.println("Lowest price: " + min);
    }
}