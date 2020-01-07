package biblioteca;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.jws.*;

@WebService(name = "Library")
public class AlmacenLibros
{
	private ConcurrentMap<String,Libro> libros = new ConcurrentHashMap<>();
	private String nombre;
	
	public void addLibro(@WebParam(name="Book")Libro l)
	{
		libros.put(l.getIsbn(), l);
	}
	
	public Collection<Libro> getLibros()
	{
		return libros.values();
	}
	
	public Libro getLibro(String isbn)
	{
		return libros.get(isbn);
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(@WebParam(name="Name")String nombre)
	{
		this.nombre = nombre;
	}
}
