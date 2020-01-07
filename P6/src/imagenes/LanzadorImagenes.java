package imagenes;

import javax.xml.ws.Endpoint;

public class LanzadorImagenes
{
	public static void main(String[] args)
	{
		GestorImagenesConMTOMyMIME G = new GestorImagenesConMTOMyMIME();
		Endpoint.publish("http://localhost:8080/Imagenes", G);
	}
}
