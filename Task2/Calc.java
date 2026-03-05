import java.io.*;

/**
 * Клас для виконання обчислень та серіалізації.
 */
public class Calc {
    // Пункт 1: Агрегування (об'єкт Item2d всередині Calc)
    // Пункт 2: transient (це поле не серіалізується автоматично)
    private transient Item2d result = new Item2d();

    public void setResult(Item2d result) { this.result = result; }
    public Item2d getResult() { return result; }

    /**
     * Алгоритм 8-го варіанту: підрахунок кількості кожної цифри у числі.
     */
    public void calculate(long n) {
        int[] tempCounts = new int[10];
        long tempN = Math.abs(n); // Беремо число по модулю
        
        if (tempN == 0) tempCounts[0] = 1;
        
        while (tempN > 0) {
            int digit = (int)(tempN % 10); // Отримуємо останню цифру
            tempCounts[digit]++;           // Додаємо одиницю до лічильника цієї цифри
            tempN /= 10;                   // Прибираємо останню цифру
        }
        // Створюємо новий об'єкт з результатами
        result = new Item2d(n, tempCounts);
    }

    /**
     * Збереження результату у файл (Серіалізація).
     */
    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("data.bin"));
        os.writeObject(result);
        os.close();
    }

    /**
     * Відновлення результату з файлу (Десеріалізація).
     */
    public void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("data.bin"));
        result = (Item2d) is.readObject();
        is.close();
    }
}
