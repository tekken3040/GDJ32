package test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileCharsetUtil {
	 
    public static void convertUTF8toMS949(String originalEncoding,
    									  String destEncoding,	
    		                              String inFileName, 
    		                              String outFileName) throws Exception {
         
        FileInputStream fileInputStream = null;
        Reader reader = null;
        Writer writer = null;
        StringBuffer stringBuffer = new StringBuffer();
         
        int intRead = 0;
         
        fileInputStream = new FileInputStream(inFileName);
        Charset inputCharset = Charset.forName("MS949");
        InputStreamReader isr = new InputStreamReader(fileInputStream, inputCharset);
         
        reader = new BufferedReader(isr);
         
        while( ( intRead = reader.read() ) > -1 ) {
            stringBuffer.append((char)intRead);
        }
        reader.close();
         
        //
        FileOutputStream fos = new FileOutputStream(outFileName);
        writer = new OutputStreamWriter(fos, "utf-8");
        writer.write(stringBuffer.toString());
        stringBuffer.setLength(0);
        writer.close();
    }
    
    public static void main(String[] args) {
    	
    	String filesPath = "D:\\lsh\\works\\java3\\io_project";
		
    	try {
    		
			Files.walk(Paths.get(filesPath)).forEach(filePath -> {
				
			    if (Files.isRegularFile(filePath)) {
			        // System.out.println(filePath);
			    	
			    	try {
							FileCharsetUtil.convertUTF8toMS949("MS949", 
															   "UTF-8", 
															   filePath.toString(), 
															   filePath.toString());
					} catch (Exception e) {
						e.printStackTrace();
					} //
			    }
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		} //
    	
	} // main
}