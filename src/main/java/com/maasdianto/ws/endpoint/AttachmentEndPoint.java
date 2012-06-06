package com.maasdianto.ws.endpoint;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.xml.bind.JAXBElement;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import com.maasdianto.attachment.ObjectFactory;
import com.maasdianto.attachment.Pdf;
import com.maasdianto.ws.domain.FileException;

@Endpoint
public class AttachmentEndPoint {

	private ObjectFactory objectFactory = new ObjectFactory();

	@PayloadRoot(localPart = "loadPdfRequest", namespace = "http://www.maasdianto.com/attachment")
	public JAXBElement<Pdf> loadAttachment(JAXBElement<String> requestElemet) {
		String pdfName = requestElemet.getValue();
		// instance Pdf for response
		Pdf response = new Pdf();
		File file = new File(System.getProperty("user.home") +"/"+ pdfName);
		if(!file.exists()){
			throw new FileException("File "+ pdfName +" is not exist");
		}
		response.setName(file.getName());
		DataSource dataSource = new FileDataSource(file);
		response.setFile(new DataHandler(dataSource));
		
		return objectFactory.createLoadPdfResponse(response);
	}

	@PayloadRoot(localPart = "sendPdfRequest", namespace = "http://www.maasdianto.com/attachment")
	public JAXBElement<String> sendAttachment(JAXBElement<Pdf> requestElement) {
		String response = "failed";
		Pdf pdf = requestElement.getValue();
		DataHandler handler = pdf.getFile();
		try {
			File file = new File(System.getProperty("user.home") + "/" + pdf.getName());
			FileOutputStream outputStream = new FileOutputStream(file);
			handler.writeTo(outputStream);
			outputStream.flush();
			outputStream.close();
			response = "done";
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		return objectFactory.createSendPdfResponse(response);
	}

}
