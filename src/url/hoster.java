package url;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class hoster {

	private ArrayList<forsale> allads;
	
public hoster(ArrayList<forsale> allads)
{
	
	this.allads = allads;	
	
}
	
//unused sharing over network
@SuppressWarnings("deprecation")
public void hostfile() throws TransformerException, ParserConfigurationException, IOException
{
	
	
	
	String path =(System.getProperty("user.dir") + "\\laptops.xml");
	
	String content;
	content = new String ( Files.readAllBytes(Paths.get(path)));
	
	//content = content.replaceAll("<", "&lt");
	//content = content.replaceAll(">", "&gt");
	 
	 
	 content = "<html>\n" + "<head>\n" + "<title>laptops!!!</title>\n" + "</head>\n" + "<body>\n"+	
	 		content + "</body>\n" + "</html>\n";
	 System.out.println(content);

	 FileUtils.writeStringToFile(new File("C:\\Users\\root\\Desktop\\hosttest.html"), content);
	 
	 
}
	
	
}
