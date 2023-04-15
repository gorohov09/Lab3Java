import java.io.IOException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        Processor obj = new Processor();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Выберите вариант ввода (1 - консоль, 2 - файл): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            obj.setInputFromConsole();
        } else if (choice == 2) {
            obj.setInputFromFile();
        } else {
            System.out.println("Ошибка: неверный выбор варианта ввода");
            return;
        }
        obj.printResult();
    }
}
