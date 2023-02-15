package com.software_security.crypto;
import java.util.Scanner;
public class Qn1CaesarCipher {

    //Method to implement Encryption
    public static String Encryption(String plainText, int key){
        String cipherText = "";

        int i = 0;
        while(i < plainText.length()){
            if(!Character.isLetter(plainText.charAt(i))){
                cipherText += plainText.charAt(i);
            }
            else if(Character.isUpperCase(plainText.charAt(i))){
                char ch = (char)(((int) plainText.charAt(i) + key - 65) % 26 + 65);
                cipherText += ch;
            }
            else{
                char ch = (char)(((int) plainText.charAt(i) + key - 97) % 26 + 97);
                cipherText += ch;
            }
            i++;
        }
        return cipherText;
    }
    //Method to implement Decryption
    public static String Decryption(String cipherText, int key){
        String actualText = "";

        int i = 0;
        while(i < cipherText.length()){
            if(!Character.isLetter(cipherText.charAt(i))){
                actualText += cipherText.charAt(i);
            }
            else if(Character.isUpperCase(cipherText.charAt(i))){
                char ch = (char)(((int) cipherText.charAt(i) + 26 - key - 65)% 26 + 65);
                actualText += ch;
            }
            else{
                char ch = (char)(((int) cipherText.charAt(i) + 26 - key - 97) % 26 + 97);
                actualText += ch;
            }
            i++;
        }
        return actualText;
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int option;
        do {
            System.out.println("Enter the option (1)Encrypt using Caesar Cipher (2) Decrypt using Caesar Cipher (3)Exit");
            option = input.nextInt();

            switch(option) {
                case 1:
                    System.out.println("Enter the string for encryption: ");
                    String plainText;
                    plainText = input.next();
                    plainText += input.nextLine();
                    System.out.println("Enter the key value using which each character in the plain text is shifted: ");
                    int key = input.nextInt();
                    String cipherText = Encryption(plainText, key);
                    System.out.println("Encrypted data: " + cipherText);
                    break;

                case 2:
                    System.out.println("Enter the string for decryption: ");
                    String encryptedText;
                    encryptedText=input.next();
                    encryptedText+= input.nextLine();
                    System.out.println("Enter the key value using which each character in the plain text is shifted: ");
                    int key1 = input.nextInt();
                    String decryptedText = Decryption(encryptedText, key1);
                    System.out.println("Decrypted data: " + decryptedText);
                    break;

                default:
                    break;
            }
        }while(option!=3);
        input.close();
    }
}
