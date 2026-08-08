package com.example.welfareassociation.Utility;

import java.io.*;

public class FileHandler {

    // Save any Serializable object to a file
    public static void saveObject(Object object, String fileName) {

        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(
                             new FileOutputStream(fileName))) {

            outputStream.writeObject(object);

            System.out.println("Object saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving object: " + e.getMessage());
        }
    }


    // Read an object from a file
    public static Object loadObject(String fileName) {

        try (ObjectInputStream inputStream =
                     new ObjectInputStream(
                             new FileInputStream(fileName))) {

            Object object = inputStream.readObject();

            System.out.println("Object loaded successfully.");

            return object;

        } catch (FileNotFoundException e) {

            System.out.println("File not found: " + fileName);

        } catch (IOException e) {

            System.out.println("Error reading file: " + e.getMessage());

        } catch (ClassNotFoundException e) {

            System.out.println("Class not found: " + e.getMessage());
        }

        return null;
    }
}
