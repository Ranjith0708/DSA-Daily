package DataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet {
    public static void main(String[] args) {
        int[] num = {5,25,75};
        int[] res = twoSum(num,100);
        System.out.println(res[0]+" "+res[1]);
    }

    public static  int lengthOfLongestSubstring(String s) {
        String subString = "";
        int length=0;
        int l=0;
        int r=1;
        while(l<s.length() && r<=s.length() ){
            if(!subString.contains(s.substring(r-1,r))){
                subString = subString+s.substring(r-1,r);
                r++;
            }else{
                if(l==r){
                    r++;
                }else{
                    subString = subString.replace(s.substring(l,l+1),"");
                    l++;
                }
            }

            if(subString.length()>length){
                length = subString.length();
            }
        }
        return length;

    }

    public static int longestOnes(int[] nums, int k) {
        int l=0;
        int r=0;
        int zeroSum=0;
        int length=0;
        int maxLength=0;
        while (l<nums.length && r<nums.length){
            if(nums[r]==1){
                length = r-l+1 ;
                r++;
                if(length>maxLength){
                    maxLength = length;
                }
                continue;
            }
            if(nums[r]==0){
                if(zeroSum<k){
                    length = r-l+1;
                    r++;
                    zeroSum++;
                    if(length>maxLength){
                        maxLength = length;
                    }
                    continue;
                }
                if(zeroSum>=k){
                    if(nums[l]==1){
                        l++;
                    }else{
                        l++;
                        zeroSum--;
                    }
                }
            }

        }

        return maxLength;
    }

    public static int totalFruits(Integer[] arr) {
        int r=0;
        int l=0;
        int length=0;
        int maxLength=0;
        Map<Integer,Integer> basket = new HashMap<>();
        while(l<arr.length && r<arr.length){
            if(r>1){
                if(arr[r]==arr[r-1]){
                    System.out.println("check "+arr[r]);
                }
            }
            if(basket.size()<2){
                if(!basket.containsKey(arr[r])){
                    basket.put(arr[r],r);
                }
                length = r-l+1;
                maxLength = (length > maxLength) ? length : maxLength;
                r++;
                continue;
            }

            if(basket.containsKey(arr[r])){
                length = r-l+1;
                if(!(arr[r-1] == arr[r])){
                    basket.put(arr[r],r);
                }else{
                    System.out.println("prev "+arr[r]);
                }
                maxLength = (length > maxLength) ? length : maxLength;
                r++;
            }else{
                int fruit = arr[r-1];
                basket.entrySet().removeIf(entry -> entry.getValue() != basket.get(fruit));
                basket.put(arr[r],r);
                if(r-basket.get(fruit)>1){
                    System.out.println(arr[r]);
                    System.out.println("index "+basket.get(fruit)+" "+r);
                }
                l=basket.get(fruit);
                length = r-l+1;
                maxLength = (length > maxLength) ? length : maxLength;
                r++;
            }


        }
        return maxLength;
    }

     public static int longSubStr(String s, int k) {
        Map<String,Integer> characters = new HashMap<>();
        int l=0;
        int r=0;
        int length=0;
        int maxLength=0;
        while (l<s.length() && r<s.length()){
            if(characters.size()<k && !characters.containsKey(s.substring(r,r+1))){
                characters.put(s.substring(r,r+1),1);
                length = r-l+1;
                maxLength = (length > maxLength) ? length : maxLength;
                r++;
                continue;
            }
            if(characters.containsKey(s.substring(r,r+1))){
                characters.put(s.substring(r,r+1),characters.get(s.substring(r,r+1))+1);
                length = r-l+1;
                maxLength = (length > maxLength) ? length : maxLength;
                r++;
                continue;
            }else{
                characters.put(s.substring(l,l+1),characters.get(s.substring(l,l+1))-1);
                if(characters.get(s.substring(l,l+1))==0){
                    characters.remove(s.substring(l,l+1));
                }
                l=l+1;
            }

        }
        return maxLength;
    }

    public  static int[] twoSum(int[] numbers, int target) {
        int l=0;
        int r=1;
        int[] res = new int[2];
        while(l<numbers.length && r<numbers.length){
            int num = numbers[l]+numbers[r];
            if(num == target){
                res[0]=l+1;
                res[1]=r+1;
                return res;
            }
            if(r==numbers.length-1 && l!=numbers.length-2){
                l++;
                r=l+1;
                continue;
            }
            r++;
        }
        return res;
    }

    public static int characterReplacement(String s, int k) {
        int l=0;
        int r=0;
        return 0;
    }
}
