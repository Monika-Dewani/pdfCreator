package com.example.pdfcreator.services;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

    private Logger logger= LoggerFactory.getLogger(PdfService.class);
    public ByteArrayInputStream createPdf(){

        logger.info("Create PDF Started...");

        String title="All About Java";
        String content="Java is a popular, general-purpose programming language that was developed by Sun Microsystems (now owned by Oracle Corporation) in the mid-1990s. It is designed to be platform-independent, which means that Java programs can run on any device or operating system that has a Java Virtual Machine (JVM) installed.";

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Document document = new Document();

        PdfWriter.getInstance(document,out);

        document.open();

        Font titleFont= FontFactory.getFont(FontFactory.TIMES_ROMAN,30, Color.BLUE);
        Paragraph titleText = new Paragraph(title, titleFont);
        titleText.setAlignment(Element.ALIGN_CENTER);
        document.add(titleText);

        Font paraFont = FontFactory.getFont(FontFactory.TIMES_ITALIC);
        Paragraph para= new Paragraph(content);
        para.add(new Chunk("Some popular frameworks and technologies associated with Java include Spring, Hibernate, JavaFX, Apache Struts, Apache Maven, and many others. These frameworks provide additional functionalities and facilitate application development in specific areas."));
        para.setAlignment(Element.ALIGN_CENTER);
        document.add(para);

        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
}
