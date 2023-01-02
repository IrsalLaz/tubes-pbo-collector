/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author panji
 */
public class IDGenerator {
    private static Map<Character, Integer> lastNumbers = new HashMap<>();

    public static String generateID(char category) {
        int lastNumber = lastNumbers.getOrDefault(category, 0);
        lastNumber++;
        lastNumbers.put(category, lastNumber);
        return String.format("%c%03d", category, lastNumber);
    }

    public static String updateID(char newCategory) {
        // Increment the last number for the new category
        int lastNumber = lastNumbers.getOrDefault(newCategory, 0);
        lastNumber++;
        lastNumbers.put(newCategory, lastNumber);
        return String.format("%c%03d", newCategory, lastNumber);
    }

    public static void reset() {
        lastNumbers.clear();
    }
}
