package e4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class AtenderPeticion implements Runnable
{
	private File F;
	private Socket S;

	public AtenderPeticion(Socket S, File F)
	{
		this.S = S;
		this.F = F;
	}

	public void run()
	{
		try (FileInputStream f_in = new FileInputStream(F);
			 BufferedInputStream in = new BufferedInputStream(f_in);
			 BufferedOutputStream out = new BufferedOutputStream(S.getOutputStream());)
		{
			byte[] buffer = new byte[2 ^ 20];
			int leidos = in.read(buffer);
			while (leidos != -1)
			{
				out.write(buffer, 0, leidos);
				leidos = in.read(buffer);
			}
			out.flush();

		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			if (S != null)
			try
			{
				S.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
