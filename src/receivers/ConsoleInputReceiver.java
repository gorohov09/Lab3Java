package receivers;

import events.ConsoleInput;

import java.io.IOException;

public class ConsoleInputReceiver implements ConsoleInput {
    public LogWriter logWriter;

    public ConsoleInputReceiver(LogWriter logWriter){
        this.logWriter = logWriter;
    }
    @Override
    public void Handler() throws IOException {
        var response = "Обращение к потоку ввода на консоль";
        System.out.printf(response);
        logWriter.LogString(response);
    }
}
