package org.example.java.interview;

public class SecondLargest {
    public static void main(String[] args) {
        int[] intArray = {10,8,3,2,9};
        int largest = 0;
        int secondLargest = 0;

        for(int i=0; i<intArray.length; i++){
            for (int j=1; j<intArray.length-1; j++){
                if(intArray[i]>intArray[j]){
                    largest=intArray[i];
                    secondLargest=intArray[j];
                }else{
                    largest=intArray[j];
                    secondLargest=intArray[i];
                }
            }

        }

        System.out.println(largest);
        System.out.println(secondLargest);
    }
}
