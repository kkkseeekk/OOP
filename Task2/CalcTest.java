import java.io.IOException;

/**
 * Клас для тестування коректності обчислень та серіалізації.
 * @author Oksana Kozlova
 */
public class CalcTest {
    /**
     * Основний метод для запуску тестів.
     */
    public static void main(String[] args) {
        Calc calc = new Calc();
        
        System.out.println("Тестування 8 індивідуаьного завдання");
        
        // 1. Тест обчислень
        // Число 445 має містити: дві '4' і одну '5'
        calc.calculate(445);
        int[] result = calc.getResult().counts;
        
        if (result[4] == 2 && result[5] == 1) {
            System.out.println("Тест обчислень: УСПІШНО (Знайдено дві 4 та одну 5)");
        } else {
            System.out.println("Тест обчислень: ПОМИЛКА");
        }
        
        // 2. Тест серіалізації та десеріалізації
        try {
            System.out.println("Тестування збереження та відновлення...");
            calc.save(); // Зберігаємо результат для 445 у data.bin
            
            calc.calculate(111); // Змінюємо дані в пам'яті на інше число
            
            calc.restore(); // Відновлюємо дані з файлу
            
            if (calc.getResult().number == 445) {
                System.out.println("Тест серіалізації: УСПІШНО (Дані 445 відновлено)");
            } else {
                System.out.println("Тест серіалізації: ПОМИЛКА");
            }
            
        } catch (IOException e) {
            System.out.println("Помилка введення-виведення: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Виникла помилка: " + e.getMessage());
        }
        
        System.out.println("Тестування завершено");
    }
}
