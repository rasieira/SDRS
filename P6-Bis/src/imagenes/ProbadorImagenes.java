package imagenes;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import imagenes.gen.GestorImagenesConMTOMyMIME;
import imagenes.gen.GestorImagenesConMTOMyMIMEService;
import imagenes.gen.IOException_Exception;

public class ProbadorImagenes
{
	public static void main(String[] args) throws IOException_Exception, IOException
	{
		GestorImagenesConMTOMyMIMEService service = new GestorImagenesConMTOMyMIMEService();
		GestorImagenesConMTOMyMIME port = service.getGestorImagenesConMTOMyMIMEPort();
		
		Image img = port.descargaImagen("HozYMartillo.png");
		File f = new File("temp.jpg");
		
		ImageIO.write((RenderedImage)img, "jpg", f);
		Desktop.getDesktop().open(f);
		
		Image image2 = ImageIO.read(new File("untitled.png"));
		port.subeImagen(image2, "nueva.jpg");
	}
} 