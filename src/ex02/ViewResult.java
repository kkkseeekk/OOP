package ex02;

import java.io.*;
import java.util.ArrayList;
import ex01.Item2d; // Імпортуємо клас з другої практичної

/** Клас для відображення та зберігання колекції результатів */
public class ViewResult implements View {
    
    /** Ім'я файлу для серіалізації */
    private static final String FILE_NAME = "items.bin";
    
    /** Колекція (список) для зберігання результатів обчислень */
    private ArrayList<Item2d> items = new ArrayList<>();

    /** Конструктор за замовчуванням */
    public ViewResult() { }

    /** Повертає список елементів */
    public ArrayList<Item2d> getItems() {
        return items;
    }

    @Override
    public void viewHeader() {
        System.out.println("Результати обчислень");
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
        System.out.println("Кінець списку");
    }

    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }

    @Override
    public void viewInit() {
        // Тут ми будемо додавати логіку заповнення списку
    }

    @Override
    public void viewSave() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
        os.writeObject(items); // Зберігаємо весь список одразу
        os.flush();
        os.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void viewRestore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FILE_NAME));
        items = (ArrayList<Item2d>) is.readObject(); // Відновлюємо весь список
        is.close();
    }
}