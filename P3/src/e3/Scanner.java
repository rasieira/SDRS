package e3;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TimerTask;

public class Scanner extends TimerTask
{
	private File rootDir;
	private long lastModified = 0;
	
	public Scanner(File F)
	{
		rootDir = F;
	}
	
	public void run()
	{
		if(lastModified == 0 || lastModified < rootDir.lastModified())
		{
			this.lastModified = rootDir.lastModified();
			List<File> files = new LinkedList<>();
			
			for(File F: rootDir.listFiles())
			{
				files.add(F);
			}
			
			System.out.flush();
			for(File F: files)
			{
				try {
					System.out.println(F.getCanonicalPath()+"\t"+new Date(F.lastModified()).toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
