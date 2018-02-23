package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlTextConverterTest {
    @Test
    public void returns_filename() {
        HtmlTextConverter converter = new HtmlTextConverter("foo");

        assertEquals("foo", converter.getFilename());
    }

    @Test
    public void returns_empty_string_from_an_empty_file() throws IOException {
        TextReader reader = new EmptyTextReader();
        HtmlTextConverter converter = new HtmlTextConverter(reader);

        assertEquals("", converter.convertToHtml());
    }

    @Test
    public void returns_converted_html_from_a_file_with_some_text() throws IOException {
        TextReader reader = new FullTextReader();
        HtmlTextConverter converter = new HtmlTextConverter(reader);

        assertEquals("first line<br />second &quot;line&quot;<br />", converter.convertToHtml());
    }

    private class EmptyTextReader extends TextReader {
        public EmptyTextReader() {
            super("");
        }

        @Override
        public String read() throws IOException {
            return "";
        }
    }

    private class FullTextReader extends TextReader {
        public FullTextReader() {
            super("");
        }

        @Override
        public String read() throws IOException {
            return "first line\nsecond 'line'";
        }
    }
}
