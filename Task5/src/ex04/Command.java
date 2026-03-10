package ex04;

/** * Інтерфейс команди або завдання; 
 * шаблони: Command, Worker Thread 
 */
public interface Command {
    /** * Виконання команди 
     */
    public void execute();
}