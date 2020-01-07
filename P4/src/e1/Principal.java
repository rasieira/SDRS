package e1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Principal
{

	public static void main(String[] args) throws MalformedURLException, ExecutionException
	{
		if(args.length != 1) throw new IllegalArgumentException("Solo 1 parámetro admitido");
		ExecutorService pool = null;
		try(RandomAccessFile F = new RandomAccessFile(new File("media/"+args[0].substring(args[0].lastIndexOf('/'))),"rw"))
		{
			URL U = new URL("http","localhost",8080,args[0]);
			HttpURLConnection C = (HttpURLConnection) U.openConnection();
			C.setRequestMethod("HEAD");
			long size = C.getContentLengthLong();
			C.disconnect();
			
			pool = Executors.newFixedThreadPool(3);
			CyclicBarrier barrier = new CyclicBarrier(4);
			
			Downloader D1 = new Downloader(U,barrier,0,size/2);
			Downloader D2 = new Downloader(U,barrier,(size/2)+1,size-2);
			Downloader D3 = new Downloader(U,barrier,size-1,size-1);
			
			Future<byte[]> F1 = pool.submit(D1);
			Future<byte[]> F2 = pool.submit(D2);
			Future<byte[]> F3 = pool.submit(D3);
			
			barrier.await();
			
			F.seek(0);
			F.write(F1.get());
			F.write(F2.get());
			F.write(F3.get());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		finally
		{
			pool.shutdown();
		}
	}
}
