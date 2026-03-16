package ex03;

import ex02.View;
import java.util.Scanner;

/** Обчислення та відображення результатів.
 * Містить реалізацію статичного методу main()
 */
public class Main extends ex02.Main {

    public Main(View view) {
        super(view);
    }

    /** Головний метод запуску програми */
    public static void main(String[] args) {
        // Використовуємо Factory Method для створення табличного відображення
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }

    /** Діалогове меню для взаємодії з користувачем */
    @SuppressWarnings("resource")
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        String s;
        do {
            System.out.println("\nОберіть команду:");
            System.out.println("'q' - Вихід");
            System.out.println("'v' - Перегляд таблиці");
            System.out.println("'g' - Генерація даних");
            System.out.println("'s' - Зберегти");
            System.out.println("'r' - Відновити");
            System.out.print("Введіть команду: ");
            s = scanner.nextLine();

            switch (s) {
                case "q":
                    System.out.println("Завершення роботи");
                    break;
                case "v":
                    System.out.println("Поточна таблиця:");
                    getView().viewShow();
                    break;
                case "g":
                    System.out.println("Генерація нових даних...");
                    getView().viewInit();
                    getView().viewShow();
                    break;
                case "s":
                    try {
                        getView().viewSave();
                        System.out.println("Дані успішно збереженно.");
                    } catch (Exception e) {
                        System.out.println("Помилка збереження: " + e.getMessage());
                    }
                    break;
                case "r":
                    try {
                        getView().viewRestore();
                        System.out.println("Дані успішно відновленні.");
                        getView().viewShow();
                    } catch (Exception e) {
                        System.out.println("Помилка відновлення: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Невідома команда.");
            }
        } while (!s.equals("q"));
    }
}