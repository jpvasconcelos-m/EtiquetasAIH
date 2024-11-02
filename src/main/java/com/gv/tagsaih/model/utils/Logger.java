package com.gv.tagsaih.model.utils;

import com.gv.tagsaih.model.Operates;
import com.gv.tagsaih.model.Tag;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Logger {

    private static final String FILE_NAME = "log.txt";
    private static final int MAX_ENTRIES = 1000;
    Operates operates = new Operates();

    public void log(List<String> entries) {
        try {
            Path filePath = Paths.get(FILE_NAME);

            // Cria o arquivo se não existir
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }

            long lineCount = Files.lines(filePath).count();

            // Se o número de entradas for maior que o máximo, apagar o arquivo
            if (lineCount >= MAX_ENTRIES) {
                Files.delete(filePath);
                Files.createFile(filePath); // Recria o arquivo após deletar
            }

            // Adicionar novas entradas ao arquivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                for (String entry : entries) {
                    String timestampedEntry = LocalDateTime.now().format(dtf) + " - " + entry;
                    writer.write(timestampedEntry);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLastEntry() {
        Path filePath = Paths.get(FILE_NAME);

        try {
            // Verifica se o arquivo existe
            if (Files.exists(filePath)) {
                List<String> lines = Files.readAllLines(filePath);

                // Se o arquivo não estiver vazio, pega a última linha
                if (!lines.isEmpty()) {
                    String lastLine = lines.get(lines.size() - 1);
                    // Remove a parte da data/hora
                    return removeTimestamp(lastLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // Retorna null se não houver entradas
    }

    public List<String> getTwoLastEntries() {
        Path filePath = Paths.get(FILE_NAME);

        try {
            // Verifica se o arquivo existe
            if (Files.exists(filePath)) {
                List<String> lines = Files.readAllLines(filePath);

                // Se o arquivo não estiver vazio, pega as duas últimas linhas
                if (lines.size() >= 2) {
                    String secondLastLine = lines.get(lines.size() - 2);
                    String lastLine = lines.get(lines.size() - 1);
                    return List.of(removeTimestamp(secondLastLine), removeTimestamp(lastLine));
                } else if (lines.size() == 1) {
                    String lastLine = lines.get(lines.size() - 1);
                    return List.of(removeTimestamp(lastLine));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return List.of(); // Retorna uma lista vazia se não houver entradas
    }





    private String removeTimestamp(String entry) {
        return entry.substring(entry.indexOf(" - ") + 3);
    }

    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.log(List.of("Primeira entrada", "Segunda entrada", "Terceira entrada"));


    }

}
