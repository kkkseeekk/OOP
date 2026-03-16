package ex05;

import ex02.View;
import ex02.ViewableResult;
import ex04.*;

/** Головний клас для запуску паралельного виконання */
public class Main {
    public static void main(String[] args) {
        // Отримуємо об'єкт через фабрику з ex02
        View view = new ViewableResult().getView();
        Menu menu = new Menu();
        CommandQueue queue = new CommandQueue();

        // Запуск фонового потоку (Worker Thread)
        Thread worker = new Thread(queue);
        worker.setDaemon(true);
        worker.start();

        // Додаємо команди
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.add(new ExecuteConsoleCommand(view, queue));

        menu.execute();
        queue.shutdown();
    }
}