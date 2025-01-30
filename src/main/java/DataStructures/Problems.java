package DataStructures;

import java.sql.SQLOutput;
import java.util.*;

public class Problems {
    public static void main(String[] args) {
//        System.out.println("------START-------");
//        String[][] arr = new String[5][5];
//        for(int i=0;i< arr.length;i++){
//            for (int j=0;j<arr[i].length;j++){
//                arr[i][j] = "_";
//            }
//        }
//        fallBall1(arr);
//        System.out.println((51/4)
//        int[] nums = {1,1,1,1,1};
//        int res = subarraySum(nums,2);
//        System.out.println(res);
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
//        System.out.println(maximumSubarraySum(nums,3));
//        System.out.println(sumOfSubArr(nums,14));
//        int nums[] = {-1};
//        System.out.println(findMaxAverage(nums,1));
//        int nums[] = {4,1,-1,6,5};
        int nums[] = {1,5,9,1,5,9};
//        System.out.println(containsNearbyAlmostDuplicate(nums,2,3));
//        int i =0000;
        int[] defuse=new int[nums.length];
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        System.out.println(map.get(121));
//        System.out.println(nums[-1]);
//        System.out.println(containsNearbyAlmostDuplicate(nums,3,1));
    }
    public static void fallingBalls(String[][] arr){
        boolean start = true;
        int indexStart = arr.length-1;
        while (start){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter index : ");
            int index = sc.nextInt();
            if(index>0){
                for(int i=indexStart;i>=0 ;i--){
                    System.out.println("index "+i);
                    int mid = (arr[i].length)/2;
                    System.out.println("mid "+mid);
                    for (int j=arr[i].length-1;j>=0;j--){
                        if(arr[i][mid] == "0"){
                            if(arr[i][mid+1]!="0"){
                                if(i+1<= (arr.length-1)){
                                    if(arr[i+1][mid+1] !="0"){
                                        arr[i+1][mid+1] = "0";
                                    }else{
                                        arr[i][mid+1] = "0";
                                    }
                                }else if(i == arr.length-1){
                                    arr[i][mid+1] = "0";
                                }
                                break;
                            }else if(arr[i][mid-1]!= "0"){
                                if(i+1<(arr.length)){
                                    if(!(arr[i+1][mid-1]).equalsIgnoreCase("0")){
                                        arr[i+1][mid-1] = "0";
                                    }else{
//                                        if()
                                        arr[i+1][mid-1] = "0";
                                    }
                                }else if(i == arr.length-1){
                                    arr[i][mid-1] = "0";
                                }

                                break;
                            }else{
                                if(i-1>=0){
                                    i=i-1;
                                    indexStart = i;
                                    System.out.println("Assigned Value : "+indexStart);
                                    continue;
                                }else{
                                    System.out.println("All indexes filled");
                                    start = false;
                                }
                            }
                        }else{
                            arr[i][mid] = "0";
                            break;
                        }
                    }
                    break;
                }
                for(int k=0;k< arr.length;k++){
                    for (int l=0;l<arr[k].length;l++){
                        System.out.print(arr[k][l]+" ");
                    }
                    System.out.println();
                }
                continue;
            }else{
                start = false;
                System.out.println("------END------");
            }
        }
    }


