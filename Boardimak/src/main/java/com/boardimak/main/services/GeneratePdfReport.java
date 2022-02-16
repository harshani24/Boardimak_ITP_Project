package com.boardimak.main.services;

import com.boardimak.main.model.Blogs;
import com.boardimak.main.model.Bookings;
import com.boardimak.main.model.CmsOther;
import com.boardimak.main.model.Payments;
import com.boardimak.main.model.Ticket;
import com.boardimak.main.model.Promotion;
import com.boardimak.main.model.Property;
import com.boardimak.main.model.Users;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Date;
import java.util.List;

public class GeneratePdfReport {
	

    private static final Logger logger = LoggerFactory.getLogger(GeneratePdfReport.class);
    
    public static ByteArrayInputStream AllCreatedTicket(List<Ticket> tickets) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        try {
        	
        	Font mainFont = FontFactory.getFont("TIMES_ROMAN", 24, BaseColor.BLUE);


            Paragraph paragraph = new Paragraph("All Created Ticket", mainFont);

            paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph.setIndentationLeft(50);
            paragraph.setIndentationRight(50);
            paragraph.setSpacingAfter(50);

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(90);
            table.setWidths(new int[]{10, 10, 10,10,10});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Ticket ID", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Name", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Status", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Subject", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Date & Time", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            for (Ticket ticket : tickets) {

                PdfPCell cell;


                cell = new PdfPCell(new Phrase(String.valueOf(ticket.getId())));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(ticket.getName()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(ticket.getStatus()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(ticket.getSubject()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(String.valueOf(ticket.getCreated_date())));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

   
            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(paragraph);
            document.add(table);

            document.close();

        } catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
    
    // Method to create reports with all the payment data
    public static ByteArrayInputStream allPaymentsReport(List<Payments> payments) {
    	
    	Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        

        try {
        	
        	Font mainFont = FontFactory.getFont("TIMES_ROMAN", 24, BaseColor.BLUE);


            Paragraph paragraph = new Paragraph("All Payments", mainFont);

            paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph.setIndentationLeft(50);
            paragraph.setIndentationRight(50);
            paragraph.setSpacingAfter(50);
            
            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(113);
            table.setWidths(new int[]{9, 7, 7, 2, 3, 3});
            
            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Transaction ID", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            
            hcell = new PdfPCell(new Phrase("Customer", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Intended account", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Payment type", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Amount", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
//            hcell = new PdfPCell(new Phrase("Status", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Date", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            for(Payments payment: payments) {
            	
            	PdfPCell cell;
            	
            	cell = new PdfPCell(new Phrase(String.valueOf(payment.getPayment_token()), font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setPaddingTop(10);
                cell.setPaddingBottom(10);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(String.valueOf(payment.getStripe_id()), font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setPaddingTop(10);
                cell.setPaddingBottom(10);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(String.valueOf(payment.getAccount_id()), font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setPaddingTop(10);
                cell.setPaddingBottom(10);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(String.valueOf(payment.getPaymentMethod()), font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPaddingTop(10);
                cell.setPaddingBottom(10);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase("RS." + String.valueOf(payment.getAmount()), font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(String.valueOf(payment.getDate()), font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setPaddingTop(10);
                cell.setPaddingBottom(10);
                table.addCell(cell);
                
            }
            
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(paragraph);
            document.add(table);
            
            document.close();
        }catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }
        
        return new ByteArrayInputStream(out.toByteArray());
    }
    

	public static ByteArrayInputStream paymentInvoice(Payments payment, Users customer, Users owner) {
		Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        try {
        	Font mainFont = FontFactory.getFont(FontFactory.HELVETICA, 28, BaseColor.BLUE);
        	Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 13, BaseColor.RED);
        	Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 13);
            Paragraph heading = new Paragraph("Payment Invoice", mainFont);

            heading.setAlignment(Element.ALIGN_CENTER);
            heading.setIndentationLeft(50);
            heading.setIndentationRight(50);
            heading.setSpacingAfter(50);
            
            // Create table 
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(90);
            table.setWidths(new int[]{6, 10});
            
            // Table cell
            PdfPCell cell;
            
            // create new paragraph
            Paragraph date = new Paragraph(payment.getDate().toString(), font2);
        	date.setAlignment(Element.ALIGN_RIGHT);
        	
        	Paragraph paymentId = new Paragraph("Payment ID : " + payment.getPayment_id(), font2);
        	paymentId.setSpacingAfter(50);
        	paymentId.setAlignment(Element.ALIGN_RIGHT);
        	
        	// Add cells to the table ------------------------
        	cell = new PdfPCell(new Phrase("Customer ID"));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingTop(10);
            cell.setPaddingBottom(10);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(payment.getStripe_id()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingTop(10);
            cell.setPaddingBottom(10);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Customer Name"));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingTop(10);
            cell.setPaddingBottom(10);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(customer.getFirstName() + " " + customer.getLastName()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingTop(10);
            cell.setPaddingBottom(10);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Reciever ID"));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingTop(10);
            cell.setPaddingBottom(10);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(owner.getFirstName() + " " + owner.getLastName()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingTop(10);
            cell.setPaddingBottom(10);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Reciever Name"));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingTop(10);
            cell.setPaddingBottom(10);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(payment.getAccount_id()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingTop(10);
            cell.setPaddingBottom(10);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Payment status"));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingTop(10);
            cell.setPaddingBottom(10);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(payment.getStatus(), font));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingTop(10);
            cell.setPaddingBottom(10);
            table.addCell(cell);
            
            table.setSpacingAfter(50);
            // Table completed -----------------------------------
            
        	Paragraph amount = new Paragraph("Amount : RS." + payment.getAmount(), mainFont);
        	amount.setAlignment(Element.ALIGN_RIGHT);
        	
//        	Paragraph status = new Paragraph("Payment status : " + payment.getStatus(), font);
//        	status.setAlignment(Element.ALIGN_RIGHT);
        	
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(heading);
            document.add(date);
            document.add(paymentId);
            document.add(table);
            document.add(amount);
            
            document.close();
        }catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }
        return new ByteArrayInputStream(out.toByteArray());
	}
	
	
	// Method to create reports with all the promotion data for admin
	public static ByteArrayInputStream AllAdminPromotionReport(List<Promotion> promotions) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        try {
        	
        	Font mainFont = FontFactory.getFont("TIMES_ROMAN", 24, BaseColor.BLUE);


            Paragraph paragraph = new Paragraph("All Promotions Details", mainFont);

            paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph.setIndentationLeft(50);
            paragraph.setIndentationRight(50);
            paragraph.setSpacingAfter(50);

            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(95);
            table.setWidths(new int[]{12, 15, 15,15,10,15,15});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Property ID", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Normal Price", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Discount(%)", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Discounted Price", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Status", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Start Date", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("End Date", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            for (Promotion promotion : promotions) {

                PdfPCell cell;


                cell = new PdfPCell(new Phrase(String.valueOf(promotion. getProperty_id())));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(promotion.getPro_price() ));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(promotion.getPercentage()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(promotion.getNew_price()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(promotion.getStatus() ));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(String.valueOf(promotion.getStart_date())));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(promotion.getEnd_date())));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);


   
            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(paragraph);
            document.add(table);

            document.close();

        } catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
	
	// Method to create reports with all the promotion data for owners
		public static ByteArrayInputStream AllOwnerPromotionReport(List<Promotion> promotions) {

	        Document document = new Document();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        
	        try {
	        	
	        	Font mainFont = FontFactory.getFont("TIMES_ROMAN", 24, BaseColor.BLUE);


	            Paragraph paragraph = new Paragraph("All Promotions Details", mainFont);

	            paragraph.setAlignment(Element.ALIGN_CENTER);
	            paragraph.setIndentationLeft(50);
	            paragraph.setIndentationRight(50);
	            paragraph.setSpacingAfter(50);

	            PdfPTable table = new PdfPTable(7);
	            table.setWidthPercentage(95);
	            table.setWidths(new int[]{12, 15, 15,15,10,15,15});

	            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

	            PdfPCell hcell;
	            hcell = new PdfPCell(new Phrase("Property ID", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);
	            
	            hcell = new PdfPCell(new Phrase("Normal Price", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);

	            hcell = new PdfPCell(new Phrase("Discount(%)", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);

	            hcell = new PdfPCell(new Phrase("Discounted Price", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);
	            
	            hcell = new PdfPCell(new Phrase("Status", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);
	            
	            hcell = new PdfPCell(new Phrase("Start Date", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);
	            
	            hcell = new PdfPCell(new Phrase("End Date", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);

	            for (Promotion promotion : promotions) {

	                PdfPCell cell;


	                cell = new PdfPCell(new Phrase(String.valueOf(promotion. getProperty_id())));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);
	                
	                cell = new PdfPCell(new Phrase(promotion.getPro_price() ));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);

	                cell = new PdfPCell(new Phrase(promotion.getPercentage()));
	                cell.setPaddingLeft(5);
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);
	                
	                cell = new PdfPCell(new Phrase(promotion.getNew_price()));
	                cell.setPaddingLeft(5);
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);
	                
	                cell = new PdfPCell(new Phrase(promotion.getStatus() ));
	                cell.setPaddingLeft(5);
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);
	                
	                cell = new PdfPCell(new Phrase(String.valueOf(promotion.getStart_date())));
	                cell.setPaddingLeft(5);
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                table.addCell(cell);

	                cell = new PdfPCell(new Phrase(String.valueOf(promotion.getEnd_date())));
	                cell.setPaddingLeft(5);
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                table.addCell(cell);


	   
	            }

	            PdfWriter.getInstance(document, out);
	            document.open();
	            document.add(paragraph);
	            document.add(table);

	            document.close();

	        } catch (DocumentException ex) {

	            logger.error("Error occurred: {0}", ex);
	        }

	        return new ByteArrayInputStream(out.toByteArray());
	    }
	    
		
		// Method to create reports with all the promotion data for one owner
				public static ByteArrayInputStream OneOwnerPromotionReport(List<Promotion> promotions) {

			        Document document = new Document();
			        ByteArrayOutputStream out = new ByteArrayOutputStream();
			        
			        try {
			        	
			        	Font mainFont = FontFactory.getFont("TIMES_ROMAN", 24, BaseColor.BLUE);


			            Paragraph paragraph = new Paragraph("My Promotions Details", mainFont);

			            paragraph.setAlignment(Element.ALIGN_CENTER);
			            paragraph.setIndentationLeft(50);
			            paragraph.setIndentationRight(50);
			            paragraph.setSpacingAfter(50);

			            PdfPTable table = new PdfPTable(7);
			            table.setWidthPercentage(95);
			            table.setWidths(new int[]{12, 15, 15,15,10,15,15});

			            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			            PdfPCell hcell;
			            hcell = new PdfPCell(new Phrase("Property ID", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
			            hcell = new PdfPCell(new Phrase("Normal Price", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);

			            hcell = new PdfPCell(new Phrase("Discount(%)", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);

			            hcell = new PdfPCell(new Phrase("Discounted Price", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
			            hcell = new PdfPCell(new Phrase("Status", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
			            hcell = new PdfPCell(new Phrase("Start Date", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
			            hcell = new PdfPCell(new Phrase("End Date", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);

			            for (Promotion promotion : promotions) {

			                PdfPCell cell;


			                cell = new PdfPCell(new Phrase(String.valueOf(promotion. getProperty_id())));
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			                table.addCell(cell);
			                
			                cell = new PdfPCell(new Phrase(promotion.getPro_price() ));
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			                table.addCell(cell);

			                cell = new PdfPCell(new Phrase(promotion.getPercentage()));
			                cell.setPaddingLeft(5);
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			                table.addCell(cell);
			                
			                cell = new PdfPCell(new Phrase(promotion.getNew_price()));
			                cell.setPaddingLeft(5);
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			                table.addCell(cell);
			                
			                cell = new PdfPCell(new Phrase(promotion.getStatus() ));
			                cell.setPaddingLeft(5);
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			                table.addCell(cell);
			                
			                cell = new PdfPCell(new Phrase(String.valueOf(promotion.getStart_date())));
			                cell.setPaddingLeft(5);
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                table.addCell(cell);

			                cell = new PdfPCell(new Phrase(String.valueOf(promotion.getEnd_date())));
			                cell.setPaddingLeft(5);
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                table.addCell(cell);


			   
			            }

			            PdfWriter.getInstance(document, out);
			            document.open();
			            document.add(paragraph);
			            document.add(table);

			            document.close();

			        } catch (DocumentException ex) {

			            logger.error("Error occurred: {0}", ex);
			        }

			        return new ByteArrayInputStream(out.toByteArray());
			    }
			    
				
			   //report generation part for property
				
			    public static ByteArrayInputStream AllCreatedProperties(List<Property> properties) {

			        Document document = new Document();
			        ByteArrayOutputStream out = new ByteArrayOutputStream();
			        
			        try {
			        	
			        	Font mainFont = FontFactory.getFont("TIMES_ROMAN", 24, BaseColor.BLUE);


			            Paragraph paragraph = new Paragraph("All Created Properties", mainFont);

			            paragraph.setAlignment(Element.ALIGN_CENTER);
			            paragraph.setIndentationLeft(50);
			            paragraph.setIndentationRight(50);
			            paragraph.setSpacingAfter(50);

			            PdfPTable table = new PdfPTable(5);
			            table.setWidthPercentage(90);
			            table.setWidths(new int[]{10, 10, 10,10,10});

			            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			            PdfPCell hcell;
			            hcell = new PdfPCell(new Phrase("Property ID", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
			            hcell = new PdfPCell(new Phrase("Owner ID", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);

			            hcell = new PdfPCell(new Phrase("Status", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);

			            hcell = new PdfPCell(new Phrase("City", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
			            hcell = new PdfPCell(new Phrase("Time Period", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);

			            for (Property property : properties) {

			                PdfPCell cell;


			                cell = new PdfPCell(new Phrase(String.valueOf(property.getId())));
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			                table.addCell(cell);
			                
			                cell = new PdfPCell(new Phrase(String.valueOf(property.getOwnerId())));
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			                table.addCell(cell);

			                cell = new PdfPCell(new Phrase(property.getStatus()));
			                cell.setPaddingLeft(5);
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                table.addCell(cell);
			                
			                cell = new PdfPCell(new Phrase(property.getCity()));
			                cell.setPaddingLeft(5);
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                table.addCell(cell);
			                
			                cell = new PdfPCell(new Phrase(String.valueOf(property.getTimePeriod())));
			                cell.setPaddingLeft(5);
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                table.addCell(cell);

			   
			            }

			            PdfWriter.getInstance(document, out);
			            document.open();
			            document.add(paragraph);
			            document.add(table);

			            document.close();

			        } catch (DocumentException ex) {

			            logger.error("Error occurred: {0}", ex);
			        }

			        return new ByteArrayInputStream(out.toByteArray());
			    }
			    
			    public static ByteArrayInputStream bookingsReport(List<Bookings> Bookings) {
			    	
			    	Document document = new Document();
			        ByteArrayOutputStream out = new ByteArrayOutputStream();
			        

			        try {
			        	
			        	Font mainFont = FontFactory.getFont("TIMES_ROMAN", 24, BaseColor.GRAY);


			            Paragraph paragraph = new Paragraph("All Bookings", mainFont);

			            paragraph.setAlignment(Element.ALIGN_CENTER);
			            paragraph.setIndentationLeft(50);
			            paragraph.setIndentationRight(50);
			            paragraph.setSpacingAfter(50);
			            
			            PdfPTable table = new PdfPTable(9);
			            table.setWidthPercentage(113);
			            table.setWidths(new int[]{2, 3, 3, 3, 5, 4,6,6,6});
			            
			            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			            Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);

			            PdfPCell hcell;
			            hcell = new PdfPCell(new Phrase("ID", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
			            
			            hcell = new PdfPCell(new Phrase("User ID", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
			            hcell = new PdfPCell(new Phrase("Owner ID", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
			            hcell = new PdfPCell(new Phrase("Property ID", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
			            hcell = new PdfPCell(new Phrase("Date Time", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
			            hcell = new PdfPCell(new Phrase("Status", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
//			            hcell = new PdfPCell(new Phrase("Status", headFont));
//			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			            table.addCell(hcell);
			            
			            hcell = new PdfPCell(new Phrase("Massege", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
			            hcell = new PdfPCell(new Phrase("User Email", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
			            hcell = new PdfPCell(new Phrase("Owner Email", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
			            
			            for(Bookings bookings : Bookings) {
			            	
			            	PdfPCell cell;
			            	
			            	cell = new PdfPCell(new Phrase(String.valueOf(bookings.getId()), font));
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                cell.setPaddingTop(10);
			                cell.setPaddingBottom(10);
			                table.addCell(cell);
			                
			                cell = new PdfPCell(new Phrase(String.valueOf(bookings.getUserID()), font));
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                cell.setPaddingTop(10);
			                cell.setPaddingBottom(10);
			                table.addCell(cell);
			                
			                cell = new PdfPCell(new Phrase(String.valueOf(bookings.getOwnerID()), font));
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                cell.setPaddingTop(10);
			                cell.setPaddingBottom(10);
			                table.addCell(cell);
			                
			                cell = new PdfPCell(new Phrase(String.valueOf(bookings.getPropertyID()), font));
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                cell.setPaddingTop(10);
			                cell.setPaddingBottom(10);
			                table.addCell(cell);
			                
			                cell = new PdfPCell(new Phrase(String.valueOf(bookings.getDate_time()), font));
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			                cell.setPaddingTop(10);
			                cell.setPaddingBottom(10);
			                table.addCell(cell);
			                
			                cell = new PdfPCell(new Phrase( String.valueOf(bookings.getStatus()), font));
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			                table.addCell(cell);
			                
			                cell = new PdfPCell(new Phrase(String.valueOf(bookings.getMassege()), font));
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                cell.setPaddingTop(10);
			                cell.setPaddingBottom(10);
			                table.addCell(cell);
			                
			                cell = new PdfPCell(new Phrase(String.valueOf(bookings.getUser_email()), font));
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                cell.setPaddingTop(10);
			                cell.setPaddingBottom(10);
			                table.addCell(cell);
			                
			                cell = new PdfPCell(new Phrase(String.valueOf(bookings.getOwner_email()), font));
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                cell.setPaddingTop(10);
			                cell.setPaddingBottom(10);
			                table.addCell(cell);
			                
			              
			            }
			            
			            PdfWriter.getInstance(document, out);
			            document.open();
			            document.add(paragraph);
			            document.add(table);
			            
			            document.close();
			        }catch (DocumentException ex) {

			            logger.error("Error occurred: {0}", ex);
			        }
			        
			        return new ByteArrayInputStream(out.toByteArray());
			    }
			    
			    public static ByteArrayInputStream allBlogsReport(List<Blogs> blogs) {
			    	
			    	Document document = new Document();
			        ByteArrayOutputStream out = new ByteArrayOutputStream();
			        

			        try {
			        	
			        	Font mainFont = FontFactory.getFont("TIMES_ROMAN", 24, BaseColor.DARK_GRAY);


			            Paragraph paragraph = new Paragraph("All Blogs", mainFont);

			            paragraph.setAlignment(Element.ALIGN_CENTER);
			            paragraph.setIndentationLeft(50);
			            paragraph.setIndentationRight(50);
			            paragraph.setSpacingAfter(50);
			            
			            PdfPTable table = new PdfPTable(6);
			            table.setWidthPercentage(113);
			            table.setWidths(new int[]{2, 6, 7, 5, 3, 3});
			            
			            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			            Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);

			            PdfPCell hcell;
			            hcell = new PdfPCell(new Phrase("ID", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
			            
			            hcell = new PdfPCell(new Phrase("Title", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
			            hcell = new PdfPCell(new Phrase("Description", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
			            hcell = new PdfPCell(new Phrase("Date Time", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
			            hcell = new PdfPCell(new Phrase("Status", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
//			            hcell = new PdfPCell(new Phrase("Status", headFont));
//			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			            table.addCell(hcell);
			            
			            hcell = new PdfPCell(new Phrase("Author", headFont));
			            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(hcell);
			            
			            for(Blogs blog: blogs) {
			            	
			            	PdfPCell cell;
			            	
			            	cell = new PdfPCell(new Phrase(String.valueOf(blog.getId()), font));
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                cell.setPaddingTop(10);
			                cell.setPaddingBottom(10);
			                table.addCell(cell);
			                
			                cell = new PdfPCell(new Phrase(String.valueOf(blog.getTitle()), font));
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                cell.setPaddingTop(10);
			                cell.setPaddingBottom(10);
			                table.addCell(cell);
			                
			                cell = new PdfPCell(new Phrase(String.valueOf(blog.getDescription()), font));
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                cell.setPaddingTop(10);
			                cell.setPaddingBottom(10);
			                table.addCell(cell);
			                
			                cell = new PdfPCell(new Phrase(String.valueOf(blog.getDateTime()), font));
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			                cell.setPaddingTop(10);
			                cell.setPaddingBottom(10);
			                table.addCell(cell);
			                
			                cell = new PdfPCell(new Phrase( String.valueOf(blog.getStatus()), font));
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			                table.addCell(cell);
			                
//			                cell = new PdfPCell(new Phrase(String.valueOf(payment.getStatus()), font));
//			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			                table.addCell(cell);
			                
			                cell = new PdfPCell(new Phrase(String.valueOf(blog.getAuthor()), font));
			                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                cell.setPaddingTop(10);
			                cell.setPaddingBottom(10);
			                table.addCell(cell);
			                
			               
			            }
			            
			            PdfWriter.getInstance(document, out);
			            document.open();
			            document.add(paragraph);
			            document.add(table);
			            
			            document.close();
			        }catch (DocumentException ex) {

			            logger.error("Error occurred: {0}", ex);
			        }
			        
			        return new ByteArrayInputStream(out.toByteArray());
			    }

			public static ByteArrayInputStream allCMSOtherReport(List<CmsOther> cmsOther) {
				
				Document document = new Document();
			    ByteArrayOutputStream out = new ByteArrayOutputStream();
			    

			    try {
			    	
			    	Font mainFont = FontFactory.getFont("TIMES_ROMAN", 24, BaseColor.DARK_GRAY);


			        Paragraph paragraph = new Paragraph("All CMS Others", mainFont);

			        paragraph.setAlignment(Element.ALIGN_CENTER);
			        paragraph.setIndentationLeft(50);
			        paragraph.setIndentationRight(50);
			        paragraph.setSpacingAfter(50);
			        
			        PdfPTable table = new PdfPTable(7);
			        table.setWidthPercentage(113);
			        table.setWidths(new int[]{2, 6, 7, 5, 3, 3,3});
			        
			        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			        Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);

			        PdfPCell hcell;
			        hcell = new PdfPCell(new Phrase("ID", headFont));
			        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			        table.addCell(hcell);
			        
			        
			        hcell = new PdfPCell(new Phrase("Title", headFont));
			        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			        table.addCell(hcell);
			        
			        hcell = new PdfPCell(new Phrase("Description", headFont));
			        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			        table.addCell(hcell);
			        
			        hcell = new PdfPCell(new Phrase("Date Time", headFont));
			        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			        table.addCell(hcell);
			        
			        hcell = new PdfPCell(new Phrase("Status", headFont));
			        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			        table.addCell(hcell);
			        
//			        hcell = new PdfPCell(new Phrase("Status", headFont));
//			        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			        table.addCell(hcell);
			        
			        hcell = new PdfPCell(new Phrase("Author", headFont));
			        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			        table.addCell(hcell);
			        
			        hcell = new PdfPCell(new Phrase("Type", headFont));
			        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			        table.addCell(hcell);
			        
			        
			        for(CmsOther cmsOthers: cmsOther) {
			        	
			        	PdfPCell cell;
			        	
			        	cell = new PdfPCell(new Phrase(String.valueOf(cmsOthers.getId()), font));
			            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			            cell.setPaddingTop(10);
			            cell.setPaddingBottom(10);
			            table.addCell(cell);
			            
			            cell = new PdfPCell(new Phrase(String.valueOf(cmsOthers.getTitle()), font));
			            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			            cell.setPaddingTop(10);
			            cell.setPaddingBottom(10);
			            table.addCell(cell);
			            
			            cell = new PdfPCell(new Phrase(String.valueOf(cmsOthers.getDescription()), font));
			            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			            cell.setPaddingTop(10);
			            cell.setPaddingBottom(10);
			            table.addCell(cell);
			            
			            cell = new PdfPCell(new Phrase(String.valueOf(cmsOthers.getDate_time()), font));
			            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            cell.setPaddingTop(10);
			            cell.setPaddingBottom(10);
			            table.addCell(cell);
			            
			            cell = new PdfPCell(new Phrase( String.valueOf(cmsOthers.getStatus()), font));
			            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            table.addCell(cell);
			            
//			            cell = new PdfPCell(new Phrase(String.valueOf(payment.getStatus()), font));
//			            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			            table.addCell(cell);
			            
			            cell = new PdfPCell(new Phrase(String.valueOf(cmsOthers.getAuthor()), font));
			            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			            cell.setPaddingTop(10);
			            cell.setPaddingBottom(10);
			            table.addCell(cell);
			            
			            cell = new PdfPCell(new Phrase(String.valueOf(cmsOthers.getType()), font));
			            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			            cell.setPaddingTop(10);
			            cell.setPaddingBottom(10);
			            table.addCell(cell);
			            
			            
			        }
			        
			        PdfWriter.getInstance(document, out);
			        document.open();
			        document.add(paragraph);
			        document.add(table);
			        
			        document.close();
			    }catch (DocumentException ex) {

			        logger.error("Error occurred: {0}", ex);
			    }
			    
			    return new ByteArrayInputStream(out.toByteArray());
			}
				
    
}