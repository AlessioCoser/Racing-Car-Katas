package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileTextReader implements TextReader {
    private String fullFilenameWithPath;

    public FileTextReader(String fullFilenameWithPath) {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }

    @Override
    public String read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fullFilenameWithPath));
        StringBuilder text = new StringBuilder();

        String line = reader.readLine();
        while (line != null) {
            text.append(line);
            line = reader.readLine();
        }

        return text.toString();
    }

    @Override
    public String getName() {
        return fullFilenameWithPath;
    }
}
