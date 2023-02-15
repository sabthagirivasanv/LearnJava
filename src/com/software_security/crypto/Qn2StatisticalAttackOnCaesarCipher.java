package com.software_security.crypto;

import java.util.*;
import java.util.stream.Collectors;

public class Qn2StatisticalAttackOnCaesarCipher {

    public enum AlphabetFrequency{
        A(0.080), B(0.015), C(0.030), D(0.040), E(0.130), F(0.020), G(0.015),H(0.060), I(0.065),
            J(0.005), K(0.005), L(0.035), M(0.030), N(0.070), O(0.080), P(0.020), Q(0.002),
            R(0.065), S(0.060), T(0.090), U(0.030), V(0.010), W(0.015), X(0.005), Y(0.020), Z(0.002);
        private final double frequency;

        AlphabetFrequency(double frequency) {
            this.frequency = frequency;
        }

        public double getFrequency() {
            return frequency;
        }
    }

    private static Map<Integer, Double> findCorrelations(String cipherText) {
        Map<Character, Double> cipherFrequency = findFrequencyOfText(cipherText);
        Map<Integer, Double> keyToCorrelation = new HashMap<>();
        for(int i = 0; i < 26; i++){
            double correlationValue = 0D;
            for(Character eachChar : cipherFrequency.keySet()){
                String potentialChar = String.valueOf((char)(((int) eachChar + 26 - i - 65)% 26 + 65));
                correlationValue += cipherFrequency.get(eachChar) * AlphabetFrequency.valueOf(potentialChar).getFrequency();
            }
            keyToCorrelation.put(i, correlationValue);
        }
        return keyToCorrelation;
    }

    private static Map<Character, Double> findFrequencyOfText(String cipherText) {
        Map<Character, Double> resultMap = new HashMap<>();
        cipherText = cipherText.toUpperCase();
        cipherText = cipherText.replaceAll("\\s", "");

        int totalCount = cipherText.length();
        Map<Character, Integer> eachCharCount = new HashMap<>();
        for(int i = 0; i < cipherText.length(); i++){
            char key = cipherText.charAt(i);
            if(key >=65 && key <=90){
                eachCharCount.put(key, eachCharCount.getOrDefault(key, 0)+1);
            }
        }

        for(Character eachKey : eachCharCount.keySet()){
            Integer count = eachCharCount.getOrDefault(eachKey, 0);
            double roundOff = Math.round(((double) count / (double) totalCount)*100)/100D;
            resultMap.put(eachKey,roundOff);
        }
        return resultMap;
    }

    public static void main(String[] args) {
        System.out.println("Please enter your cipher text...\n");
        Scanner input = new Scanner(System.in);
        String cipherText = input.nextLine();
        Map<Integer, Double> keyToCorrelation = findCorrelations(cipherText);
        printBestDecryption(cipherText, keyToCorrelation, 5);
    }

    private static void printBestDecryption(String cipherText, Map<Integer, Double> keyToCorrelation, int topN) {
        Map<Double, List<Integer>> correlationToKey = new HashMap<>();
        for(Integer  key : keyToCorrelation.keySet()){
            Double correlation = keyToCorrelation.get(key);
            List<Integer> keyList = correlationToKey.getOrDefault(correlation, new ArrayList<>());
            keyList.add(key);
            correlationToKey.put(correlation, keyList);
        }

        List<Double> sortedCorrelations = keyToCorrelation.values().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        for(int i = 0; i < topN; i++){
            Double correlation = sortedCorrelations.get(i);
            List<Integer> keys = correlationToKey.get(correlation);
            for (Integer key : keys) {
                System.out.println("key : "+key + " Correlation : "+ correlation);
                System.out.println("\t\tPlain Text : "+ Qn1CaesarCipher.Decryption(cipherText, key)+ "\n");
            }
        }
    }
}
