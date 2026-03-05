import java.util.Scanner;

/**
 * Головний клас для демонстрації роботи програми.
 */
public class Main {
    public static void main(String[] args) {
        Calc calc = new Calc();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Вітаю! Введіть ціле число: ");
        long input = scanner.nextLong();
        
        // Виконуємо розрахунок за варіантом 8
        calc.calculate(input);
        
        try {
            // Зберігаємо стан об'єкта
            calc.save();
            System.out.println("Стан об'єкта збережено у файл data.bin");

            // Очищуємо дані, щоб перевірити відновлення
            calc.setResult(null); 
            
            // Відновлюємо дані з файлу
            calc.restore();
            System.out.println("Дані успішно відновлено!");
            
            // Виводимо результати
            System.out.println("Кількість кожної цифри у числі " + calc.getResult().number + ":");
            for (int i = 0; i < 10; i++) {
                if (calc.getResult().counts[i] > 0) {
                    System.out.println("Цифра " + i + " зустрічається: " + calc.getResult().counts[i] + " раз(и)");
                }
            }
        } catch (Exception e) {
            System.out.println("Виникла помилка при роботі з файлом.");
        }
    }
}
