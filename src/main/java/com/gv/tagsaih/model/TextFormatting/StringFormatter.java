package com.gv.tagsaih.model.TextFormatting;

public class StringFormatter {
    /*
    public static void main(String[] args) {
        String input = "2624110283702";
        String formatted = formatString(input);
        System.out.println(formatted);
    }
    */

    public String formatString(String input){
        if(input.length() <13) {
            throw new IllegalArgumentException("A etiqueta deve conter exatamente 13 dígitos, verifique a numeração e tente novamente.");
        }


        String part1 = input.substring(0,2);
        String part2 = input.substring(2,4);
        String part3 = input.substring(4,12);
        String part4 = input.substring(12,13);

        return part1+ "," + part2 + "," + part3 + "," + part4;

    }
}
