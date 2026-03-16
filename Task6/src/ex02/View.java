package ex02;

import java.io.IOException;
import java.util.List;
import ex01.Item2d;

/** * Інтерфейс для відображення та керування результатами; 
 * забезпечує доступ до колекції об'єктів Item2d 
 */
public interface View {
    /** Відображає заголовок */
    public void viewHeader();
    
    /** Відображає основну частину */
    public void viewBody();
    
    /** Відображає підвал (завершення) */
    public void viewFooter();
    
    /** Відображає всі дані */
    public void viewShow();
    
    /** Ініціалізує дані */
    public void viewInit();
    
    /** Зберігає дані у файл 
     * @throws IOException */
    public void viewSave() throws IOException;
    
    /** Відновлює дані з файлу 
     * @throws Exception */
    public void viewRestore() throws Exception;

    /** * Повертає список елементів для обробки командами; 
     * саме цей метод ми викликаємо у ChangeConsoleCommand 
     * @return список об'єктів Item2d
     */
    public List<Item2d> getItems();

    List<Item2d> getItems1();
}