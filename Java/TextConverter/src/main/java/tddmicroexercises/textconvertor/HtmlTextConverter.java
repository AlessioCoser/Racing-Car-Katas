package tddmicroexercises.textconvertor;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class HtmlTextConverter
{
    private TextReader textReader;

    public HtmlTextConverter(String fullFilenameWithPath) {
        this(new FileTextReader(fullFilenameWithPath));
    }

    public HtmlTextConverter(TextReader textReader) {
        this.textReader = textReader;
    }

    public String convertToHtml() throws IOException{
        String text = textReader.read();

        if (text.equals("")) return "";

        return linesFrom(text).stream()
                .map(StringEscapeUtils::escapeHtml)
                .collect(Collectors.joining("<br />")) + "<br />";
    }

    private List<String> linesFrom(String text) {
        return asList(text.split("\\n"));
    }

    public String getFilename() {
		return textReader.getName();
	}
}
