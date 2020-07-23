package pnv;

import java.util.Scanner;

public class PeaksAndValleys {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        try{
            System.out.println("Enter array elements (space separated)...");
            String input = scanner.nextLine();

            String[] userInputArray = input.split(" ");
            int[] arr = new int[userInputArray.length];

            for(int i = 0; i < userInputArray.length; i++){
                arr[i] = Integer.parseInt(userInputArray[i]);
            }

            System.out.println("Result:-> " + solve(arr));
        }catch(NumberFormatException exception){
            System.out.println("Invalid Input");
        }

    }

    /**
     * Method to return number of peaks and valleys
     * Complexity O(N) -> N being the number of elements in the array
     * @param arr
     * @return
     */
    public static int solve(int[] arr){

        // Check whether array is empty
        if(arr.length == 0){
            return 0;
        }

        // check whether all the elements in the array are same O(N)
        int first = arr[0];
        int i = 1;
        while(i < arr.length){
            if(arr[i] != first){
                break;
            }
            i++;
        }

        if(i == arr.length){
            return 1;
        }


        boolean isPeak = false;

        // check whether current element is a peak or a valley.
        // O(N) in worst case(if only last element in different)
        for(int j = 0; j < arr.length - 1; j++){
            if(arr[j] != arr[j+1]){
                isPeak = arr[j] > arr[j+1];
                break;
            }
        }

        // at least one castle will be there
        int castleCount = 1;

        // Count number of peaks and valleys O(N)
        for(int j = 0; j < arr.length - 1; j++){
           if(isPeak && arr[j] > arr[j+1]) {
               castleCount++;
               isPeak = !isPeak;
           }else{
               if(arr[j] < arr[j+1]){
                   castleCount++;
                   isPeak = !isPeak;
               }
            }
        }

        // return result
        return castleCount;

    }
}
