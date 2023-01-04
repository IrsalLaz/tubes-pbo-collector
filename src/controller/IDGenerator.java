/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.*;
import java.io.*;

/**
 *
 * @author panji
 */
public class IDGenerator {

    private static Map<Character, Integer> lastNumbers = new HashMap<>();
    private static Set<String> usedIDs = new HashSet<>();

    public static String generateID(char category) {
        // get lastNumber that has store at Map, if it is nothing, that will be default is 0
        int lastNumber = lastNumbers.getOrDefault(category, 0);
        lastNumber++;

        // put the new lastNumber to Map
        lastNumbers.put(category, lastNumber);

        // make an id that have format 1 digit letter and 3 digit number from lastNumber variable
        String id = String.format("%c%03d", category, lastNumber);

        // Add id to Set
        usedIDs.add(id);

        // store lastNumber and usedIDs to a file
        saveLastNumber();
        saveUsedID();

        // return id to itemController and store it to db
        return id;
    }

    public static String updateID(String oldId, char newCategory) {
        // Increment the last number for the new category
        int oldNumber = Integer.parseInt(oldId.substring(1));

        // Check if the new id is available
        String newId = String.format("%c%03d", newCategory, oldNumber);
        if (usedIDs.contains(newId)) {
            // The new id is not available, generate the next available ID for the new category
            int lastNumber = lastNumbers.getOrDefault(newCategory, 0);
            lastNumber++;
            lastNumbers.put(newCategory, lastNumber);
            newId = String.format("%c%03d", newCategory, lastNumber);
        }

        usedIDs.add(newId);
        usedIDs.remove(oldId);

        // store lastNumber and usedIDs to a file
        saveLastNumber();
        saveUsedID();

        return newId;
    }

    public static void reset() {
        lastNumbers.clear();
    }

    public static void deleteID(String id) {
        // Remove the ID from the usedIDs set
        usedIDs.remove(id);

        // Get the category letter and number from the ID
        char category = id.charAt(0);
        int number = Integer.parseInt(id.substring(1));

        // Decrement the value in the lastNumbers map for the category
        int lastNumber = lastNumbers.get(category);
        if (number == lastNumber) {
            lastNumbers.put(category, lastNumber - 1);
        }

        // Save the updated lastNumbers and usedIDs to the file
        saveLastNumber();
        saveUsedID();
    }

    public static void saveLastNumber() {
        try {
            FileOutputStream number = new FileOutputStream("lastnumber.dat");
            ObjectOutputStream out = new ObjectOutputStream(number);

            out.writeObject(lastNumbers);
        } catch (IOException | ClassCastException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveUsedID() {
        try {
            FileOutputStream id = new FileOutputStream("savedid.dat");
            ObjectOutputStream out = new ObjectOutputStream(id);

            out.writeObject(usedIDs);
        } catch (IOException | ClassCastException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readLastNumber() {
        try {
            FileInputStream number = new FileInputStream("lastnumber.dat");
            ObjectInputStream in = new ObjectInputStream(number);

            lastNumbers = (Map<Character, Integer>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readUsedID() {
        try {
            FileInputStream id = new FileInputStream("savedid.dat");
            ObjectInputStream in = new ObjectInputStream(id);

            usedIDs = (Set<String>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            System.out.println(e.getMessage());
        }
    }
}
