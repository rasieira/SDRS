package e1;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.sun.net.httpserver.HttpServer;

public class LanzadorAgenda
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		URI baseUri = UriBuilder.fromUri("http://localhost/").port(8080).build();
		ResourceConfig config = new ResourceConfig(AgendaTfno_RS1.class);
		
		HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
		
		System.out.println("Pulsa enter para detener el server");
		
		try
		{
			new DataInputStream(System.in).readLine();
		}catch(IOException e) {}
		System.out.println("Deteniendo");
		
		server.stop(0);
	}
}
