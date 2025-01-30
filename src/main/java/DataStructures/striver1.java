package DataStructures;

import java.util.*;

public class striver1 {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,6,1};
        int k = 3;
//        System.out.println(maxScore(nums,3));
//        String name = "hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//        String name = "pwwkew";
//        System.out.println(name.substring(0,55));
//        name = name.replace("k","");
//        System.out.println();
//        System.out.println(name);
//        System.out.println(name.length());
//        System.out.println((longSubStr(name)));
        Map<Integer,Integer> map = new HashMap<>();
//        int[] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
//        System.out.println(longOnes0(arr,3));
        map.put(1,3);
        map.put(2,2);
//        System.out.println(map.get(1));
        int l=2;
        String s = "ewrt";
        System.out.println(s.substring(l,l+1));
//        System.out.println(s.replace(s.substring(0,1),""));
//        System.out.println("rate".contains("ranj".substring(0,1)));
////        String n = "abcabc";
//        System.out.println(Math.abs(-1));
//        int num = map.values().stream().min(Integer::compareTo);
//        Set set = map.keySet();
//        int min = (int) Collections.min(set);
//        System.out.println;
//        System.out.println((n.contains("b")));
//        System.out.println(map.get(1));
//        map.put(1,"e");
//        System.out.println(map.get(1));

    }

    public static int longestSubstring(String s){
//        s = s.toLowerCase();
        int maxLength = 0;
        int l=0;
        int r = 1;
        int start = l;
        String subStr = "";
        while (start<s.length()){
            if((r<=s.length()) &&!subStr.contains(s.substring(l,r))){
                subStr+=s.substring(l,r);
                l++;
                r++;
            }else{
                maxLength = Math.max(maxLength,subStr.length());
                subStr = "";
                l = start+1;
                r = l+1;
                start = l;
            }
        }
        return maxLength;
    }

    public static int maxSum(int[] arr,int k){
        int l = 0;
        int r = k-1;
        int maxSum = 0;
        int sum = 0;
        for(int i=l;i<=r;i++){
            sum+=arr[i];
        }
        while(r<arr.length-1){
            sum-=arr[l];
            r++;
            l++;
            sum+=arr[r];
            maxSum = Math.max(maxSum,sum);

        }
        return maxSum;
    }

    public static int[] longestSubArray(int[] arr,int k){
        int maxSum = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            int length = 0;
            for (int j = i; j < arr.length; j++) {
                sum+=arr[j];
                length+=1;
                if(sum<=k){
                    maxLength = Math.max(maxLength,j-i+1);
                   if(maxLength<=(j-i+1)) {
                       maxSum = Math.max(sum,maxSum);
                   }
                }else{
                    break;
                }

            }
        }
        int[] r = new int[2];
        r[0] = maxLength;
        r[1] = maxSum;
        return r;
    }

    public static  int longestSubArrayBySlider(int[] arr,int k){
        int l=0;
        int r=0;
        int sum = 0;
        int maxLength = 0;
        while(l<=r && r<arr.length){
            sum+=arr[r];
            if(sum<=k){
                maxLength = Math.max(maxLength,r-l+1);
                r++;
            }else{
                sum-=arr[l];
                l++;
            }

        }
        return maxLength;

    }

    public static int shortestSubarray(int[] nums, int k) {
        int l=0;
        int r=0;
        int maxLength=-1;
        int sum = 0;
        while(l<=r && r<nums.length){
            sum+=nums[r];
           if(sum>k){
               if(l==r){
                   sum = 0;
                   l++;
                   r++;
                   continue;
               }
           }

           if(sum<=k){
               if(sum == k){
                   maxLength = Math.max(maxLength,r-l+1);
               }
               r++;
           }else{
               sum-=nums[l];
               l++;
           }

        }
        return maxLength;

    }

    public static int maxScore(int[] cardPoints, int k) {
        int l = 0;
        int r = k-1;
        int sum = 0;
        int maxSum = 0; //{1,2,3,4,5,6,1}
        for (int i = l; i<=r; i++) {
            sum+=cardPoints[i];
        }
        maxSum = Math.max(sum,maxSum);
        l = cardPoints.length-1;
        while (r>=0){
//            System.out.println(r);
            if(r>=0){
                sum = sum - cardPoints[r] + cardPoints[l];
            }else{
                sum += cardPoints[l];
            }
            maxSum = Math.max(sum,maxSum);
            System.out.println(l+" "+r);
            r--;
            l--;
        }
        return maxSum;
    }

    public static int subString(String s){
        HashMap<String,Integer> map = new HashMap<>();
        int r =0;
        int l =0;
        int maxLength = 0;
        int length = 0;
        while (r<s.length()){

            if(!map.containsKey(s.substring(r,r+1))){
                map.put(s.substring(r,r+1),r);
                length++;
                r++;
            }else{
                if(l>map.get(s.substring(r,r+1))){
                    map.put(s.substring(r,r+1),r);
                    length++;
                    r++;
                }else{
                    l = map.get(s.substring(r,r+1))+1;
                    map.put(s.substring(r,r+1),l);
                    length++;
                    length=length-l;
                    r++;
                }
            }
            maxLength = Math.max(length,maxLength);

        }

        return maxLength;
    }

    public static int longSubStr(String s){
        int l=0;
        int r=0;
        Map<String,Integer>map = new HashMap<>();
        String sub = "";
        int maxLength = 0;
        while (r<s.length()){
            String str = s.substring(r,r+1);
            if(! map.containsKey(str)){
                map.put(str,r);
                if((r-l+1)>maxLength){
                    System.out.println(l+" "+r);
                    sub = s.substring(l,r+1);
                }
                maxLength = Math.max(r-l+1,maxLength);
                r++;
            }else{
                int val = map.get(str);
                if(val<l){
                    map.put(str,r);
                    if((r-l+1)>maxLength){
                        System.out.println(l+" "+r);
                        sub = s.substring(l,r+1);
                    }
                    maxLength = Math.max(r-l+1,maxLength);
                    r++;
                }else{
                    l = val+1;
                    if((r-l+1)>maxLength){
                        System.out.println(l+" "+r);
                        sub = s.substring(l,r+1);
                    }
                    maxLength = Math.max(r-l+1,maxLength);
                    map.put(str,r);
                    r++;
                }
            }
        }
        System.out.println(sub);
        return maxLength;
    }

    public static int longOnes0(int[] nums,int k){
        int l=0;
        int r=0;
        int zeros = 0;
        int maxLength=0;
        while (r<nums.length){
            if(nums[r]==0){
                zeros++;
            }
            if(zeros>k){
                if(nums[l]==0){
                    zeros--;
                }
                l++;
            }
            if(zeros<=k){
                maxLength = Math.max(maxLength,r-l+1);
            }
            r++;

        }
        return maxLength;
    }
    public static int longOnes(int[] nums,int k){
        int l=0;
        int r=0;
        int maxLength=0;
        int zeros=0;
        while(r<nums.length){
            if(nums[r]==1){
                maxLength = Math.max(maxLength,r-l+1);
                r++;
            }else{
                if(zeros<k){
                    maxLength = Math.max(maxLength,r-l+1);
                    zeros++;
                    r++;
                }else{
                    if(nums[l]==1){
                        l=l+1;
                    }else{
                        if((r-l+1)==k){
                            r++;
                        }else{
                            l=l+1;
                            zeros--;
                        }
                    }
                }
            }
        }
        return maxLength;
    }

    public static int maxSubString(String s,String k){
        int numOfSubStr = 0;
        String sub = "";
        for(int i=0;i<s.length();i++){
            sub = s.substring(i,i+1);
            for(int j=i;j<s.length();j++){
                sub+=s.substring(j,j+1);
                if(sub.length()>=k.length()){
                    for (int l = 0; l < k.length(); l++) {
                        if(sub.contains(k.substring(l,l+1))) {
                            if(l==k.length()-1){
                                numOfSubStr++;
                                break;
                            }
                        }else{
                            break;
                        }
                    }
                }
            }
            sub = "";

        }
        return numOfSubStr;
    }

    public  static int numberOfSubstrings(String s) {
        int numberOfSubStr=0;
        int l=0;
        int r=0;
        String subStr="";
        List<String> subStrings = new ArrayList<>();
        while(r<s.length()){
            if(l==0){
                subStr+=s.substring(r,r+1);
            }
            if(subStr.length()<3){
                r++;
                continue;
            }
            if(subStr.length()==3){
                if(subStr.contains("a")&&subStr.contains("b")&&subStr.contains("c")) {
                    subStrings.add(subStr);
                }
                r++;
            }
            if(subStr.length()>3){
                if(subStr.contains("a")&&subStr.contains("b")&&subStr.contains("c")&&l==0){
                    subStrings.add(subStr);
                    r++;
                }
                if(l!=0 && (r-l+1)>=3){
                    String tmpSubStr = subStr.substring(l,r+1);
                    if((r-l+1)>3){
                        if(tmpSubStr.contains("a")&&tmpSubStr.contains("b")&&tmpSubStr.contains("c")){
                            subStrings.add(tmpSubStr);
                        }
                        l++;
                    }else{
                        if(tmpSubStr.contains("a")&&tmpSubStr.contains("b")&&tmpSubStr.contains("c")){
                            subStrings.add(tmpSubStr);
                        }
                        l=0;
                        r++;
                    }
                }
            }
        }
        return subStrings.size();
    }

    public int numberOfSubstrings1(String s) {
        int numberOfSubStr=0;
        int l=0;
        int r=0;
        String subStr="";
        List<String> subStrings = new ArrayList<>();
        while(r<s.length()){
            subStr+=s.substring(r,r+1);
            if(subStr.length()<3){
                r++;
            }
            if(subStr.length()==3){
                if(subStr.contains("a")&&subStr.contains("b")&&subStr.contains("c")){
                    subStrings.add(subStr);
                }
                l=0;
                r++;
            }
            if(subStr.length()>3){
                if(subStr.contains("a")&&subStr.contains("b")&&subStr.contains("c")){
                    subStrings.add(subStr);
                }
                l++;
            }
        }
        return subStrings.size();
    }

    public static int jump() {
        int[] nums = {2,1};
        int l=0;
        int next_jump=0;
        int num_of_jumps=0;
        int jump_value=0;
        while(l<nums.length-1){
            int current_jump_dis = l+nums[l];
            l++;
            if(current_jump_dis==nums.length-1){
                System.out.println("inside");
                return num_of_jumps+1;
            }
            while(l<=current_jump_dis){
                if(jump_value<(l+nums[l])){
                    jump_value=l+nums[l];
                    next_jump=l;
                }
                l++;
            }
            l=next_jump;
            num_of_jumps++;
        }
        return num_of_jumps;

    }


}
