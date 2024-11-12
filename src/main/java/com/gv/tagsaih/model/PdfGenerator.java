package com.gv.tagsaih.model;


import com.gv.tagsaih.model.utils.Logger;
import com.gv.tagsaih.model.utils.StringFormatter;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.Desktop;
import java.io.IOException;
import java.util.List;


public class PdfGenerator {

    Logger logger = new Logger();

    // Método principal
    public static void main(String[] args) throws Exception {
        Operates operates = new Operates();
        System.out.println(operates.operate(new Tag(26, 24, 11028345, 9), new Tag(26, 24, 11028370, 2)));
        System.out.println(operates.operatesWithTagQuantity(new Tag(26,24,10190148,0), new Tag(26,24,10190147,9), 50));
        generatePdfFile("26,24,10190148,9", "26,24,10190147,0", 20);
        StringFormatter.convertStringToTag("26,24,10190148,7");
    }

    // Método para gerar PDF com a imagem transparente e numeração de etiqueta
    public static void generatePdfFile(String stringTag1, String stringTag2) throws Exception {
        Document document = new Document(new Rectangle(42f, 98f), 0, 0, 0, 0);
        document.setPageSize(document.getPageSize().rotate());
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("EtiquetasAIH.pdf"));
        document.open();

        Operates operates = new Operates();
        Tag tag1 = StringFormatter.convertStringToTag(stringTag1);
        Tag tag2 = StringFormatter.convertStringToTag(stringTag2);
        List<String> tags = operates.operate(tag1, tag2);

        // Adiciona a imagem transparente a cada tag
        for (int i = 0; i < tags.size(); i++) {
            document.newPage();
            addTransparentImage(writer, document); // Adiciona a imagem transparente no fundo da página
            addTagNumber(writer, tags.get(i), document); // Adiciona o número da etiqueta sobre a imagem
        }

        // Abre o PDF gerado
        Desktop.getDesktop().open(new File("EtiquetasAIH.pdf"));
        Logger logger = new Logger();
        logger.log(tags);
        document.close();
    }

    // Método para gerar PDF com a imagem transparente e numeração de etiqueta (com 3 tags)
    public static void generatePdfFile(String stringPreviousTag, String stringTag1, String stringTag2) throws Exception {
        Document document = new Document(new Rectangle(42f, 98f), 0, 0, 0, 0);
        document.setPageSize(document.getPageSize().rotate());
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("EtiquetasAIH.pdf"));
        document.open();

        Operates operates = new Operates();
        Tag previousTag = StringFormatter.convertStringToTag(stringPreviousTag);
        Tag tag1 = StringFormatter.convertStringToTag(stringTag1);
        Tag tag2 = StringFormatter.convertStringToTag(stringTag2);
        List<String> tags = operates.operate(previousTag, tag1, tag2);

        // Adiciona a imagem transparente a cada tag
        for (int i = 0; i < tags.size(); i++) {
            document.newPage();
            addTransparentImage(writer, document); // Adiciona a imagem transparente no fundo da página
            addTagNumber(writer, tags.get(i), document); // Adiciona o número da etiqueta sobre a imagem
        }

        // Abre o PDF gerado
        Desktop.getDesktop().open(new File("EtiquetasAIH.pdf"));
        Logger logger = new Logger();
        logger.log(tags);
        document.close();
    }

    // Método para gerar PDF com a imagem transparente e quantidade de tags
    public static void generatePdfFile(String stringTag1, Integer tagQuantity) {
        Document document = new Document(new Rectangle(42f, 98f), 0, 0, 0, 0);
        document.setPageSize(document.getPageSize().rotate());
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("EtiquetasAIH.pdf"));
            document.open();

            Operates operates = new Operates();
            Tag tag1 = StringFormatter.convertStringToTag(stringTag1);
            List<String> tags = operates.operatesWithTagQuantity(tag1, tagQuantity);

            // Adiciona a imagem transparente a cada tag
            for (int i = 0; i < tags.size(); i++) {
                document.newPage();
                addTransparentImage(writer, document); // Adiciona a imagem transparente no fundo da página
                addTagNumber(writer, tags.get(i), document); // Adiciona o número da etiqueta sobre a imagem
            }

            // Abre o PDF gerado
            Desktop.getDesktop().open(new File("EtiquetasAIH.pdf"));
            Logger logger = new Logger();
            logger.log(tags);
            document.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Método para gerar PDF com a imagem transparente, com 3 tags e quantidade de tags
    public static void generatePdfFile(String stringPreviousTag, String stringTag1, Integer tagQuantity) {
        Document document = new Document(new Rectangle(42f, 98f), 0, 0, 0, 0);
        document.setPageSize(document.getPageSize().rotate());
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("EtiquetasAIH.pdf"));
            document.open();

            Operates operates = new Operates();
            Tag tag1 = StringFormatter.convertStringToTag(stringTag1);
            Tag previousTag = StringFormatter.convertStringToTag(stringPreviousTag);
            List<String> tags = operates.operatesWithTagQuantity(previousTag, tag1, tagQuantity);

            // Adiciona a imagem transparente a cada tag
            for (int i = 0; i < tags.size(); i++) {
                document.newPage();
                addTransparentImage(writer, document); // Adiciona a imagem transparente no fundo da página
                addTagNumber(writer, tags.get(i), document); // Adiciona o número da etiqueta sobre a imagem
            }

            // Abre o PDF gerado
            Desktop.getDesktop().open(new File("EtiquetasAIH.pdf"));
            Logger logger = new Logger();
            logger.log(tags);
            document.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Método para adicionar a imagem transparente a cada página
    private static void addTransparentImage(PdfWriter writer, Document document) throws IOException, DocumentException {
        // Carregar a imagem do diretório 'resources' usando ClassLoader
        String imagePath = "background/sec-saude-gov-pe-logo.png";  // Caminho relativo
        File imageFile = new File(imagePath);

        if (!imageFile.exists()) {
            throw new IOException("Imagem não encontrada: " + imagePath);
        }

        Image image = Image.getInstance(imageFile.getAbsolutePath());

        // Ajustar a transparência da imagem (a opacidade vai de 0.0 a 1.0, sendo 0.0 totalmente transparente)
        float transparency = 0.2f;  // 20% de opacidade (80% de transparência)
        image.setTransparency(new int[]{(int) (255 * transparency), 255});

        // Obter o tamanho da página
        float pageWidth = document.getPageSize().getWidth();
        float pageHeight = document.getPageSize().getHeight()-15;

        // Redimensionar a imagem para caber na página mantendo a proporção
        image.scaleToFit(pageWidth, pageHeight);  // A imagem será escalada para caber dentro da página, mantendo a proporção

        // Calcular a posição central para a imagem
        float xPosition = (pageWidth - image.getScaledWidth()) / 2;  // Posição horizontal central
        float yPosition = (pageHeight - image.getScaledHeight()) / 2; // Posição vertical central

        // Definir a posição da imagem centralizada
        image.setAbsolutePosition(xPosition, yPosition);

        // Adicionar a imagem ao PDF
        PdfContentByte canvas = writer.getDirectContentUnder();
        canvas.addImage(image);
    }

    // Método para adicionar o número da etiqueta sobre a imagem
    private static void addTagNumber(PdfWriter writer, String tagText, Document document) throws DocumentException {
        // Adiciona o texto centralizado sobre a imagem
        Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        Paragraph paragraph = new Paragraph(tagText, font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.setSpacingBefore(150f);  // Ajuste a posição vertical conforme necessário
        document.add(paragraph);
    }
}
