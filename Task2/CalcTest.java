package test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.io.IOException;
import Calc; // Імпортуємо твій основний клас

/**
 * Виконує тестування розроблених класів (стиль JUnit).
 * @author Oksana Kozlova
 * @version 1.0
 */
public class CalcTest {

    /** Перевірка основної функціональності алгоритму Варіанта 8 */
    @Test
    public void testCalc() {
        Calc calc = new Calc();
        
        // Тестуємо число 445: очікуємо дві '4' та одну '5'
        calc.calculate(445);
        int[] result = calc.getResult().counts;
        
        assertEquals("Кількість четвірок має бути 2", 2, result[4]);
        assertEquals("Кількість п'ятірок має бути 1", 1, result[5]);
    }

    /** Перевірка серіалізації: збереження та відновлення даних */
    @Test
    public void testRestore() {
        Calc calc = new Calc();
        calc.calculate(445);
        
        try {
            calc.save();
        } catch (IOException e) {
            fail("Помилка при збереженні: " + e.getMessage());
        }

        calc.calculate(111); // Змінюємо дані в пам'яті
        
        try {
            calc.restore();
        } catch (Exception e) {
            fail("Помилка при відновленні: " + e.getMessage());
        }

        // Перевіряємо, чи повернулися початкові дані
        assertEquals(445, calc.getResult().number);
    }
}
