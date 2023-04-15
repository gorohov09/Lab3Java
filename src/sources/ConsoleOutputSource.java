package sources;

import events.ConsoleOutput;

import java.io.IOException;

public class ConsoleOutputSource {
    ConsoleOutput consoleOutput;

    public  ConsoleOutputSource(ConsoleOutput consoleOutput){
        this.consoleOutput = consoleOutput;
    }

    public void generateEvent() throws IOException {
        consoleOutput.Handler();
    }
}
