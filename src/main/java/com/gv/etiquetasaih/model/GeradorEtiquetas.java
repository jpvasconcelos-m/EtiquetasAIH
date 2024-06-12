package com.gv.etiquetasaih.model;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.awt.Desktop;



public class GeradorEtiquetas {


    //Primeiramente, recebe os dados do FrontEnd.



    //TESTE:
    public static void main(String[] args) throws Exception {

         Image image = Image.getInstance("Rickroll.jpg");
         image.scaleAbsolute(500,200);
         Document document = new Document();
         PdfWriter.getInstance(document, new FileOutputStream("teste.pdf"));
         document.open();
         document.add(new Paragraph("Olá Mundo"));
         List list = new List();
         list.setSymbolIndent(12);
         list.setListSymbol("\u2022");
         list.add(new ListItem("Never gonna give you up"));
         list.add(new ListItem("Never gonna let you down"));
         list.add(new ListItem("Never gonna run around and desert you"));
         list.add(new ListItem("Never gonna make you cry"));
         list.add(new ListItem("Never gonna say goodbye"));
         list.add(new ListItem("Never gonna tell a lie and hurt you"));
         document.add(list);
         document.add(image);
         document.add(image);
         document.add(image);

         Desktop.getDesktop().open(new File("teste.pdf"));

         document.close();


    }



















}
