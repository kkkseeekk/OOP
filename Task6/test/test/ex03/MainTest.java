package test.ex03;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import ex01.Item2d;
import ex03.ViewTable;

import java.io.IOException;

@SuppressWarnings("unused")
public class MainTest {

    /** * Тест перевіряє розрахунки та ініціалізацію для 8821.
     * Демонструє перевантаження (Overloading) конструкторів.
     */
    @Test
    public void testCalc() {
        ViewTable tbl = new ViewTable(50);
        
        assertEquals(50, tbl.getWidth());
        
        tbl.viewInit();
        
        assertNotNull(tbl.getItems());
        assertFalse(tbl.getItems().isEmpty());
        
        // Перевіряємо перше число має бути 8821
        // Додаємо L, щоб JUnit порівнював long з long
        assertEquals(8821L, tbl.getItems().get(0).getNumber());
    }

    /** * Тест перевіряє серіалізацію та десеріалізацію об'єктів.
     * Демонструє поліморфізм при відновленні даних.
     */
    @Test
    public void testRestore() {
        ViewTable tbl1 = new ViewTable();
        ViewTable tbl2 = new ViewTable();
        
        tbl1.viewInit(); 
        
        try {
            tbl1.viewSave(); 
            tbl2.viewRestore();
            
            assertEquals(tbl1.getItems().size(), tbl2.getItems().size());
            
            Item2d item1 = tbl1.getItems().get(0);
            Item2d item2 = tbl2.getItems().get(0);
            
            assertEquals(item1.getNumber(), item2.getNumber());
            assertEquals(item1.getResultString(), item2.getResultString());
            
        } catch (IOException | ClassNotFoundException e) {
            fail("Помилка серіалізації: " + e.getMessage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}