import java.io.Serializable;

/**
 * Клас для зберігання вхідного числа та результатів обчислень.
 * (1. Розробити клас, що серіалізується, для зберігання параметрів і результатів
обчислень.)
 */
public class Item2d implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // Вхідне число
    public long number;
    // Масив для кількості кожної цифри (від 0 до 9)
    public int[] counts = new int[10];

    // Порожній конструктор
    public Item2d() {}

    // Конструктор з параметрами
    public Item2d(long number, int[] counts) {
        this.number = number;
        this.counts = counts;
    }
}
