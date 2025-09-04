package org.example;

import org.apache.commons.collections4.iterators.PermutationIterator;
import org.example.exceptions.InvalidCharacterException;
import org.example.exceptions.StringBlankOrEmptyException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        generateAnagrams("amor");
    }
    public static List<String> generateAnagrams(String word) {

        List<String> result = new ArrayList<>();

        if (word.isBlank() || word.isEmpty()){
            throw new StringBlankOrEmptyException(word+" is blank or empty");
        }

        if (!word.matches("^[a-zA-Z]+$")){
            throw new InvalidCharacterException("There is invalid character in "+word);
        }

        if (word.length() == 1){
            result.add(word);
            return result;
        }

        List<String> elements = word.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.toList());

        PermutationIterator<String> iterator = new PermutationIterator<>(elements);

        while (iterator.hasNext()) {
            result.add(String.join("",iterator.next().stream().toList()));
        }
        return result;
    }
}