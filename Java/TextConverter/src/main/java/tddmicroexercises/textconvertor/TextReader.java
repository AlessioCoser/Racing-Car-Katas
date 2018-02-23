package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextReader {
    private String fullFilenameWithPath;

    public TextReader(String fullFilenameWithPath) {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }


    public String read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fullFilenameWithPath));
        String text = "";

        String line = reader.readLine();
        while (line != null) {
            text += line;
            line = reader.readLine();
        }
        return text;
    }

    public String getFilename() {
        return fullFilenameWithPath;
    }
}
