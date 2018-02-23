package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileTextReader {
    private String fullFilenameWithPath;

    public FileTextReader(String fullFilenameWithPath) {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }


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

    public String getFilename() {
        return fullFilenameWithPath;
    }
}
