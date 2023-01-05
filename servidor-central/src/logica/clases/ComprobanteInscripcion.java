package logica.clases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import datatypes.DTInscripcion;

public class ComprobanteInscripcion{
	
	public ComprobanteInscripcion(){
		
	}
	
	@SuppressWarnings("static-access")
	public byte[] generar(DTInscripcion insc) throws DocumentException, IOException {
		
		// 1. Create document
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);

        // 2. Create PdfWriter
        Configuracion config = Configuracion.getInstance();
        PdfWriter.getInstance(document, new FileOutputStream(config.getFilePath() + insc.getSalida() + ".pdf"));

        // 3. Open document
        document.open();

        // 4. Add content
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Font italicFont = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.ITALIC);
        italicFont.setColor(107,107,107);
        
        Paragraph comprobanteTitle = new Paragraph("Comprobante de Inscripción", boldFont);
        comprobanteTitle.setAlignment(comprobanteTitle.ALIGN_CENTER);;
        
        PdfPTable table = new PdfPTable(2);
        table.addCell(new Paragraph("Nombre Turista:"));
        table.addCell(new Paragraph(insc.getNombreTurista()));
        table.addCell(new Paragraph("Actividad: "));
        table.addCell(new Paragraph(insc.getActividad()));
        table.addCell(new Paragraph("Salida: "));
        table.addCell(new Paragraph(insc.getSalida()));
        table.addCell(new Paragraph("Fecha de Salida"));
        table.addCell(new Paragraph(new SimpleDateFormat("dd/MM/yyyy").format(insc.getFechaSalida().getTime())));
        table.addCell(new Paragraph("Hora de Salida"));
        table.addCell(new Paragraph(new SimpleDateFormat("HH:mm").format(insc.getFechaSalida().getTime())));
        table.addCell(new Paragraph("Fecha inscripcion: "));
        table.addCell(new Paragraph(new SimpleDateFormat("dd/MM/yyyy").format(insc.getFechaAlta().getTime())));
        table.addCell(new Paragraph("Cantidad de turistas: "));
        table.addCell(new Paragraph(Integer.toString(insc.getCantTuristas())));
        table.addCell(new Paragraph("Costo: $"));
        table.addCell(new Paragraph(Float.toString(insc.getCosto())));
        table.addCell(new Paragraph("Tipo Inscripcion: "));
        table.addCell(new Paragraph(insc.getTipo().toString()));
        
        document.add(new Phrase("Turismo.uy", italicFont));
        document.add(comprobanteTitle);
        document.add(Chunk.NEWLINE);
        document.add(table);

        // 5. Close document
        document.close();
        
        // 6. Convert to byte[]
        Path pdfPath = Paths.get(config.getFilePath() + insc.getSalida() + ".pdf");
        byte[] pdf = Files.readAllBytes(pdfPath);
        
        File f = new File(pdfPath.toString());
        f.delete();
        
        return pdf;
	}
}