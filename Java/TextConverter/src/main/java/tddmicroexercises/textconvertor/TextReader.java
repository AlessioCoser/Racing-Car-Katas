package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextReader {
    public List<String> readLine(String fullFilenameWithPath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fullFilenameWithPath));
        List<String> lines = new ArrayList<String>();

        String line = reader.readLine();
        while (line != null) {
			lines.add(line);
			line = reader.readLine();
		}
        return lines;
    }
}
