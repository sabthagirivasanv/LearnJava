package com;

class DoubleArray {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length % 2 == 1) return new int[0];

        int[] result = new int[changed.length / 2];
        int max = 0;
        for(int each : changed) max = Math.max(max, each);


        int[] count = new int[max + 1];

        for(int each : changed){
            count[each]++;
        }

        int pos = 0;
        for(int i = 0; i<= max/2; i++){
            if(i == 0){
                if(count[i] % 2 == 0){
                    for(int j = 1; j <= count[i] / 2; j++) {
                        result[pos++] = 0;
                    }
                    continue;
                }else{
                    return new int[0];
                }
            }

            if(count[i] > 0){
                if(count[i * 2] >= count[i]){
                    for(int j = 1; j <= count[i]; j++){
                        result[pos++] = i;
                        count[i*2]--;
                    }
                    count[i] = 0;
                }else{
                    System.out.println("i : " + i + " count : "  +count[i*2]+" "+ count[i]+ " empty");
                    return new int[0];
                }
            }
        }

        if(pos < changed.length/2) return new int[0];

        return result;
    }

    public static void main(String[] args) {
        DoubleArray da = new DoubleArray();
        for(int each : da.findOriginalArray(new int[]{0,0,3})){
            System.out.println(each);
        }
    }
}