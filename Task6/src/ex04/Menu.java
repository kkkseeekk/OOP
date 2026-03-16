package ex04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/** * Макрокоманда (шаблон Command); 
 * Колекція об'єктів класу ConsoleCommand 
 */
public class Menu implements Command {
    
    /** Колекція консольних команд */
    private List<ConsoleCommand> menu = new ArrayList<ConsoleCommand>();

    /** * Додає нову команду до меню 
     * @param command об'єкт, що реалізує ConsoleCommand
     * @return додана команда
     */
    public ConsoleCommand add(ConsoleCommand command) {
        menu.add(command);
        return command;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Введіть команду...\n");
        for (ConsoleCommand c : menu) {
            s.append(c).append(", ");
        }
        s.append("'q'uit: ");
        return s.toString();
    }

    @Override
    public void execute() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        menuLoop: while (true) {
            do {
                System.out.print(this);
                try {
                    s = in.readLine();
                } catch (IOException e) {
                    System.err.println("Помилка: " + e);
                    System.exit(0);
                }
            } while (s == null || s.length() != 1);

            char key = s.charAt(0);
            if (key == 'q') {
                System.out.println("Завершення роботи.");
                break menuLoop;
            }

            for (ConsoleCommand c : menu) {
                if (key == c.getKey()) {
                    c.execute();
                    continue menuLoop;
                }
            }
            System.out.println("Невірна команда.");
        }
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }
}