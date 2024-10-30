package com.gv.tagsaih.model;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.Desktop;
import java.io.IOException;
import java.util.List;


public class PdfGenerator {
    //TESTE:
    public static void main(String[] args) throws Exception {
        Operates operates = new Operates();
        System.out.println(operates.operate(new Tag(26, 24, 11028345, 9),new Tag(26, 24, 11028370, 2)));
        System.out.println(operates.operatesWithTagQuantity(new Tag(26, 24, 11028345, 9),100));
//        generatePdfFile(new Tag(26, 24, 11028345, 9),new Tag(26, 24, 11028370, 2));
        convertStringToTag("26,24,10190148,7");
    }


    public static Tag convertStringToTag(String tagString) {
        // Supondo que a string tem o formato "param1,param2,param3,param4"
        String[] parts = tagString.split(",");



        try {
            int param1 = Integer.parseInt(parts[0].trim());
            int param2 = Integer.parseInt(parts[1].trim());
            int param3 = Integer.parseInt(parts[2].trim());
            int param4 = Integer.parseInt(parts[3].trim());

            return new Tag(param1, param2, param3, param4);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Os parâmetros devem ser apenas números!", e);
        }
    }

    public static void generatePdfFile(String stringTag1, String stringTag2) throws Exception{
        //Configura tamanho da página:
        Document document = new Document(new Rectangle(42f,98f),0,0,4,0);
        //Rotaciona para paisagem:
        document.setPageSize(document.getPageSize().rotate());
        //Cria um arquivo pdf:
        PdfWriter.getInstance(document, new FileOutputStream("teste.pdf"));

        document.open();


       Operates operates = new Operates();
       Tag tag1 = convertStringToTag(stringTag1);
       Tag tag2 = convertStringToTag(stringTag2);
        List<String> tags = operates.operate(tag1,tag2);

        for (int i = 0; i < tags.size() ; i++) {
            document.newPage();
            Paragraph paragraph1 = new Paragraph(tags.get(i));
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph1);

            document.newPage();
            Paragraph paragraph2 = new Paragraph(tags.get(i) + " Cópia");
            paragraph2.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph2);

        }







        Desktop.getDesktop().open(new File("teste.pdf"));

        document.close();
    }
    public static void generatePdfFile(String stringTag1, Integer tagQuantity) {
        //Configura tamanho da página:
        Document document = new Document(new Rectangle(42f,98f),0,0,4,0);
        //Rotaciona para paisagem:
        document.setPageSize(document.getPageSize().rotate());
        //Cria um arquivo pdf:
        try {
            PdfWriter.getInstance(document, new FileOutputStream("teste.pdf"));
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        document.open();


        Operates operates = new Operates();
        Tag tag1 = convertStringToTag(stringTag1);
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
            Desktop.getDesktop().open(new File("teste.pdf"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        document.close();
    }





















}
