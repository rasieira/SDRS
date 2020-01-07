package e5;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import e4.WebClient;

public class Probador2 implements Callable<long[]>
{
	private int peticiones, puerto;
	private CyclicBarrier startLine;
	private CountDownLatch endLine;

	public Probador2(int peticiones, int puerto, CyclicBarrier startLine, CountDownLatch endLine)
	{
		this.puerto = puerto;
		this.peticiones = peticiones;
		this.startLine = startLine;
		this.endLine = endLine;
	}

	public long[] call() throws Exception
	{
		WebClient C = new WebClient("localhost", puerto);
		long[] tiempos = new long[peticiones];

		startLine.await();
		for (int i = 0; i < peticiones; i++)
		{
			long start = System.currentTimeMillis();
			C.descargarSinGuardar();
			long end = System.currentTimeMillis();
			tiempos[i] = end - start;
		}
		endLine.countDown();
		return tiempos;
	}
}
