package events;

import java.io.IOException;

//Интерфейс события - вывод данных с консоли
public interface ConsoleOutput {
    void Handler() throws IOException;
}
