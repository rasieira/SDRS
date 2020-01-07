package e2;

import java.io.*;
import java.util.Collection;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LectorLineas2 implements Callable<Long>
{
	private File file;
	
	public LectorLineas2(File F)
	{
		file = F;
	}
	
	public static void main(String[] args) throws Exception
	{
		if(args.length != 1) throw new IllegalArgumentException("Solo 1 argumento admitido");
		
		File dir = new File(args[0]);
		if(!dir.isDirectory()) throw new IllegalArgumentException("Debe ser un directorio");
		if(dir.listFiles().length == 0)
		{
			System.out.println("0");
			return;
		}
		
		int k = 0;
		
		Vector<File> files = new Vector<>();
		
		for(File F: dir.listFiles())
		{
			if(F.isFile()) files.add(F);
		}
		
		k = files.size();
		
		ExecutorService pool = Executors.newFixedThreadPool(k);
		Collection<Callable<Long>> tareas = new Vector<Callable<Long>>();
		
		for(File F: files)
		{
			tareas.add(new LectorLineas2(F));
		}
		
		Collection<Future<Long>> resultados = pool.invokeAll(tareas);
		pool.shutdown();
		
		long result = 0;
		for(Future<Long> F: resultados)
		{
			result = result + F.get().longValue();
		}
		
		System.out.println(result);
	}

	public Long call() throws IOException
	{
		Long L;
		long result = 0;
		try(BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file))))
		{
			String linea = in.readLine();
			while(linea != null)
			{
				result++;
				linea = in.readLine();
			}
		}
		catch(IOException e)
		{
			throw e;
		}
		
		L = new Long(result);
		return L;
	}
}