    public static void fallBall(String[][] arr){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter input : ");
        int index = sc.nextInt();
        while (index<10){
            boolean outerLoop = false;
            for (int row = arr.length-1; row >= 0; row--) {
                for (int col = 0; col < arr[row].length; col++) {
                    int mid = (arr[row].length)/2;
                    if(arr[row][mid].equalsIgnoreCase("_")){
                        arr[row][mid] = "o";
                        outerLoop = true;
                        break;
                    }else if(arr[row][mid+1].equalsIgnoreCase("_")){
                        arr[row][mid+1] = "o";
                        outerLoop = true;
                        break;
                    }else if(arr[row][mid-1].equalsIgnoreCase("_")){
                        if(row+1< arr.length){
                            mid = mid-1;
                            if(arr[row+1][mid-1].equalsIgnoreCase("_")){
                                arr[row+1][mid-1] = "o";
                            }else{
                                mid = mid+1;
                                arr[row][mid-1] = "o";
                            }
                        }else{
                            arr[row][mid-1] = "o";
                        }
                        outerLoop = true;
                        break;
                    }else {
                        break;
                    }
                }
                if(outerLoop){
                    break;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.print("Enter input : ");
             index = sc.nextInt();

        }

    }

    static void fallBall1(String[][] arr){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter num : ");
        int input = sc.nextInt();
        while (input<10){
            for (int row = arr.length-1; row >=0 ; row--) {
                boolean outerLoop = false;
                for (int col = 0; col < arr[row].length; col++) {
                    int pointer = arr[row].length/2;
                    if(arr[row][pointer].equalsIgnoreCase("_")){
                        if(row+1< arr.length){
                            if(arr[row+1][pointer-1].equalsIgnoreCase("o")){
                                arr[row][pointer] = "o";
                                outerLoop = true;
                                break;
                            }else if(arr[row+1][pointer-1].equalsIgnoreCase("_")){
                                arr[row+1][pointer-1] = "o";
                                outerLoop = true;
                                break;
                            }

                        }else{
                            arr[row][pointer] = "o";
                            outerLoop = true;
                            break;
                        }
                    }else{
                        pointer = pointer+1;
                        while (pointer<arr[row].length){
                            if(arr[row][pointer].equalsIgnoreCase("_")){
                                arr[row][pointer] = "o";
                                outerLoop = true;
                                break;
                            }else{
                                pointer = pointer+1;
                            }
                        }
                        if(pointer>=arr[row].length){
                            pointer = (arr[row].length/2)-1;
                            if(row+1<arr.length){
                                while(pointer>=1){
                                    if(arr[row][pointer].equalsIgnoreCase("_")){
                                        if(arr[row+1][pointer-1].equalsIgnoreCase("o")){
                                            arr[row][pointer] = "o";
                                            outerLoop = true;
                                            break;
                                        }else{
                                            arr[row+1][pointer-1] = "o";
                                            outerLoop = true;
                                            break;
                                        }
                                    }
                                    pointer = pointer-1;

                                }
                                if(row==0 && (pointer-1)<=0){
                                    arr[row][pointer] = "o";
                                    outerLoop = true;
                                    break;
                                }
                            }else if( arr[row][pointer].equalsIgnoreCase("_")){
                                arr[row][pointer] = "o";
                                outerLoop = true;
                                break;
                            }else{
                                break;
                            }
                        }
                    }
                    if(outerLoop){
                        break;
                    }
                }
                if(outerLoop){
                    break;
                }
            }

            for(int i=0;i< arr.length;i++){
                for (int j=0;j<arr[i].length;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.print("Enter num : ");
            input = sc.nextInt();
        }
    }
    public static long maximumSubarraySum2(int nums[],int k){
        long currSum = 0;
        long ans = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < k; i++) {
            currSum += (long)nums[i];
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);

        }
        if(map.size() == k) {
            ans = currSum;
        }

        int left = 0;
        for(int i = k; i < n; i++) {
            currSum -= (long)nums[left];
            currSum += (long)nums[i];
            map.put(nums[left], map.get(nums[left]) - 1);
            if(map.get(nums[left]) == 0) {
                map.remove(nums[left]);
            }
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            if(map.size() == k) {
                ans = Math.max(currSum, ans);
            }
            left++;
        }
        return ans;
    }


    public static long maximumSubarraySum(int[] nums, int k) {
        int start = 0;
        int end = k-1;
        long max = 0;
        while (end<nums.length){
          int[] tempArr = Arrays.copyOfRange(nums,start,end+1);
          Arrays.sort(tempArr);
            System.out.println();
            long temp = 0;
            for(int i=0;i<tempArr.length;i++){
                if((i-1)>=0 && (i+1)<=tempArr.length-1){
                    if(tempArr[i]==tempArr[i+1] || tempArr[i]==tempArr[i-1]){
                        temp = 0;
                        break;
                    }else{
                        temp+=tempArr[i];
                    }
                }else{
                    temp+=tempArr[i];
                }
            }
            if(temp>max){
                max = temp;
            }
            start = start+1;
            end = end+1;
        }

        return max;

    }

    public static long maximumSubarraySum1(int[] nums, int k) {
        int start = 0;
        int end = k-1;
        long max = 0;
        while (end<nums.length){
            long temp = 0;
            boolean loop = true;
            for(int i=start;i<=end;i++){
                int tem = nums[i];
                for(int j = start;j<=end;j++){
                    if(nums[i] == nums[j] && i!=j){
                        loop = false;
                        break;
                    }
                }
                if(!loop){
                    break;
                }
            }
            if(loop){
                for(int i=start;i<=end;i++){
                    temp+=nums[i];
                }
            }
            if(temp>max){
                max = temp;
            }
            start = start+1;
            end = end+1;
        }

        return max;

    }

    public static int maxSubArrayOfGivenLength(int[] arr,int k){
        int max_sum = 0;
        int start = 0;
        int end  = k-1;
        for (int i = start; i <= end ; i++) {
            max_sum+=arr[i];
        }
        while(end<arr.length){
            int temp = max_sum;
            temp = (temp-(arr[start]));
            start = start+1;
            end = end+1;
            if(end<arr.length){
                System.out.println(start+" "+end);
                temp = (temp  + arr[end]);
                if(temp>max_sum){
                    System.out.println("inside "+start+" "+end);
                    max_sum = temp;
                }
            }
        }
//        System.out.println(start+" "+end);
        return max_sum;
    }

    public static int subarraySum(int[] nums, int k) {
        int numOfSubArraysEqualsK = 0;
        int previousSum = 0;
        int leftIndex = 0;
        int rightIndex = 1;

//        if(nums.length==1){
//            if(nums[0]==k){
//                return numOfSubArraysEqualsK+1;
//            }else{
//                return numOfSubArraysEqualsK;
//            }
//        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]==k){
                numOfSubArraysEqualsK++;
            }
            nums[i]=nums[i]+previousSum;
            previousSum = nums[i];
        }

        while(leftIndex<nums.length && rightIndex<nums.length){
            if(leftIndex ==0){
                if(nums[rightIndex]==k){
                    numOfSubArraysEqualsK++;
                }
            }else{
                if(nums[rightIndex]-nums[leftIndex-1]==k){
                    numOfSubArraysEqualsK++;
                }
            }

            if(rightIndex==nums.length-1){
                leftIndex++;
                rightIndex=leftIndex+1;
            }else{
                rightIndex++;
            }

        }

        return numOfSubArraysEqualsK;

    }




