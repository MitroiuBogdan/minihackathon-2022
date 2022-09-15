package com.coding.problem19;

import java.util.*;

/**
 * You are a detective investigating a crime. You found an old phone (with button, not a smartphone)
 * as evidence. It's a strange phone, but the colleagues from the lab found out that it's unlocked
 * using a letters only password, and they which digits were pressed.
 * <p>
 * Write a program that returns all possible letter combinations, for a given subset of digits.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below. <p>
 * 2=abc 3=def  <p>
 * 4=ghi  5=jkl 6=mno  <p>
 * 7=pqrs 8=tuv 9=wxyz <p>>
 * Note that 1 does not map to any letters.
 * <p>
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * Example 2:
 * Input: digits = ""
 * Output: []
 * <p>
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 */
public class OldPhone {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty() || "1".contentEquals(digits) || "0".contentEquals(digits))
            return Collections.emptyList();

        String[] letterMappings = { "0",   "1",   "abc",  "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz" };

        ArrayList<String> list = letterCombinationsUtil(sanitizeInput(digits), digits.length(), letterMappings);
        return list;

    }

    int[] sanitizeInput(String digits) {
        String[] split = digits.split("(?!^)");
        int[] array = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            array[i] = Integer.parseInt(split[i]);
        }
        return array;
    }

    static ArrayList<String>
    letterCombinationsUtil(int[] number, int n, String[] letterMappings)
    {
        ArrayList<String> output = new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        q.add("");

        while (!q.isEmpty()) {
            String s = q.remove();

            if (s.length() == n)
                output.add(s);
            else {
                String val = letterMappings[number[s.length()]];
                for (int i = 0; i < val.length(); i++)
                {
                    q.add(s + val.charAt(i));
                }
            }
        }
        return output;
    }
}
