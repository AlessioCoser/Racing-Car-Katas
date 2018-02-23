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
    
	    BufferedReader reader = new BufferedReader(new FileReader(fullFilenameWithPath));
        List<String> lines = new ArrayList<String>();

        String line = reader.readLine();
        while (line != null) {
			lines.add(line);
			line = reader.readLine();
		}

		String html = "";
		for (String l : lines) {
			html += StringEscapeUtils.escapeHtml(l);
			html += "<br />";
		}

	    return html;
    }

	public String getFilename() {
		return this.fullFilenameWithPath;
	}
}
