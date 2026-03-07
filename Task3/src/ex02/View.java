package ex02;

import java.io.IOException;

/** Інтерфейс для відображення та керування результатами */
public interface View {
    /** Відображає заголовок */
    public void viewHeader();
    /** Відображає основну частину */
    public void viewBody();
    /** Відображає підвал (завершення) */
    public void viewFooter();
    /** Відображає всі дані */
    public void viewShow();
    /** Ініціалізує дані */
    public void viewInit();
    /** Зберігає дані у файл 
     * @throws IOException */
    public void viewSave() throws IOException;
    /** Відновлює дані з файлу 
     * @throws Exception */
    public void viewRestore() throws Exception;
}