package e3;

import java.io.*;
import java.util.*;

public class Principal
{
	public static void main(String[] args)
	{
		File f = new File(args[0]);
		if(!f.exists())
		{
			System.out.println(args[0] + " " + "no existe");
			return;
		}
		
		File[] fileList = f.listFiles();
		
		String result = "";
		Date lastModified = new Date();
		for(int i = 0;i < fileList.length;i++)
		{
			result = fileList[i].getName();
			if(fileList[i].isDirectory()) result = result + " <DIR>";
			result = result + "       " + fileList[i].getTotalSpace() + "          ";
			lastModified.setTime(fileList[i].lastModified());
			result = result + lastModified.toString();
			System.out.println(result);
			result = "";
		}
	}
}
