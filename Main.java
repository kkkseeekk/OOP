public class Main {

    public static void main(String[] args) {

        System.out.println("Перевірка аргументів командного рядка");
        System.out.println();

        int count = args.length;

        System.out.println("Було передано: " + count + " аргумент(ів)");
        System.out.println();

        if (count > 0) {

            for (int i = 0; i < count; i++) {
                System.out.println("Аргумент №" + (i + 1) + " -> " + args[i]);
            }

        } else {
            System.out.println("Аргументи не були передані при запуску програми");
        }

        System.out.println();
        System.out.println("Роботу програми завершено");
    }
}
