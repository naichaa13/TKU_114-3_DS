public class TemperatureLevel {
    public static void main(String[] args) {
        double temperature = 25.0;

        if (temperature < 15) {
            System.out.println("小於 15： Cold");
        } else if (temperature > 15 && temperature < 28) {
            System.out.println("15 到未滿 28：: Comfortable");

        } else {
            System.out.println("28 以上: Hot");
        }
    }
}
