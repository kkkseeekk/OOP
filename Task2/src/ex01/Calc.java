package ex01;
import java.io.*;

/**
 * Клас для обчислень та роботи з файлами.
 * Використовує агрегування об'єкта Item2d.
 * @author Козлова Оксана
 */
public class Calc {
    /** Ім'я файлу для серіалізації */
    private static final String FNAME = "Item2d.bin";

    /** Агрегування: Calc містить об'єкт Item2d */
    private Item2d result;

    public Calc() {
        result = new Item2d();
    }

    public void setResult(Item2d result) { this.result = result; }
    public Item2d getResult() { return result; }

    /**
     * Підраховує кількість кожної цифри у десятковому поданні числа.
     * @param n Число для аналізу
     * @return Об'єкт з результатами
     */
    public Item2d init(long n) {
        int[] tempCounts = new int[10];
        long tempN = Math.abs(n);
        
        if (tempN == 0) {
            tempCounts[0] = 1;
        } else {
            while (tempN > 0) {
                tempCounts[(int)(tempN % 10)]++;
                tempN /= 10;
            }
        }
        
        result = new Item2d(n, tempCounts);
        return result;
    }

    /** Збереження стану об'єкта у файл */
    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(result);
        os.close();
    }

    /** Відновлення стану об'єкта з файлу */
    public void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        result = (Item2d) is.readObject();
        is.close();
    }

    /** Виведення результатів */
    public void show() {
        System.out.println("Число: " + result.getNumber());
        System.out.print("Розподіл цифр: ");
        for (int i = 0; i < 10; i++) {
            if (result.getCounts()[i] > 0) {
                System.out.print("[" + i + "]=" + result.getCounts()[i] + " ");
            }
        }
        System.out.println("\nПоле transient (info): " + result.getInfo());
    }
}