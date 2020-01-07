package e3;

import java.io.File;
import java.util.Timer;

public class Dispatcher {

	public static void main(String[] args)
	{
		if(args.length != 1) throw new IllegalArgumentException("Solo 1 argumento admitido");
		
		File D = new File(args[0]);
		if(!D.isDirectory() || !D.canRead()) throw new IllegalArgumentException("Debe ser un directorio con permisos de lectura");
		
		Timer T = new Timer();
		
		T.scheduleAtFixedRate(new Scanner(D), 0, 10000);
	}

}
