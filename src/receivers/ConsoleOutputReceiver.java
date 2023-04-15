package receivers;

import events.ConsoleOutput;

import java.io.IOException;

public class ConsoleOutputReceiver implements ConsoleOutput {
    public LogWriter logWriter;

    public ConsoleOutputReceiver(LogWriter logWriter){
        this.logWriter = logWriter;
    }
    @Override
    public void Handler() throws IOException {
        var response = "Обращение к потоку вывода на консоль";
        System.out.printf(response);
        logWriter.LogString(response);
    }
}
