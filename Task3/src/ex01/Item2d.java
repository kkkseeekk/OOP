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
    private transient String info = "Дані не будуть збережені";

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

    /** * Формуємо рядок з результатами підрахунку цифр.
     */
    public String getResultString() {
        StringBuilder sb = new StringBuilder();
        
        // Проходимо по масиву результатів (кількість цифр 0-9)
        for (int i = 0; i < 10; i++) {
            if (counts[i] > 0) { // Якщо цифра зустрічалася
                sb.append(String.format("Число %d: %d шт. ", i, counts[i]));
            }
        }
        
        // Повертаємо результат або текст, якщо цифр не знайдено
        return sb.length() > 0 ? sb.toString() : "Результати відсутні";
    }
}