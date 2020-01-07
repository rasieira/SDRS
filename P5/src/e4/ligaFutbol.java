package e4;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "ligaFutbol")
public class ligaFutbol implements Serializable
{
	private List<Equipo> equipos;
	private String temporada;
	
	@XmlElement(name = "equipo")
	public List<Equipo> getEquipos()
	{
		return equipos;
	}
	public void setEquipos(List<Equipo> equipos)
	{
		this.equipos = equipos;
	}
	
	@XmlAttribute
	public String getTemporada()
	{
		return temporada;
	}
	public void setTemporada(String temporada)
	{
		this.temporada = temporada;
	}
}
