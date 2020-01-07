package e3;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class PizzaParser
{
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException
	{
		anadirPizza("src/e2/Restaurante.xml");
	}
	
	public static Pizza[] getPizzasFromXML(String sourceFile) throws SAXException, IOException, ParserConfigurationException
	{
		Pizza[] result = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document D = db.parse(new File(sourceFile));
		
		Element carta = D.getDocumentElement();
		NodeList pizzas = carta.getChildNodes();
		Vector<Pizza> dynamic_result = new Vector<>();
		for(int i=0;i<pizzas.getLength();i++)
		{
			if(pizzas.item(i).getNodeType() == Node.ELEMENT_NODE)
			{
				Element element_pizza = (Element) pizzas.item(i);
				String name = element_pizza.getAttribute("nombre");
				float price = Float.parseFloat(element_pizza.getAttribute("precio"));
				Pizza pizza = new Pizza(name,price);
				NodeList pizza_ingredients = element_pizza.getElementsByTagName("ingrediente");
				for(int j=0;j<pizza_ingredients.getLength();j++)
				{
					if(pizza_ingredients.item(j).getNodeType() == Node.ELEMENT_NODE)
					{
						pizza.addIngrediente(pizza_ingredients.item(j).getFirstChild().getTextContent());
					}
				}
				Boolean onSale = element_pizza.getElementsByTagName("oferta").getLength()>0;
				pizza.setOferta(onSale);
				dynamic_result.add(pizza);
			}
		}
		result = new Pizza[dynamic_result.size()];
		dynamic_result.toArray(result);
		return result;
	}
	
	public static void anadirPizza(String sourceFile) throws ParserConfigurationException, SAXException, IOException, TransformerException
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document D = db.parse(new File(sourceFile));
		
		Element carta = D.getDocumentElement();
		Element pizza = D.createElement("pizza");
		
		Attr name = D.createAttribute("nombre");
		name.setValue("Carbonara");
		
		Attr price = D.createAttribute("precio");
		price.setValue("9");
		
		Element i1 = D.createElement("ingrediente");
		i1.setTextContent("Pues no se que lleva una carbonara");
		
		Element o = D.createElement("oferta");
		
		pizza.appendChild(i1);
		pizza.appendChild(o);
		pizza.setAttributeNode(price);
		pizza.setAttributeNode(name);
		
		carta.appendChild(pizza);
		
		TransformerFactory F = TransformerFactory.newInstance();
		Transformer T = F.newTransformer();
		DOMSource S = new DOMSource(D);
		StreamResult R = new StreamResult(new File(sourceFile));
		T.transform(S, R);
	}
}
