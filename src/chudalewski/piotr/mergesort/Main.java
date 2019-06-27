package chudalewski.piotr.mergesort;

public class Main {

    public static void main(String[] args) {
	    int[] sortArray = {20, 35, -15, 7, 55, 1, -22};

        mergeSort(sortArray,0,sortArray.length);

	    for (int i=0; i< sortArray.length;i++) {
            System.out.println(sortArray[i]);
        }


    }


    public static void mergeSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(input, start, mid); // Left array
        mergeSort(input, mid, end); // Right array
        merge(input, start, mid, end);

    }

    public static void merge(int[] input, int start, int mid, int end) {
        if(input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid ;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input,i,input,start+tempIndex,mid-i);
        System.arraycopy(temp, 0, input, start, tempIndex);

    }
}
