package e5;
import java.io.*;

public class Principal
{
	public static void main(String[] args)
	{
		try(InputStream in = new FileInputStream(args[0]))
		{
			int dos_bytes = 0;
			int tres_bytes = 0;
			int ocho_bits = 0;
			
			byte[] buffer = new byte[50];
			int leidos = in.read(buffer);
			
			while(leidos != -1)
			{
				for(int i = 0;i < leidos;i++)
				{
					if(192 <= Byte.toUnsignedInt(buffer[i]) &&
							Byte.toUnsignedInt(buffer[i]) <= 223 &&
							
							128 <= Byte.toUnsignedInt(buffer[i+1]) &&
							Byte.toUnsignedInt(buffer[i+1]) <= 191)
					{
						dos_bytes++;
						i++;
					}
					else if(224 <= Byte.toUnsignedInt(buffer[i]) &&
							Byte.toUnsignedInt(buffer[i]) <= 239 &&
							
							128 <= Byte.toUnsignedInt(buffer[i+1]) &&
							Byte.toUnsignedInt(buffer[i+1]) <= 191 &&
							
							128 <= Byte.toUnsignedInt(buffer[i+2]) &&
							Byte.toUnsignedInt(buffer[i+2]) <= 191)
					{
						tres_bytes++;
						i = i+2;
					}
					else if(Byte.toUnsignedInt(buffer[i]) >= 128)
					{
						ocho_bits++;
					}
				}
				leidos = in.read(buffer);
			}
			if(dos_bytes > 0 || tres_bytes > 0)
			{
				System.out.println("UTF-8");
			}
			else
			{
				if(ocho_bits == 0)
				{
					System.out.println("ASCII");
				}
				else System.out.println("Otro formato no UTF-8");
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
