package tddmicroexercises.textconvertor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class HtmlTextConverter
{
    private TextReader textReader;

    public HtmlTextConverter(String fullFilenameWithPath)
    {
        this(new TextReader(fullFilenameWithPath));
    }

    public HtmlTextConverter(TextReader reader) {
        this.textReader = reader;
    }

    public String convertToHtml() throws IOException{
        List<String> lines = readLines();

		String html = "";
		for (String line : lines) {
			html += StringEscapeUtils.escapeHtml(line);
			html += "<br />";
		}

	    return html;
    }

    protected List<String> readLines() throws IOException {
        String text = textReader.read();

        if(text.equals("")) return new ArrayList<String>();

        return asList(text.split("\\n"));
    }

    public String getFilename() {
		return textReader.getFilename();
	}
}
