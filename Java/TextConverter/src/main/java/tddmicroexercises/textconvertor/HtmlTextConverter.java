package tddmicroexercises.textconvertor;

import java.io.IOException;
import java.util.List;

public class HtmlTextConverter
{
    private TextReader textReader;

    public HtmlTextConverter(String fullFilenameWithPath)
    {
        textReader = new TextReader(fullFilenameWithPath);
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
        return textReader.readLine();
    }

    public String getFilename() {
		return textReader.getFilename();
	}
}
