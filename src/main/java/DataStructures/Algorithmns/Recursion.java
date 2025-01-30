package DataStructures.Algorithmns;

import java.util.Locale;

public class Recursion {
    public static void main(String[] args) {
//        String s = "tet";
//        System.out.println(s.substring(s.length()-1));
        int[] arr = {1,2,3,4,5,6,7,8,9,11,23,45,67,89,90};
        System.out.println(binarySearch(arr,5,0,arr.length-1));
//        int[] res = selectionStart(arr);
//        for(int i : res){
//            System.out.print(i+" ");
//        }
    }

    public static void sumOfNaturalNumbers(int num){
        int sum=0;
        for(int i=1;i<=num;i++){
            sum=sum+i;
        }
        System.out.println("Sum of natural number "+num+" is "+sum);
    }

    public static int sumOfNaturalNumUsingRecursion(int num){
        if(num==0 || num==1){
            return num;
        }
        int sum = num+sumOfNaturalNumUsingRecursion(num-1);
        return sum;
    }

    public static int factorial(int n){
        if(n==1){
            return n;
        }
        int factorial = n*factorial(n-1);
        return factorial;
    }

    public static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }

        int fib = fibonacci(n-1)+fibonacci(n-2);
        return fib;
    }
    public static int sumOfDigits(int n){
        if(n%10==n){
            return  n;
        }
        int sum = (n%10)+sumOfDigits(n/10);
        return sum;
    }

    public static String reverseTheString(String s){
        if(s.length()==1){
            return s;
        }
        String reverse = s.substring(s.length()-1)+reverseTheString(s.substring(0,s.length()-1));
        return reverse;
    }
    public static boolean palindromeOrNot(String s){
        if(s.length()<=1){
            return true;
        }
        if(!(s.substring(0,1).equalsIgnoreCase(s.substring(s.length()-1)))){
            return false;
        }
       return palindromeOrNot(s.substring(1,s.length()-1));

    }
    
    public static int powerOfNumber(int a,int b){
        if(b==0){
            return 1;
        }
        int power = a*powerOfNumber(a,b-1);
        return power;
    }

    public static int binarySearch(int[] arr,int target,int l,int r){
        int mid = (l+r)/2;
        if(arr[mid] == target){
            return mid;
        }
        if(l==r){
            return 0;
        }
        if(target>arr[mid]){
            l=mid+1;
        }
        if(target<arr[mid]){
            r=mid-1;
        }

        return binarySearch(arr,target,l,r);
    }

    public static int[] selectionStart(int[] arr){
        int l=0;
        int r=1;
        int minNumber = Integer.MAX_VALUE;
        int minIndex = 0;
        while(l<arr.length){
            if(arr[l]>arr[r]){
                if(minNumber>arr[r]){
                    minNumber = arr[r];
                    minIndex = r;
                }
            }
            if(r == arr.length-1){
//                r=r-1;
                int temp = arr[l];
                arr[l] = arr[minIndex];
                arr[minIndex] = temp;
                l=l+1;
                r=l+1;

            }else{
                r++;
            }
        }
        return arr;
    }

}
