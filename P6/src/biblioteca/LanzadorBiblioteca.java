package biblioteca;

import javax.xml.ws.Endpoint;



public class LanzadorBiblioteca
{
	public static void main(String[] args)
	{
		AlmacenLibros almacen = new AlmacenLibros();
		Endpoint.publish("http://localhost:8080/Library", almacen);
	}
}
