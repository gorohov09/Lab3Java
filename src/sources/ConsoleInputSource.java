package sources;

import events.ConsoleInput;

import java.io.IOException;

public class ConsoleInputSource {
    ConsoleInput consoleInput;

    public ConsoleInputSource(ConsoleInput consoleInput) {
        this.consoleInput = consoleInput;
    }

    public void generateEvent() throws IOException {
        consoleInput.Handler();
    }
}
