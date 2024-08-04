package com.gv.tagsaih.model;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.awt.Desktop;
import java.io.IOException;


public class TagGenerator {


    //Primeiramente, recebe os dados do FrontEnd.



    //TESTE:
    public static void main(String[] args) throws Exception {
          generatePdfFile(1000,2000);

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

    private static void generatePdfFile(int numero1, int numero2) throws Exception{
        //Configura tamanho da página:
        Document document = new Document(new Rectangle(42f,98f),0,0,4,0);
        //Rotaciona para paisagem:
        document.setPageSize(document.getPageSize().rotate());
        //Cria um arquivo pdf:
        PdfWriter.getInstance(document, new FileOutputStream("teste.pdf"));

        document.open();




        for (int i = numero1; i <= numero2; i++) {
            document.newPage();
            Paragraph paragraph = new Paragraph("test - " + String.valueOf(i));
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
        }





        Desktop.getDesktop().open(new File("teste.pdf"));

        document.close();
    }


















}
