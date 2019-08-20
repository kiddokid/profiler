package com.example.profiler.formatting;

import java.util.Objects;

public class StringFormatter {

    public String format(String inputStr) {
        if (Objects.isNull(inputStr)) {
            return null;
        }
        String cleanStr = removeDirt(inputStr);
        String sortedStr = cleanStr.chars()
                .sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return sortedStr;
    }

    private String removeDirt(String inputStr) {
        //REMOVE Str, domain and other trash
        return null;
    }
}
