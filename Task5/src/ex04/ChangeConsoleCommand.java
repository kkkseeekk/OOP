package ex04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import ex02.View;

/** * Консольна команда зміни даних; 
 * реалізує шаблон Command 
 */
public class ChangeConsoleCommand implements ConsoleCommand {
    /** Об'єкт для відображення результатів */
    private View view;
    /** Команда для зміни елемента та підтримки скасування */
    private ChangeItemCommand command;

    /** * Конструктор команди 
     * @param view об'єкт, що реалізує інтерфейс View
     */
    public ChangeConsoleCommand(View view) {
        this.view = view;
    }

    /** * Повертає посилання на об'єкт ChangeItemCommand 
     * @return об'єкт команди зміни
     */
    public ChangeItemCommand getCommand() {
        return command;
    }

    @Override
    public char getKey() {
        return 'c';
    }

    @Override
    public String toString() {
        return "'c'hange";
    }

    @Override
    public void execute() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введіть індекс елемента для зміни: ");
        try {
            String s = in.readLine();
            int idx = Integer.parseInt(s);

            System.out.print("Введіть новий множник для результату: ");
            s = in.readLine();
            double offset = Double.parseDouble(s);

            // Створюємо та налаштовуємо об'єкт команди
            command = new ChangeItemCommand();
            command.setItem(view.getItems().get(idx));
            command.setOffset(offset);

            // Виконуємо зміну
            command.execute();
            view.viewShow();

            // Пропонуємо скасувати останню дію (Undo)
            System.out.print("Бажаєте скасувати зміну? (y/n): ");
            s = in.readLine();
            if (s.equalsIgnoreCase("y")) {
                command.undo();
                System.out.println("Дію скасовано.");
                view.viewShow();
            }

        } catch (IOException | NumberFormatException | IndexOutOfBoundsException e) {
            System.err.println("Помилка введення даних: " + e.getMessage());
        }
    }
}