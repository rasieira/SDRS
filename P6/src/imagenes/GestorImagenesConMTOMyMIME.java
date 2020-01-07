package imagenes;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.*;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

@WebService
public class GestorImagenesConMTOMyMIME {

	final static String PATH = "imagenes/";
	
	@MTOM
	@WebMethod
	public @XmlMimeType("image/jpeg")Image descargaImagen(String nombre) throws IOException
	{
		File fich = new File(PATH+nombre);
		Image image = ImageIO.read(fich);
		return image;
	}
	
	@WebMethod
	public String subeImagen(@WebParam(name="datos") @XmlMimeType("image/jpeg") Image datos,
							 @WebParam(name="nombre") String nombre) throws IOException
	{
		if(datos != null)
		{
		File image = new File(PATH+nombre);
		ImageIO.write((RenderedImage) datos, "jpg", image);
		return "Subida exitosa";
		}
		throw new WebServiceException("No me mandas datos");
	}

}