    public static double findMaxAverage(int[] nums, int k) {
        int r=k-1;
        int l=0;
        int sum=0;
        double maxAvg=-1e5;
        for(int i=0;i<k;i++){
            sum = sum+nums[i];
        }
        while(l<=nums.length-1){
            double avg=0;

            if(l==0){
                avg=sum/k;
            }else{
                sum = sum-nums[l-1]+nums[r];
                avg=sum/k;
            }
            if(avg>maxAvg){
                maxAvg=avg;
            }
//
//            if((nums.length-l)==k){
//                l++;
//                r=0;
//            }else{
//                l++;
//                r++;
//            }
            l++;
            r++;

        }

        return (double)maxAvg;


    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int l=0;
        int r=1;
        while(l!=r  && l<nums.length-1 && r<nums.length){
            System.out.println("index "+l+" "+r);
            if(Math.abs(l-r)<=indexDiff && Math.abs(nums[l] - nums[r]) <= valueDiff){
                return true;
            }
            if(Math.abs(l-r)==indexDiff){
                l++;
                r=l+1;
            }
            if(r==nums.length-1){
                if(l!=(r-1)){
//                    System.out.println("hi");
                    l++;
                    r=l+1;
                    continue;
                }
            }
            r++;

        }
        return false;
    }
}