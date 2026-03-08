package test.ex01; 

import static org.junit.Assert.*;
import org.junit.Test;
import ex01.Calc;

/**
 * Клас для тестування коректності обчислень та серіалізації.
 */
public class MainTest {

    /** Перевірка підрахунку цифр (Варіант 8) */
    @Test
    public void testCalc() {
        Calc calc = new Calc();
        // Використаємо число 8821: дві '8', одна '2', одна '1'
        calc.init(8821);
        
        // Перевіряємо кількість цифр
        assertEquals(2, calc.getResult().getCounts()[8]);
        assertEquals(1, calc.getResult().getCounts()[2]); 
        assertEquals(1, calc.getResult().getCounts()[1]); 
        assertEquals(0, calc.getResult().getCounts()[0]);
    }

    /** Перевірка серіалізації з іншим числом */
    @Test
    public void testRestore() throws Exception {
        Calc calc = new Calc();
        // Візьмемо число 1001
        calc.init(1001);
        calc.save();
        calc.setResult(null); // Стираємо об'єкт у пам'яті
        calc.restore(); // Відновлюємо з файлу
        
        // Перевіряємо, чи повернулося число 1001
        assertEquals(1001, calc.getResult().getNumber());
        // Перевірка transient: поле info має бути null після відновлення
        assertNull(calc.getResult().getInfo());
    }
}