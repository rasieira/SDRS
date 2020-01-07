package e2;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Principal
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		ServerSocket SS = null;
		
		try
		{
			SS = new ServerSocket(8080);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return;
		}
		
		ExecutorService pool = Executors.newCachedThreadPool();
		
		while(true)
		{
			try
			{
				pool.submit(new Handler(SS.accept()));
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
