package ex03;

import ex01.Item2d;
import ex02.ViewResult;

/** Вивід результатів у вигляді таблиці */
public class ViewTable extends ViewResult {
    private static final int DEFAULT_WIDTH = 70;
    private int width;

    public ViewTable() {
        width = DEFAULT_WIDTH;
    }

    public ViewTable(int width) {
        this.width = width;
    }

    /** Ініціалізація даних для Варіанта 8 (8821) */
    @Override
    public void viewInit() {
        int[] counts = new int[10];
        counts[8] = 2; 
        counts[2] = 1; 
        counts[1] = 1;

        // Передаємо long число (з L) та масив
        getItems().add(new Item2d(8821L, counts));
    }

    /** Виводить лінію-розділювач */
    private void outLine() {
        for (int i = width; i > 0; i--) {
            System.out.print('-');
        }
        System.out.println();
    }

    /** Перевизначення виводу заголовка таблиці */
    @Override
    public void viewHeader() {
        outLine();
        System.out.printf("| %-15s | %-45s |\n", "Число", "Результат");
        outLine();
    }

    /** Перевизначення виводу тіла таблиці */
    @Override
    public void viewBody() {
        for (Item2d item : getItems()) {
            System.out.printf("| %-15d | %-45s |\n", 
                item.getNumber(), item.getResultString());
        }
    }

    /** Перевизначення виводу футера таблиці */
    @Override
    public void viewFooter() {
        outLine();
    }

    /** Повертає поточну ширину таблиці */
    public int getWidth() {
        return width;
    }
}