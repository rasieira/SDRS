package biblioteca;

import java.util.Map;

import javax.xml.ws.BindingProvider;

import biblioteca.gen.AlmacenLibrosService;
import biblioteca.gen.Library;
import biblioteca.gen.Libro;



public class ProbadorBiblioteca
{
	public static void main(String[] args)
	{	
		AlmacenLibrosService service = new AlmacenLibrosService();
		Library port = service.getLibraryPort();
		
		 Map<String, Object> reqCtx = ((BindingProvider) port).getRequestContext();
		 reqCtx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,"http://localhost:8080/Library"); 
		
		 Libro L = new Libro();
		 L.setAutor("Karl Marx");
		 L.setTitulo("Das Kapital Vol 1");
		 L.setIsbn("45852854585248-9");
		 
		 port.addLibro(L);
		 
		
		System.out.println(port.getLibro("45852854585248-9").getAutor());
	}
}