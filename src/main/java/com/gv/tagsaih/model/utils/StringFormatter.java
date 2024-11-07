package com.gv.tagsaih.model.utils;

import com.gv.tagsaih.model.Tag;
import com.gv.tagsaih.view.exceptions.IncorrectTagSizeException;

public class StringFormatter {
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
    /*
    public static void main(String[] args) {
        String input = "2624110283702";
        String formatted = formatString(input);
        System.out.println(formatted);
    }
    */

    public static String formatString(String input){



        String part1 = input.substring(0, 2); // Os primeiros 2 caracteres
        String part2 = input.substring(2, 4); // Os próximos 2 caracteres
        String part3 = input.substring(4, input.length() - 1); // Parte 3 até o penúltimo caractere
        String part4 = input.substring(input.length() - 1); // Último caractere
        System.out.println(part1+ "," + part2 + "," + part3 + "," + part4);

        return part1+ "," + part2 + "," + part3 + "," + part4;

    }
}
