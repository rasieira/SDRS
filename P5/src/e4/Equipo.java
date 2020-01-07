package e4;

import java.util.List;

import javax.xml.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;

@XmlRootElement(name = "equipo")
@XmlType(propOrder = {"nombre","division","jugadores","enDescenso"})
public class Equipo implements Serializable
{
	private String nombre;
	private int division;
	private boolean enDescenso;
	private List<String> jugadores;

	public Equipo(String nombre, int division)
	{
		this.nombre = nombre;
		this.division = division;
		this.jugadores = new ArrayList<String>();
	}

	public Equipo()
	{
	}

	@XmlElement(name = "nombre")
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	@XmlElement(name = "division")
	public int getDivision()
	{
		return division;
	}
	public void setDivision(int division)
	{
		this.division = division;
	}

	@XmlElement(name = "enDescenso")
	public boolean isEnDescenso()
	{
		return enDescenso;
	}
	public void setEnDescenso(boolean enDescenso)
	{
		this.enDescenso = enDescenso;
	}

	public void addJugador(String jugador)
	{
		jugadores.add(jugador);
	}

	@XmlElementWrapper(name = "jugadores")
	@XmlElement(name = "jugador")
	public List<String> getJugadores()
	{
		return jugadores;
	}
	public void setJugadores(List<String> jugadores)
	{
		this.jugadores = jugadores;
	}

	public String toString()
	{
		return "Equipo " + nombre + " " + jugadores + " división " + division + "."
				+ (enDescenso ? " En descenso." : "");
	}
}
