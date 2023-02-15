package com;

public class LargestPalindrome {


    public int solution(String s) {
        byte[] map = new byte[58];
        for(int i = 0; i< s.length(); i++){
            map[(s.charAt(i) - 'A')]++;
        }
        int length = 0;
        for(int i = 0; i< map.length; i++){
            if(map[i] % 2 == 0){
                length += map[i];
            }
            if(map[i] % 2 == 1){
                if(length % 2 == 0){
                    length+= map[i];
                }else{
                    length+=map[i] - 1;
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        LargestPalindrome lp = new LargestPalindrome();
        lp.solution("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
    }

}
