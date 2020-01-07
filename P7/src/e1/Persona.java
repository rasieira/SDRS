package e1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="person")
public class Persona
{
	private String nombre;
	private String tfno;
	
	public Persona() {}
	
	public Persona(String nombre, String tfno)
	{
		this.nombre = nombre;
		this.tfno = tfno;
	}

	@XmlElement(name="name")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement(name="tphn")
	public String getTfno() {
		return tfno;
	}

	public void setTfno(String tfno) {
		this.tfno = tfno;
	}
}
