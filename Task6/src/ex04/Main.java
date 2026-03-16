package ex04;

/** * Обчислення та відображення результатів; 
 * містить реалізацію статичного методу main() 
 */
public class Main {
    /** * Виконується при запуску програми 
     * @param args параметри запуску
     */
    public static void main(String[] args) {
        Application app = Application.getInstance();
        app.run();
    }
}