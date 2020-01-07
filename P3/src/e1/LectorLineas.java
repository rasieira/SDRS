package e1;

import java.io.*;
import java.util.*;

public class LectorLineas implements Runnable
{
	private File file;
	private long result = 0;
	private Exception e;
	
	public void run()
	{
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
			this.e = e;
		}
	}
	
	public long getResult() throws Exception
	{
		if(e != null) throw e;
		return result;
	}
	
	public LectorLineas(File F)
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
		
		Thread[] threads = new Thread[k];
		LectorLineas[] lectores = new LectorLineas[k];
		
		for(int i = 0; i < k; i++)
		{
			lectores[i] = new LectorLineas(files.get(i));
			threads[i] = new Thread(lectores[i]);
			threads[i].start();
		}
		
		for(Thread T: threads)
		{
			T.join();
		}
		
		long R = 0;
		for(LectorLineas L: lectores)
		{
			R = R + L.getResult();
		}
		System.out.println(R);
	}
}