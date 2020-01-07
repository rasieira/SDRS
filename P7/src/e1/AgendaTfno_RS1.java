package e1;

import java.net.URI;
import java.util.Hashtable;
import java.util.Map;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

@Path("/TelephoneList")
public class AgendaTfno_RS1
{
	@Context
	private UriInfo uriInfo;
	
	protected static Map<String,Persona> agenda = new Hashtable<>();
	
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/names")
	public Document getNombres() throws ParserConfigurationException
	{
		DocumentBuilderFactory F = DocumentBuilderFactory.newInstance();
		DocumentBuilder B = F.newDocumentBuilder();
		Document D = B.newDocument();
		
		Element root = D.createElement("names");
		for(String n: agenda.keySet())
		{
			Element nombre = D.createElement("name");
			nombre.setTextContent(n);
			root.appendChild(nombre);
		}
		D.appendChild(root);
		return D;
	}
	
	
	@POST
	@Consumes(MediaType.TEXT_XML)
	public String aniadeTfno(Persona p)
	{
		agenda.put(p.getNombre(), p);
		URI nuevaPersonaUri = uriInfo.getBaseUriBuilder()
				.port(8080)
				.path("TelephoneList")
				.path("persons")
				.path(p.getNombre())
				.build();
		return nuevaPersonaUri.toString();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String aniadeTfno(@FormParam("name") String nombre,
						   @FormParam("tphn") String tfno)
	{
		this.aniadeTfno(new Persona(nombre,tfno));
		
		URI nuevaPersonaUri = uriInfo.getBaseUriBuilder()
				.port(8080)
				.path("TelephoneList")
				.path("persons")
				.path(nombre)
				.build();
		return nuevaPersonaUri.toString();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/telephones/{name}")
	public String getTfno(@PathParam("name") String nombre)
	{
		Persona p = agenda.get(nombre);
		if(p != null) return p.getTfno();
		else throw new WebApplicationException(Status.NOT_FOUND); 
	}
	
	@GET
	@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	@Path("/persons/{name}")
	public Persona getPersona(@PathParam("name") String nombre)
	{
		Persona p = agenda.get(nombre);
		if(p != null) return p;
		else throw new WebApplicationException(Status.NOT_FOUND);
	}
	
	@DELETE
	@Path("/persons/{name}")
	public void borraPersona(@PathParam("name") String nombre)
	{
		System.out.println("Borran" + nombre);
		agenda.remove(nombre);
	}
}
