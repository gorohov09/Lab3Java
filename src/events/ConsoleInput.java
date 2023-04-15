package events;

import java.io.IOException;

//Интерфейс события - ввод данных с консоли
public interface ConsoleInput {
    void Handler() throws IOException;
}
