package ex02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import ex01.Item2d; // Імпортуємо клас з першої практичної

/** * Клас для відображення та зберігання колекції результатів 
 * реалізує інтерфейс View 
 */
public class ViewResult implements View {
    
    /** Ім'я файлу для серіалізації */
    private static final String FILE_NAME = "items.bin";
    
    /** Колекція (список) для зберігання результатів обчислень */
    private ArrayList<Item2d> items = new ArrayList<>();

    /** Конструктор за замовчуванням */
    public ViewResult() { }

    /** * Реалізація методу getItems() для доступу до даних 
     * @return список елементів Item2d
     */
    @Override
    public List<Item2d> getItems() {
        return items;
    }

    @Override
    public void viewHeader() {
        System.out.println("Результати обчислень (Варіант 8)");
    }

    @Override
    public void viewBody() {
        for (Item2d item : items) {
            System.out.printf("Число: %d | Результат: %s\n", 
                item.getNumber(), item.getResultString());
        }
    }

    @Override
    public void viewFooter() {
        System.out.println("Кінець списку.");
    }

    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }

    @Override
    public void viewInit() {
        // Тут логіка заповнення списку (наприклад, для твого числа 8821)
        // Ми залишимо це для виклику з ПР3 або ПР4
    }

    @Override
    public void viewSave() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
        os.writeObject(items); // Зберігаємо весь список одразу
        os.flush();
        os.close();
        System.out.println("Дані успішно збережені у " + FILE_NAME);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void viewRestore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FILE_NAME));
        items = (ArrayList<Item2d>) is.readObject(); // Відновлюємо весь список
        is.close();
        System.out.println("Дані успішно відновлені.");
    }

    @Override
    public List<Item2d> getItems1() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getItems1'");
    }
}