package e4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Parser
{
	public static void main(String[] args) throws JAXBException
	{
		Equipo e1 = new Equipo("Clapton CFC",1);
		Equipo e2 = new Equipo("Naxara CF",3);
		e1.addJugador("J1");
		e2.addJugador("J2");
		e1.setEnDescenso(false);
		e2.setEnDescenso(true);
		List<Equipo> equipos = new ArrayList<>();
		equipos.add(e1);
		equipos.add(e2);
		
		ligaFutbol L = new ligaFutbol();
		L.setEquipos(equipos);
		L.setTemporada("2018-2019");
		
		saveToXML(L, "src/e4/xml/ligaFutbol.xml");
	}
	
	public static void saveToXML(ligaFutbol L, String destFile) throws JAXBException
	{
		JAXBContext context = JAXBContext.newInstance(ligaFutbol.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(L, new File(destFile));
	}
	
	public static ligaFutbol parseFromXML(String sourceFile) throws JAXBException, FileNotFoundException
	{
		JAXBContext context = JAXBContext.newInstance(ligaFutbol.class);
		Unmarshaller um = context.createUnmarshaller();
		FileReader file = new FileReader(sourceFile);
		ligaFutbol L = (ligaFutbol) um.unmarshal(file);
		return null;
	}
}
