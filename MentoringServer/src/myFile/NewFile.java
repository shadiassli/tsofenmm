package myFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.ZipInputStream;

public class NewFile implements Runnable
{
	   private byte [] File ;

	   public NewFile(byte[] file)
	   {
	       File = file;
	   }

	   @Override
	   public void run()
	   {
	       try
	       {
	           System.out.println("run - accessed");
	           byte [] buffer = new byte[1024];
	           int len ;
	           ByteArrayInputStream inputStream = new ByteArrayInputStream(this.File);
	           ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	           ZipInputStream zipInputStream = new ZipInputStream(inputStream);
	           String entryName = zipInputStream.getNextEntry().getName();
	           OutputStream file = new FileOutputStream("C:\\MMProj\\mmFiles"+entryName);
	           while ((len = zipInputStream.read(buffer)) != -1)
	           {
	               outputStream.write(buffer,0,len);
	           }
	           file.write(outputStream.toByteArray());
	           file.flush();
	           file.close();
	           System.out.println("done"+entryName);
	       }
	       catch (Exception e)
	       {
	           e.printStackTrace();
	       }

	   }
	}
