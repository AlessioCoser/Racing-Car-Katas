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
        HtmlTextConverter converter = new FullHtmlTextConverter("full");

        assertEquals("first line<br />second &quot;line&quot;<br />", converter.convertToHtml());
    }

    @Test
    public void new_returns_converted_html_from_a_file_with_some_text() throws IOException {
        TextReader reader = new FullTextReader();
        HtmlTextConverter converter = new HtmlTextConverter(reader);

        assertEquals("first line<br />second &quot;line&quot;<br />", converter.convertToHtml());
    }

    private class FullHtmlTextConverter extends HtmlTextConverter {
        public FullHtmlTextConverter(String path) {
            super(path);
        }

        @Override
        protected List<String> readLines() throws IOException {
            ArrayList<String> lines = new ArrayList<>();
            lines.add("first line");
            lines.add("second 'line'");
            return lines;
        }
    }

    private class EmptyTextReader extends TextReader {
        public EmptyTextReader() {
            super("");
        }

        @Override
        public List<String> readLines() throws IOException {
            return new ArrayList<String>();
        }
    }

    private class FullTextReader extends TextReader {
        public FullTextReader() {
            super("");
        }

        @Override
        public List<String> readLines() throws IOException {
            ArrayList<String> lines = new ArrayList<>();
            lines.add("first line");
            lines.add("second 'line'");
            return lines;
        }
    }
}
