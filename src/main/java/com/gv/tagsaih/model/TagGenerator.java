package com.gv.tagsaih.model;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.awt.Desktop;
import java.io.IOException;
import java.util.List;


public class TagGenerator {


    //Primeiramente, recebe os dados do FrontEnd.



    //TESTE:
    public static void main(String[] args) throws Exception {
        Operates operates = new Operates();
        System.out.println(operates.operate(new Tag(26, 24, 11028345, 9),new Tag(26, 24, 11028370, 2)));
        generatePdfFile(new Tag(26, 24, 11028345, 9),new Tag(26, 24, 11028370, 2));


    }

    private static void testarPdf() throws IOException, DocumentException {
         //Configura tamanho da página:
         Document document = new Document(new Rectangle(42f,98f),0,0,4,0);
         //Rotaciona para paisagem:
         document.setPageSize(document.getPageSize().rotate());
         //Cria um arquivo pdf:
         PdfWriter.getInstance(document, new FileOutputStream("teste.pdf"));

         document.open();

         Paragraph paragraph = new Paragraph("Teste - 1234");
         paragraph.setAlignment(Paragraph.ALIGN_CENTER);
         document.add(paragraph);
         Desktop.getDesktop().open(new File("teste.pdf"));

         document.close();
    }
    private void criarParagrafoAlinhado(){





    }

    private static void generatePdfFile(Tag tag1, Tag tag2) throws Exception{
        //Configura tamanho da página:
        Document document = new Document(new Rectangle(42f,98f),0,0,4,0);
        //Rotaciona para paisagem:
        document.setPageSize(document.getPageSize().rotate());
        //Cria um arquivo pdf:
        PdfWriter.getInstance(document, new FileOutputStream("teste.pdf"));

        document.open();


       Operates operates = new Operates();
        List<String> tags = operates.operate(tag1,tag2);

        for (int i = 0; i < tags.size() ; i++) {
            document.newPage();
            Paragraph paragraph = new Paragraph(tags.get(i));
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);

        }






        Desktop.getDesktop().open(new File("teste.pdf"));

        document.close();
    }


















}
