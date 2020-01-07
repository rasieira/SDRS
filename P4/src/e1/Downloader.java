package e1;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public class Downloader implements Callable<byte[]>
{
	private URL U;
	private CyclicBarrier barrier;
	private long start, finish;
	
	public Downloader(URL U, CyclicBarrier barrier, long start, long finish)
	{
		this.U = U;
		this.barrier = barrier;
		this.start = start;
		this.finish = finish;
	}
	
	@SuppressWarnings("finally")
	public byte[] call() throws Exception
	{
		HttpURLConnection C = (HttpURLConnection) U.openConnection();
		C.setRequestMethod("GET");
		C.setRequestProperty("Range", "bytes="+start+"-"+finish);
		
		byte[] file_in_array = null;
		try(BufferedInputStream in = new BufferedInputStream(C.getInputStream());
			ByteArrayOutputStream out = new ByteArrayOutputStream())
		{
			byte[] buffer = new byte[2^15];
			int leidos = in.read(buffer);
			while(leidos != -1)
			{
				out.write(buffer, 0, leidos);
				leidos = in.read(buffer);
			}
			
			file_in_array = out.toByteArray();
		}
		catch(IOException e)
		{
			throw e;
		}
		finally
		{
			C.disconnect();
			barrier.await();
			return file_in_array;
		}
	}

}
