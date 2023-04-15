package receivers;

import events.AccessArray;

import java.io.IOException;

public class AccessArrayReceiver implements AccessArray {
    public LogWriter logWriter;

    public AccessArrayReceiver(LogWriter logWriter){
        this.logWriter = logWriter;
    }
    @Override
    public void Handler() throws IOException {
        var response = "Обращение к указанному массиву";
        System.out.printf(response);
        logWriter.LogString(response);
    }
}
