package ex04;

import ex02.View;
import ex03.ViewableTable;

/** * Формує та відображає меню; 
 * реалізує шаблон Singleton 
 */
public class Application {
    /** Посилання на єдиний екземпляр класу; шаблон Singleton */
    private static Application instance = new Application();

    /** Закритий конструктор; шаблон Singleton */
    private Application() {}

    /** * Повертає посилання на екземпляр класу Application 
     * @return єдиний об'єкт Application
     */
    public static Application getInstance() {
        return instance;
    }

    /** Об'єкт для роботи з відображенням даних */
    private View view = new ViewableTable().getView();

    /** Об'єкт меню (Макрокоманда) */
    private Menu menu = new Menu();

    /** * Запуск обробки команд користувача 
     */
    public void run() {
    menu.add(new ViewConsoleCommand(view));
    menu.add(new GenerateConsoleCommand(view));
    menu.add(new SaveConsoleCommand(view));
    menu.add(new RestoreConsoleCommand(view));
    menu.add(new ChangeConsoleCommand(view));
    menu.execute();
    }
}