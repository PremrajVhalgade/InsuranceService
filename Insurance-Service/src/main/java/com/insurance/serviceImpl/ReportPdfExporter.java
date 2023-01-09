package com.insurance.serviceImpl;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.insurance.entity.Report;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ReportPdfExporter {
	private List<Report> listReports;
    
    public ReportPdfExporter(List<Report> listReports) {
        this.listReports = listReports;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("sr_no", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("from_date", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("insurance_id", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("policy_id", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("policy_name", font));
        table.addCell(cell);       
        
        cell.setPhrase(new Phrase("policy_type", font));
        table.addCell(cell);       
        
        cell.setPhrase(new Phrase("to_date", font));
        table.addCell(cell);    
        
        cell.setPhrase(new Phrase("user_name", font));
        table.addCell(cell);    
        
        cell.setPhrase(new Phrase("no_of_policies", font));
        table.addCell(cell);    
    }
     
    private void writeTableData(PdfPTable table) {
        for (Report report : listReports) {
            table.addCell(String.valueOf(report.getSrNo()));
            table.addCell(String.valueOf(report.getFromDate()));
            table.addCell(String.valueOf(report.getInsuranceId()));
            table.addCell(String.valueOf(report.getPolicyId()));
            table.addCell(report.getPolicyName());
            table.addCell(report.getPolicyType());
            table.addCell(String.valueOf(report.getToDate()));
            table.addCell(report.getUserName());
            table.addCell(String.valueOf(report.getNoOfPolicies()));
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
  
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("List of Reports", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(9);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f,1.5f, 1.5f, 3.5f, 3.0f, 3.0f, 3.0f, 3.0f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }

}
