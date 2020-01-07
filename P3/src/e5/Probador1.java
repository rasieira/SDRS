package e5;

import java.util.concurrent.Callable;
import e4.WebClient;

public class Probador1 implements Callable<long[]>
{
	private int peticiones, puerto;

	public Probador1(int peticiones, int puerto)
	{
		this.puerto = puerto;
		this.peticiones = peticiones;
	}

	public long[] call() throws Exception
	{
		WebClient C = new WebClient("localhost", puerto);
		long[] tiempos = new long[peticiones];
		for (int i = 0; i < peticiones; i++)
		{
			long start = System.currentTimeMillis();
			C.descargarSinGuardar();
			long end = System.currentTimeMillis();
			tiempos[i] = end - start;
		}
		return tiempos;
	}

}
