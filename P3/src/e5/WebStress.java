package e5;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WebStress
{

	public static void main(String[] args)
	{
		if(args.length != 3) throw new IllegalArgumentException("Argumentos invalidos, solo 3");
		if(Integer.parseInt(args[1])<=0) throw new IllegalArgumentException("N debe ser positivo no nulo");
		if(Integer.parseInt(args[2])<=0) throw new IllegalArgumentException("N debe ser positivo no nulo");
		
		int puerto = Integer.parseInt(args[0]);
		int num_hilos = Integer.parseInt(args[1]);
		int num_peticiones = Integer.parseInt(args[2]);
		
		forma1(puerto,num_hilos,num_peticiones);
		forma2(puerto,num_hilos,num_peticiones);
	}
	
	public static void forma1(int puerto, int hilos, int peticiones)
	{
		ExecutorService pool = Executors.newFixedThreadPool(hilos);
		Collection<Probador1> probadores = new Vector<>();
		for(int i = 0;i<hilos;i++)
		{
			probadores.add(new Probador1(peticiones,puerto));
		}
		
		List<Future<long[]>> futures = null;
		try
		{
			futures = pool.invokeAll(probadores);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		pool.shutdown();
		
		LinkedList<long[]> tiempos = new LinkedList<>();
		for(Future<long[]> F: futures)
		{
			try
			{
				tiempos.add(F.get());
			}
			catch (InterruptedException | ExecutionException e)
			{
				e.printStackTrace();
			}
		}
		for(long[] L : tiempos)
		{
			for(long l : L)
			{
				System.out.println(l);
			}
			System.out.println("");
		}
	}
	
	public static void forma2(int puerto, int hilos, int peticiones)
	{
		CyclicBarrier starter = new CyclicBarrier(hilos);
		CountDownLatch ender = new CountDownLatch(hilos);
		
		ExecutorService pool = Executors.newFixedThreadPool(hilos);
		Vector<Future<long[]>> futures = new Vector<>();
		
		for(int i = 0;i<hilos;i++)
		{
			futures.add(pool.submit(new Probador2(peticiones,puerto,starter,ender)));
		}
		
		try {
			ender.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Vector<long[]> tiempos = new Vector<>();
		for(Future<long[]> F: futures)
		{
			try {
				tiempos.add(F.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(long[] L : tiempos)
		{
			for(long l : L)
			{
				System.out.println(l);
			}
			System.out.println("");
		}
	}

}
