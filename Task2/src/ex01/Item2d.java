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

    /** Тимчасове поле, яке не серіалізується (демонстрація transient) */
    private transient String info = "Ці дані не будуть збережені";

    /** Конструктор за замовчуванням */
    public Item2d() {
        number = 0;
    }

    /** Конструктор з параметрами
     * @param number аналізоване число
     * @param counts масив результатів підрахунку
     */
    public Item2d(long number, int[] counts) {
        this.number = number;
        this.counts = counts;
    }

    // Геттери та сеттери для Javadoc
    public long getNumber() { return number; }
    public void setNumber(long number) { this.number = number; }
    public int[] getCounts() { return counts; }
    public void setCounts(int[] counts) { this.counts = counts; }
    public String getInfo() { return info; }
}