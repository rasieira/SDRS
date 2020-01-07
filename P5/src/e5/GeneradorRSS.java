package e5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GeneradorRSS
{

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
	{
		if (args.length != 1)
			throw new IllegalArgumentException("Solo 1 parametro");
		StringBuilder result = null;
		try
		{
			result = new StringBuilder();
			URL url = new URL(args[0]);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null)
			{
				result.append(line);
			}
			rd.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("src/e5/xml.xml"), StandardCharsets.UTF_8))
		{
			out.write(result.toString());
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document D = db.parse(new File("src/e5/xml.xml"));
		
		Element root = D.getDocumentElement();
		NodeList news = root.getElementsByTagName("item");
		Vector<String[]> newsLinkList = new Vector<>();
		for(int i=0;i<news.getLength();i++)
		{
			String[] itemOnStringArray = new String[5];
			itemOnStringArray[0] = ((Element) news.item(i)).getElementsByTagName("title").item(0).getTextContent();
			itemOnStringArray[1] = ((Element) news.item(i)).getElementsByTagName("link").item(0).getTextContent();
			itemOnStringArray[2] = ((Element) news.item(i)).getElementsByTagName("description").item(0).getTextContent();
			itemOnStringArray[3] = ((Element) news.item(i)).getElementsByTagName("pubDate").item(0).getTextContent()+", "+((Element) news.item(i)).getElementsByTagName("dc:creator").item(0).getTextContent();;
			itemOnStringArray[4] = ((Element) news.item(i)).getElementsByTagName("enclosure").item(1).getAttributes().getNamedItem("url").getTextContent();
			newsLinkList.add(itemOnStringArray);
		}
		
		File F = new File("src/e5/html.html");
		F.createNewFile();
		
		try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(F), StandardCharsets.UTF_8))
		{
			out.write("<!DOCTYPE html><html lang=\"es\">\n" + 
					"			<head>\n" + 
					"			<meta charset=\"utf-8\">\n" + 
					"			</head>" +
					"			<body>");
			
			for(String[] S: newsLinkList)
			{
				out.write("<p>\n");
				out.write("<a href="+ S[1] +">"+ S[0] +"</a>"+"\n");
				out.write("<br />\n");
				out.write(S[2]);
				out.write("<br />\n");
				out.write(S[3]);
				out.write("<br />\n");
				out.write("<a href="+ S[4] +">"+ "Ver imagen de noticia" +"</a>"+"\n");
				out.write("</p>\n");
			}
			
			out.write("		    </body>\n" +
					  "</html>");
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

}
