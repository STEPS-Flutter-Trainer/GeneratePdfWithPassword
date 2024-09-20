package GeneratePdf;
import java.io.*;
import java.util.Date;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePdf {
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            String USER_PASS = "User123";
            
            String OWNER_PASS = "Owner123";
            OutputStream file = new FileOutputStream(new File("Test.pdf"));

            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);

            writer.setEncryption(USER_PASS.getBytes(), OWNER_PASS.getBytes(),
                    PdfWriter.ALLOW_PRINTING|PdfWriter.ALLOW_COPY, PdfWriter.ENCRYPTION_AES_128);
            Image image1 = Image.getInstance("3.png");
            image1.setAlignment(Element.ALIGN_CENTER);               
            document.open();    
            document.add(image1);
            document.add(new Paragraph("\n"));
            document.add(new Paragraph());
            document.add(new Paragraph("Password Protected Pdf"));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph());
            document.add(new Paragraph(new Date().toString()));

            document.close();
            file.close();
            System.out.println("Pdf generated");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

