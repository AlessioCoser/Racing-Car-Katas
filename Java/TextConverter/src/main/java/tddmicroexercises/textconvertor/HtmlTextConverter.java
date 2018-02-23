package tddmicroexercises.textconvertor;

import java.io.IOException;
import java.util.List;

public class HtmlTextConverter
{
    private String fullFilenameWithPath;

    public HtmlTextConverter(String fullFilenameWithPath)
    {
        this.fullFilenameWithPath = fullFilenameWithPath;
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
        return new TextReader().readLine(fullFilenameWithPath);
    }

    public String getFilename() {
		return fullFilenameWithPath;
	}
}
