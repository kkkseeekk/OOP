package ex02;

import ex01.Calc;
import java.io.IOException;

/** Клас для демонстрації роботи з колекцією */
public class Main {
    /** Об'єкт для відображення результатів */
    private View view;

    /** Конструктор, що приймає фабрику */
    public Main(Viewable viewable) {
        view = viewable.getView();
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

    public static void main(String[] args) {
        // Запускаємо через фабрику ViewableResult
        Main main = new Main(new ViewableResult());
        main.run();
    }
}