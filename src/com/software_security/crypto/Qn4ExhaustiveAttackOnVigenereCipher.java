package com.software_security.crypto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Random;
import java.util.Scanner;

public class Qn4ExhaustiveAttackOnVigenereCipher {

    private static void exhaustiveAttack(String plainText, String cipherText) {
        int count = 0;
        String fileName = createNewLogFile();

        if(fileName == null){
            System.out.println("Failed to create log file!!!");
            return;
        }

        for(int first = -1; first < 26; first++){
            for(int second = -1; second < 26; second++) {
                for(int third = 0; third < 26; third++, ++count){
                    StringBuilder key = new StringBuilder();
                    if(first >=0){
                        key.append((char) (65 + first));
                    }
                    if(second >=0){
                        key.append((char) (65 + second));
                    }
                    key.append((char) (65 + third));

                    String decryptedText = decryption(cipherText, key.toString());

                    writeToFile(fileName, "Count : "+ count+ ", Key : "+key +" -> decrypted text : "+ decryptedText);

                    if(plainText.equals(decryptedText)){
                        System.out.println("Plain text : "+plainText);
                        System.out.println("Cipher text : "+cipherText);
                        System.out.println("\t\tThe key is : "+key+
                                " -> Found after exhaustive searching of "+count+" keys.");
                        return;
                    }
                }
            }
        }
    }

    private static void writeToFile(String fileName, String text) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
            bufferedWriter.append(text);
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the log file.");
            e.printStackTrace();
        }
    }

    private static String createNewLogFile() {
        try {
            String fileName = "vigenereCipherDecrypt_"+
                    new Random(8).nextInt() +".txt";
            File outputFile
                    = new File(fileName);
            outputFile.createNewFile();
            return fileName;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    public static String decryption(String cipherText, String key){
        StringBuilder actualText = new StringBuilder();

        int i = 0;
        while(i < cipherText.length()){
            if(Character.isUpperCase(cipherText.charAt(i))){
                char eachKey = key.charAt(i % key.length());
                int keyValue = (eachKey % 65);
                char ch = (char)(((int) cipherText.charAt(i) + 26 - keyValue - 65)% 26 + 65);
                actualText.append(ch);
            }else{
                actualText.append(cipherText.charAt(i));
            }
            i++;
        }
        return actualText.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your plain text...");
        String plainText = input.nextLine();

        System.out.println("Please enter your cipher text...");
        String cipherText = input.nextLine();

        exhaustiveAttack(plainText, cipherText);
    }
}
