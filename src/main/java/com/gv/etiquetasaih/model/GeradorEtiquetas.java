package com.gv.etiquetasaih.model;


import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;


public class GeradorEtiquetas {


    //Primeiramente, recebe os dados do FrontEnd.



    //TESTE:
    public static void main(String[] args) throws Exception {

         Document document = new Document();
         PdfWriter.getInstance(document, new FileOutputStream("teste.pdf"));
         document.open();
         document.add(new Paragraph("Olá Mundo"));
         document.close();


    }















}
