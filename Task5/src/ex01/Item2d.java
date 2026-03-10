package ex01;
import java.io.Serializable;

/**
 * Клас для зберігання параметрів і результатів обчислень.
 * Реалізує інтерфейс Serializable.
 * @author Козлова Оксана
 * @version 1.0
 */
public class Item2d implements Serializable {
    /** Необхідно для ідентифікації версії серіалізації */
    private static final long serialVersionUID = 1L;

    /** Вхідне число для аналізу */
    private long number;
    
    /** Масив для збереження кількості кожної цифри (0-9) */
    private int[] counts = new int[10];

    /** Тимчасове поле, яке не серіалізується */
    private transient String info = "Дані не будуть збережені";

    /** Конструктор за замовчуванням */
    public Item2d() {
        number = 0;
    }

    /** Конструктор з параметрами */
    public Item2d(long number, int[] counts) {
        this.number = number;
        this.counts = counts;
    }

    // Геттери та сеттери
    public long getNumber() { return number; }
    public void setNumber(long number) { this.number = number; }
    public int[] getCounts() { return counts; }
    public void setCounts(int[] counts) { this.counts = counts; }
    public String getInfo() { return info; }

    /** Формуємо рядок з результатами підрахунку цифр */
    public String getResultString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (counts[i] > 0) {
                sb.append(String.format("Число %d: %d шт. ", i, counts[i]));
            }
        }
        return sb.length() > 0 ? sb.toString() : "Результати відсутні";
    }

    /** Реалізація методів для сумісності з шаблоном Command */
    
    public void setXY(double x, double y) {
        this.number = (long) x;
        if (counts.length > 0) {
            counts[0] = (int) y;
        }
    }

    /** Повертає суму всіх знайдених цифр як числовий результат */
    public double getY() {
        int sum = 0;
        for (int count : counts) {
            sum += count;
        }
        return (double) sum;
    }

    /** Повертає вхідне число */
    public double getX() {
        return (double) number;
    }

    /** Змінює результат (викликається командою Change) */
    public void setY(double newResult) {
        if (counts.length > 0) {
            // Для Варіанта 8: змінюємо кількість першої знайденої цифри
            counts[0] = (int) newResult;
        }
    }
}