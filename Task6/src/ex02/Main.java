package ex02;

import ex01.Calc;
import java.io.IOException;

/** Клас для демонстрації роботи з колекцією */
public class Main {
    /** Об'єкт для відображення результатів */
    private View view;

    /** Конструктор, що приймає готовий об'єкт представлення */
    public Main(View view) {
        this.view = view;
    }

    /** Геттер, який дозволяє дочірнім класам (наприклад, у ex03) 
     * отримати доступ до об'єкта представлення.
     */
    public View getView() {
        return view;
    }

    /** Основна логіка демонстрації */
    public void run() {
        System.out.println("Тестування");

        view.viewInit();

        ViewResult vr = (ViewResult)view;
        Calc c = new Calc();
        
        c.init(8821); 
        vr.getItems().add(c.getResult());

        view.viewShow();

        try {
            System.out.println("\nЗбереження колекції у файл...");
            view.viewSave();
        } catch (IOException e) {
            System.err.println("Помилка збереження: " + e.getMessage());
        }

        // Очищуємо та відновлюємо для перевірки
        System.out.println("\nОчищення та відновлення даних...");
        vr.getItems().clear();
        
        try {
            view.viewRestore();
            view.viewShow(); 
        } catch (Exception e) {
            System.err.println("Помилка відновлення: " + e.getMessage());
        }
    }

    /** Діалогове меню для взаємодії з користувачем.
     * Тут воно порожнє, але ми його перевизначимо (Override) у пакеті ex03.
     */
    public void menu() {
        // У базовому класі можна просто викликати run() або залишити порожнім
        run();
    }

    public static void main(String[] args) {
        // Створюємо Main, передаючи йому результат роботи фабрики
        Main main = new Main(new ViewableResult().getView());
        main.menu();
    }
}