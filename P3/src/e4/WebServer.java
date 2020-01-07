package e4;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebServer
{
	public static void main(String[] args)
	{
		if(args.length != 1) throw new IllegalArgumentException("Argumentos invalidos, solo 1 archivo");
		File F = new File(args[0]);
		
		ExecutorService pool = Executors.newCachedThreadPool();
		
		ServerSocket SS;
		try
		{
			SS = new ServerSocket(6666);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return;
		}
		
		while(true)
		{
			try
			{
				pool.submit(new AtenderPeticion(SS.accept(),F));
			}
			catch(IOException e)
			{
				e.printStackTrace();
				break;
			}
		}
		pool.shutdown();
		try
		{
			SS.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
