package envioDosPartes;
import java.io.*;
import java.net.*;
public class Cliente
{
	public static void main(String[] args)
	{
		try
		(
			Socket s = new Socket("localhost",6666);
			BufferedOutputStream os = new BufferedOutputStream(s.getOutputStream());
			OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());

				
			ByteArrayOutputStream temp_buffer = new ByteArrayOutputStream();
			InputStream file_input = new FileInputStream(args[0])
		)
		{
			byte[] buffer = new byte[1024];
			int leidos = file_input.read(buffer);
			
			while(leidos != -1)
			{
				temp_buffer.write(buffer, 0, leidos);
				leidos = file_input.read(buffer);
			}
			
			temp_buffer.flush();
			
			byte [] file_in_array = temp_buffer.toByteArray();
			
			osw.write(Long.toString(file_in_array.length)+"\r\n");
			osw.write(args[0]+"\r\n");
			osw.flush();
			
			os.write(file_in_array, 0,file_in_array.length/2);
			os.flush();
			
			osw.write("He enviado la mitad del archivo"+"\r\n");
			osw.flush();
			
			os.write(file_in_array, Math.floorDiv(file_in_array.length, 2),file_in_array.length-Math.floorDiv(file_in_array.length, 2));
			os.flush();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
