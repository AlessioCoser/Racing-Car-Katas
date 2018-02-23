package tddmicroexercises.textconvertor;

import java.io.IOException;

public interface TextReader {
    String read() throws IOException;

    String getName();
}
