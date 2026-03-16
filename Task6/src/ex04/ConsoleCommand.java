package ex04;

/** * Інтерфейс консольної команди; 
 * шаблон Command 
 */
public interface ConsoleCommand extends Command {
    /** * Повертає символ гарячої клавіші команди 
     * @return символ клавіші
     */
    public char getKey();
}