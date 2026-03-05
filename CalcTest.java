/**
 * Клас для тестування коректності обчислень та серіалізації.
 * @author Oksana Kozlova
 */
public class CalcTest {
    /**
     * Основний метод для запуску тестів.
     */
    public static void main(String[] args) {
        Calc testCalc = new Calc();
        
        System.out.println("Запуск тестування...");
        
        // Тестуємо число 445 (має бути дві '4' і одна '5')
        testCalc.calculate(445);
        int[] result = testCalc.getResult().counts;
        
        if (result[4] == 2 && result[5] == 1) {
            System.out.println("Тест обчислень: УСПІШНО");
        } else {
            System.out.println("Тест обчислень: ПОМИЛКА");
        }
        
        System.out.println("Тестування завершено.");
    }
}
