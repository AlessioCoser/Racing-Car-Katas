package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class HtmlTextConverterTest {

    @Mock FileTextReader textReader;

    @Test
    public void returns_filename() {
        HtmlTextConverter converter = new HtmlTextConverter("foo");

        assertEquals("foo", converter.getFilename());
    }

    @Test
    public void returns_empty_string_from_an_empty_reader() throws IOException {
        when(textReader.read()).thenReturn("");

        HtmlTextConverter converter = new HtmlTextConverter(textReader);

        assertEquals("", converter.convertToHtml());
    }

    @Test
    public void returns_converted_html_from_a_reader_with_some_text() throws IOException {
        when(textReader.read()).thenReturn("first line\nsecond 'line'");

        HtmlTextConverter converter = new HtmlTextConverter(textReader);

        assertEquals("first line<br />second &quot;line&quot;<br />", converter.convertToHtml());
    }
}
