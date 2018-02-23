package tddmicroexercises.textconvertor;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
        BufferedReader reader = new BufferedReader(new FileReader(fullFilenameWithPath));
        List<String> lines = new ArrayList<String>();

        String line = reader.readLine();
        while (line != null) {
			lines.add(line);
			line = reader.readLine();
		}
        return lines;
    }

    public String getFilename() {
		return fullFilenameWithPath;
	}
}
