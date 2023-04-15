import receivers.AccessArrayReceiver;
import receivers.ConsoleInputReceiver;
import receivers.ConsoleOutputReceiver;
import receivers.LogWriter;
import sources.AccessArraySource;
import sources.ConsoleInputSource;
import sources.ConsoleOutputSource;

import java.io.*;
import java.util.Scanner;

public class Processor {

    String[] array;

    int sumEven;
    int sumOdd;

    LogWriter logWriter;

    private final AccessArraySource accessArraySource;
    private final ConsoleInputSource consoleInputSource;
    private final ConsoleOutputSource consoleOutputSource;

    public Processor() {

        logWriter = new LogWriter();

        AccessArrayReceiver accessArrayReceiver = new AccessArrayReceiver(logWriter);
        ConsoleInputReceiver consoleInputReceiver = new ConsoleInputReceiver(logWriter);
        ConsoleOutputReceiver consoleOutputReceiver = new ConsoleOutputReceiver(logWriter);

        accessArraySource = new AccessArraySource(accessArrayReceiver);
        consoleInputSource = new ConsoleInputSource(consoleInputReceiver);
        consoleOutputSource = new ConsoleOutputSource(consoleOutputReceiver);
    }

    private void calculate(String[] input) throws IOException {
        sumEven = 0;
        sumOdd = 0;

        accessArraySource.generateEvent();
        for (String x : input)
        {
            int number = Integer.parseInt(x);
            if (number < 0)
            {
                if (number % 2 == 1){
                    sumOdd += number;
                }
                else {
                    sumEven += number;
                }
            }
        }
    }

    public void setInputFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] input = reader.readLine().split(" ");
        String outputFilePath = reader.readLine();
        reader.close();

        logWriter.SetPath(outputFilePath);

        calculate(input);
    }

    public void setInputFromConsole() throws IOException {
        Scanner scanner = new Scanner(System.in);
        consoleInputSource.generateEvent();
        System.out.print("Введите последовательность чисел, разделённых пробелами: ");
        String[] input = scanner.nextLine().split(" ");
        calculate(input);
    }


    public void printResult() throws IOException {
        System.out.println("Сумма чётных чисел в последовательности: " + sumEven + "\n");
        System.out.println("Сумма нечётных чисел в последовательности: " + sumOdd + "\n");
        consoleOutputSource.generateEvent();

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            // Пропускаем 1-ю строку
            br.readLine();
            // Читаем 2-ю строку
            String filePath = br.readLine();

            try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
                // Перехват события
                writer.append("Сумма чётных чисел в последовательности: " + sumEven + "\n");
                writer.append("Сумма нечётных чисел в последовательности: " + sumOdd + "\n");
            } catch (FileNotFoundException e) {
                throw new RuntimeException();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
