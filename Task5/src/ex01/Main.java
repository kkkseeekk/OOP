package ex01;
import java.util.Scanner;

/**
 * Головний клас для запуску програми.
 */
public class Main {
    public static void main(String[] args) {
        Calc calc = new Calc();
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть ціле число: ");
        if (sc.hasNextLong()) {
            long n = sc.nextLong();
            calc.init(n);
            calc.show();

            try {
                System.out.println("Збереження об'єкта..."); //Демонстрація діалогового режиму роботи.
                calc.save();
                
                System.out.println("Очищення об'єкта в пам'яті...");
                calc.setResult(new Item2d());
                
                System.out.println("Відновлення об'єкта з файлу...");
                calc.restore();
                calc.show();
            } catch (Exception e) {
                System.out.println("Помилка серіалізації: " + e.getMessage());
            }
        }
        sc.close();
    }
}