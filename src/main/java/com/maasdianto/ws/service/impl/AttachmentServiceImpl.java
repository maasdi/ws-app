package com.maasdianto.ws.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.activation.DataHandler;

import com.maasdianto.attachment.Pdf;
import com.maasdianto.ws.service.AttachmentService;

public class AttachmentServiceImpl implements AttachmentService {

	public void setAttachment(Pdf pdf) throws IOException {
		String userDir = System.getProperty("user.home");
		System.out.println(userDir + "\\" + pdf.getName());
		File file = new File(userDir + "\\" + pdf.getFile());
		DataHandler dataHandler = pdf.getFile();
		
		FileOutputStream outputStream = new FileOutputStream(file);
		dataHandler.writeTo(outputStream);
		outputStream.flush();
		outputStream.close();
		System.out.println("InputStream : "+dataHandler.getInputStream());
		
		System.out.println("Done !");

	}

}
