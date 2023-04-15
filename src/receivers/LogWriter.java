package receivers;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogWriter {

    private String pathToLog;

    public  LogWriter() {
        pathToLog = "C:\\Users\\andre\\IdeaProjects\\Lab3\\output.txt";
    }

    public  void SetPath(String path){
        pathToLog = path;
    }

    public void LogString(String string_for_logging) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(pathToLog, true))) {
            // Перехват события
            writer.append(string_for_logging + "\n");
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }
    }
}
