package test.ex02;

import static org.junit.Assert.*;
import org.junit.Test;
import ex01.Calc;
import ex02.ViewResult;
import ex02.ViewableResult;

/** Клас для тестування колекції та серіалізації */
@SuppressWarnings("unused")
public class MainTest {

    /** Тест перевірки збереження та відновлення списку об'єктів */
    @Test
    public void testRestore() {
        ViewResult view1 = new ViewResult();
        ViewResult view2 = new ViewResult();
        Calc calc = new Calc();

        calc.init(8821);
        view1.getItems().add(calc.getResult());
        
        // Додаємо ще одне число для перевірки роботи саме зі списком
        calc.init(1234);
        view1.getItems().add(calc.getResult());

        try {
            view1.viewSave();

            view2.viewRestore();
        } catch (Exception e) {
            fail("Виникла помилка під час роботи з файлом: " + e.getMessage());
        }

        assertEquals("Кількість елементів у списку змінилася", 
                     view1.getItems().size(), view2.getItems().size());

        assertEquals("Дані відновленого об'єкта не збігаються з оригіналом", 
                     view1.getItems().get(0).getResultString(), 
                     view2.getItems().get(0).getResultString());
    }
}