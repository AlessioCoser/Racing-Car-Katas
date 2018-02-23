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
        HtmlTextConverter converter = new EmptyHtmlTextConverter("empty");

        assertEquals("", converter.convertToHtml());
    }

    @Test
    public void returns_converted_html_from_a_file_with_some_text() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter("full");

        assertEquals("first line<br />second &quot;line&quot;<br />", converter.convertToHtml());
    }

    private class EmptyHtmlTextConverter extends HtmlTextConverter {
        public EmptyHtmlTextConverter(String path) {
            super(path);
        }

        @Override
        protected List<String> readLines() throws IOException {
            return new ArrayList<String>();
        }
    }
}
