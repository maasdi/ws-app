package com.maasdianto.ws.service;

import java.io.IOException;

import com.maasdianto.attachment.Pdf;

public interface AttachmentService {
	
	void setAttachment(Pdf pdf) throws IOException;

}
