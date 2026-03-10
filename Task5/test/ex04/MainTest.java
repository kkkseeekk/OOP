package test.ex04;

import static org.junit.Assert.*;
import org.junit.Test;
import ex01.Item2d;
import ex04.ChangeItemCommand;

/** Тестування функціональності команд та Undo */
public class MainTest {

    @Test
    public void testExecute() {
        ChangeItemCommand cmd = new ChangeItemCommand();
        cmd.setItem(new Item2d());
        
        // Встановлюємо початкове значення результату через setY
        double initialY = 50.0;
        double offset = 2.0;
        
        cmd.getItem().setY(initialY);
        cmd.setOffset(offset);
        
        cmd.execute(); // Має стати 50 * 2 = 100
        
        assertEquals(100, (int)cmd.getItem().getY());
    }

    @Test
    public void testUndo() {
        ChangeItemCommand cmd = new ChangeItemCommand();
        cmd.setItem(new Item2d());
        
        double initialY = 20.0;
        double offset = 5.0;
        
        cmd.getItem().setY(initialY);
        cmd.setOffset(offset);
        
        cmd.execute(); // 20 * 5 = 100
        assertEquals(100, (int)cmd.getItem().getY());
        
        cmd.undo(); // Повертаємо до 20
        assertEquals(20, (int)cmd.getItem().getY());
    }
}