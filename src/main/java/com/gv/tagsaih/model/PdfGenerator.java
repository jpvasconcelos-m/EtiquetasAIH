package com.gv.tagsaih.model;


import com.gv.tagsaih.model.utils.Logger;
import com.gv.tagsaih.model.utils.StringFormatter;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.Desktop;
import java.io.IOException;
import java.util.List;


public class PdfGenerator {


    Logger logger = new Logger();


    //TESTE:
    public static void main(String[] args) throws Exception {
        Operates operates = new Operates();
        System.out.println(operates.operate(new Tag(26, 24, 11028345, 9),new Tag(26, 24, 11028370, 2)));
       // System.out.println(operates.operatesWithTagQuantity(new Tag(26, 24, 11028345, 9),100));
        System.out.println(operates.operatesWithTagQuantity(new Tag(26,24,10190148,0),new Tag(26,24,10190147,9),50));
        generatePdfFile("26,24,10190148,9","26,24,10190147,0",20);
        StringFormatter.convertStringToTag("26,24,10190148,7");
    }


    public static void generatePdfFile(String stringTag1, String stringTag2) throws Exception{
        //Configura tamanho da página:
        Document document = new Document(new Rectangle(42f,98f),0,0,-8,0);
        //Rotaciona para paisagem:
        document.setPageSize(document.getPageSize().rotate());
        //Cria um arquivo pdf:
        PdfWriter.getInstance(document, new FileOutputStream("EtiquetasAIH.pdf"));

        document.open();


       Operates operates = new Operates();
       Tag tag1 = StringFormatter.convertStringToTag(stringTag1);
       Tag tag2 = StringFormatter.convertStringToTag(stringTag2);
        List<String> tags = operates.operate(tag1,tag2);

        for (int i = 0; i < tags.size() ; i++) {
            document.newPage();
            Paragraph paragraph1 = new Paragraph(tags.get(i));
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            paragraph1.setSpacingBefore(-15f);
            document.add(paragraph1);

            document.newPage();
            Paragraph paragraph2 = new Paragraph(tags.get(i) + " Cópia");
            paragraph2.setAlignment(Element.ALIGN_CENTER);
            paragraph2.setSpacingBefore(-15f);
            document.add(paragraph2);

        }

        Desktop.getDesktop().open(new File("EtiquetasAIH.pdf"));
        Logger logger = new Logger();
        logger.log(tags);
        document.close();
    } public static void generatePdfFile(String stringPreviousTag,String stringTag1, String stringTag2) throws Exception{
        //Configura tamanho da página:
        Document document = new Document(new Rectangle(42f,98f),0,0,-8,0);
        //Rotaciona para paisagem:
        document.setPageSize(document.getPageSize().rotate());
        //Cria um arquivo pdf:
        PdfWriter.getInstance(document, new FileOutputStream("EtiquetasAIH.pdf"));

        document.open();


       Operates operates = new Operates();
       Tag previousTag = StringFormatter.convertStringToTag(stringPreviousTag);
       Tag tag1 = StringFormatter.convertStringToTag(stringTag1);
       Tag tag2 = StringFormatter.convertStringToTag(stringTag2);
        List<String> tags = operates.operate(previousTag,tag1,tag2);

        for (int i = 0; i < tags.size() ; i++) {
            document.newPage();
            Paragraph paragraph1 = new Paragraph(tags.get(i));
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            paragraph1.setSpacingBefore(-15f);
            document.add(paragraph1);


            document.newPage();
            Paragraph paragraph2 = new Paragraph(tags.get(i) + " Cópia");
            paragraph2.setAlignment(Element.ALIGN_CENTER);
            paragraph2.setSpacingBefore(-15f);
            document.add(paragraph2);

        }







        Desktop.getDesktop().open(new File("EtiquetasAIH.pdf"));
        Logger logger = new Logger();
        logger.log(tags);

        document.close();
    }
    public static void generatePdfFile(String stringTag1, Integer tagQuantity) {
        //Configura tamanho da página:
        Document document = new Document(new Rectangle(42f,98f),0,0,-8,0);
        //Rotaciona para paisagem:
        document.setPageSize(document.getPageSize().rotate());
        //Cria um arquivo pdf:
        try {
            PdfWriter.getInstance(document, new FileOutputStream("EtiquetasAIH.pdf"));
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        document.open();


        Operates operates = new Operates();
        Tag tag1 = StringFormatter.convertStringToTag(stringTag1);
        List<String> tags = null;
        try {
            tags = operates.operatesWithTagQuantity(tag1,tagQuantity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < tags.size() ; i++) {
            document.newPage();
            Paragraph paragraph1 = new Paragraph(tags.get(i));
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            paragraph1.setSpacingBefore(-15f);
            try {
                document.add(paragraph1);
            } catch (DocumentException e) {
                throw new RuntimeException(e);
            }

            document.newPage();
            Paragraph paragraph2 = new Paragraph(tags.get(i) + " Cópia");
            paragraph2.setAlignment(Element.ALIGN_CENTER);
            try {
                document.add(paragraph2);
            } catch (DocumentException e) {
                throw new RuntimeException(e);
            }

        }


        try {
            Desktop.getDesktop().open(new File("EtiquetasAIH.pdf"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Logger logger = new Logger();
        logger.log(tags);
        document.close();
    }public static void generatePdfFile(String stringPreviousTag,String stringTag1, Integer tagQuantity) {
        //Configura tamanho da página:
        Document document = new Document(new Rectangle(42f,98f),0,0,-8,0);
        //Rotaciona para paisagem:
       document.setPageSize(document.getPageSize().rotate());
        //Cria um arquivo pdf:
        try {
            PdfWriter.getInstance(document, new FileOutputStream("EtiquetasAIH.pdf"));
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        document.open();


        Operates operates = new Operates();
        Tag tag1 = StringFormatter.convertStringToTag(stringTag1);
        Tag previousTag = StringFormatter.convertStringToTag(stringPreviousTag);
        List<String> tags = null;
        try {
            tags = operates.operatesWithTagQuantity(previousTag,tag1,tagQuantity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(tags.size());

        for (int i = 0; i < tags.size() ; i++) {
            document.newPage();
            Paragraph paragraph1 = new Paragraph(tags.get(i));
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            paragraph1.setSpacingBefore(-15f);
            try {
                document.add(paragraph1);
            } catch (DocumentException e) {
                throw new RuntimeException(e);
            }

            document.newPage();
            Paragraph paragraph2 = new Paragraph(tags.get(i) + " Cópia");
            paragraph2.setAlignment(Element.ALIGN_CENTER);
            paragraph2.setSpacingBefore(20f);
            try {
                document.add(paragraph2);
            } catch (DocumentException e) {
                throw new RuntimeException(e);
            }

        }


        try {
            Desktop.getDesktop().open(new File("EtiquetasAIH.pdf"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Logger logger = new Logger();
        logger.log(tags);


        document.close();
    }





















}
