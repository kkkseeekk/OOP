package ex01;

import java.io.Serializable;

/**
 * Клас для зберігання параметрів і результатів обчислень.
 * Реалізує інтерфейс Serializable.
 */
public class Item2d implements Serializable {
    /** Необхідно для ідентифікації версії серіалізації */
    private static final long serialVersionUID = 1L;

    /** Вхідне число для аналізу */
    private int number;
    
    /** Масив для збереження результатів (для Варіанта 8 використовуємо counts[0]) */
    private int[] counts = new int[10];

    /** Тимчасове поле, яке не серіалізується */
    private transient String info = "Дані не будуть збережені";

    /** Конструктор за замовчуванням */
    public Item2d() {
        number = 0;
    }

    /** Конструктор з параметрами (старий) */
    public Item2d(long number, int[] counts) {
        this.number = (int) number;
        this.counts = counts;
    }

    /** * НОВИЙ КОНСТРУКТОР: дозволяє створювати об'єкт через x та y.
     * Необхідний для коректної роботи ViewResult та тестів.
     */
    public Item2d(double x, double y) {
        this.number = (int) x;
        this.counts = new int[10];
        this.counts[0] = (int) y; // Записуємо результат у масив
    }

    // Геттери та сеттери
    public long getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }
    public int[] getCounts() { return counts; }
    public void setCounts(int[] counts) { this.counts = counts; }
    public String getInfo() { return info; }

    /** Повертає вхідне число як double */
    public double getX() {
        return (double) number;
    }

    /** Повертає результат (суму цифр) як double */
    public double getY() {
        int sum = 0;
        if (counts != null) {
            for (int count : counts) {
                sum += count;
            }
        }
        return (double) sum;
    }

    /** Встановлює значення X та Y (для сумісності) */
    public void setXY(double x, double y) {
        this.number = (int) x;
        if (counts != null && counts.length > 0) {
            counts[0] = (int) y;
        }
    }

    /** Формуємо рядок з результатами */
    public String getResultString() {
        StringBuilder sb = new StringBuilder();
        if (counts != null) {
            for (int i = 0; i < 10; i++) {
                if (counts[i] > 0) {
                    sb.append(String.format("Число %d: %d шт. ", i, counts[i]));
                }
            }
        }
        return sb.length() > 0 ? sb.toString() : "Результати відсутні";
    }

    public void setNumber(String valueOf) {
        try {
            this.number = Integer.parseInt(valueOf);
        } catch (NumberFormatException e) {
            this.number = 0;
        }
    }

    public void setY(double newResult) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setY'");
    }
}