package handlers.question;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.LogRecord;

public class QuestionFileHandler extends FileHandler {
    public QuestionFileHandler() throws IOException, SecurityException {
        super();
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return getFilter().isLoggable(record);
    }
}
