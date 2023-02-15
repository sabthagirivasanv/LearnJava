package com.software_security.crypto;

import java.util.Scanner;

public class Qn3VigenereCipher {

    //Method to implement Encryption
    public static String Encryption(String plainText, String key){
        StringBuilder cipherText = new StringBuilder();

        int i = 0;
        while(i < plainText.length()){
            char eachKey = key.charAt(i % key.length());
            int keyValue = (eachKey % 65);
            char ch = (char)(((int) plainText.charAt(i) + keyValue) % 128);
            cipherText.append(ch);
            i++;
        }
        return cipherText.toString();
    }

    //Method to implement Decryption
    public static String Decryption(String cipherText, String key){
        StringBuilder actualText = new StringBuilder();

        int i = 0;
        while(i < cipherText.length()){
            char eachKey = key.charAt(i % key.length());
            int keyValue = (eachKey % 65);
            //char ch = (char)(((int) plainText.charAt(i) + keyValue) % 128);
            char ch = (char)(((int) cipherText.charAt(i) + 128 - keyValue) % 128);
            actualText.append(ch);
            i++;
        }
        return actualText.toString();
    }

    private static boolean validateKey(String key) {
        boolean isAllUppercase;
        boolean isValid = true;
        for(int i = 0; i< key.length(); i++){
            if (key.charAt(i) < 65 || key.charAt(i) > 90) {
                isValid = false;
                break;
            }
        }

        return key.length() <=4 && isValid;
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int option;
        do {
            System.out.println("Enter the option " +
                    "\n\t(1)Encrypt using Vigenere Cipher " +
                    "\n\t(2) Decrypt using Vigenere Cipher " +
                    "\n\t(3)Exit");
            option = input.nextInt();

            switch(option) {
                case 1:
                    System.out.println("Enter the string for encryption: ");
                    String plainText;
                    plainText = input.next();
                    plainText += input.nextLine();
                    System.out.println("Enter the key value using which each character in the plain text is shifted: ");
                    String key = input.nextLine();
                    if(validateKey(key)){
                        String cipherText = Encryption(plainText, key);
                        System.out.println("Encrypted data: " + cipherText);
                    }else{
                        System.out.println("Entered key should have a length of 1 to 3," +
                                "\n Each character in the key must be upper case letters (i.e., ‘A’-‘Z’)");
                    }
                    break;

                case 2:
                    System.out.println("Enter the string for decryption: ");
                    String encryptedText;
                    encryptedText=input.next();
                    encryptedText+= input.nextLine();
                    System.out.println("Enter the key value using which each character in the plain text is shifted: ");
                    String key1 = input.nextLine();
                    if(validateKey(key1)){
                        String decryptedText = Decryption(encryptedText, key1);
                        System.out.println("Decrypted data: " + decryptedText);
                    }else{
                        System.out.println("Entered key should have a length of 1 to 3," +
                                "\n Each character in the key must be upper case letters (i.e., ‘A’-‘Z’)");
                    }
                    break;

                default:
                    break;
            }
        }while(option!=3);
        input.close();
    }
}
