package com.gv.tagsaih.model;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.awt.Desktop;
import java.io.IOException;


/* This class is responsible for PDF creation. */

public class TagGenerator {


    //Primeiramente, recebe os dados do FrontEnd.



    //TESTE:
    public static void main(String[] args) throws Exception {
          testarPdf2(1000,2000);

    }

    private static void testarPdf() throws IOException, DocumentException {

    }
    private void criarParagrafoAlinhado(){





    }

    private static void testarPdf2(int numero1, int numero2) throws Exception{
        //Configura tamanho da página:
        Document document = new Document(new Rectangle(42f,98f),0,0,4,0);
        //Rotaciona para paisagem:
        document.setPageSize(document.getPageSize().rotate());
        //Cria um arquivo pdf:
        PdfWriter.getInstance(document, new FileOutputStream("teste.pdf"));

        document.open();

        for (int i = 0; i < (numero2-numero1) ; i++) {

            int temp = numero1 +i;

            Paragraph paragraph1 = new Paragraph(temp);
            paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(paragraph1);
           paragraph1 = new Paragraph(temp + " - copia");
           document.newPage();
            document.add(paragraph1);


            Paragraph paragraph2 = new Paragraph(temp + " - Cópia");
            paragraph2.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(paragraph2);

        }



        Desktop.getDesktop().open(new File("teste.pdf"));

        document.close();
    }


















}
