package DataStructures;

public class Pattern {
    public static void main(String[] args) {
        pattern5(10);
    }
    
    static void pattern1(int n){
        for (int row = 1; row <= n; row++) {
            for (int col = n; col >=row ; col--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern2(int n){
        for (int row = 1; row <=n ; row++) {
            for (int col = 1; col <=row ; col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n){
        for (int row = 1; row <=n ; row++) {
            for (int col = n; col >=row ; col--) {
                System.out.print(n-col+1+" ");
            }
            System.out.println();
        }
    }

    static void pattern4(int n){
        int num = (2*n)-1;
        int reduce = 2;
        for (int row = 1; row <=num; row++) {
            int innerLoop = 0;
            if(row<=n){
                innerLoop = row;
            }else{
                innerLoop = n-(row-n);
            }
            for (int col = 1; col <= innerLoop; col++) {
                System.out.print("*"+" ");
            }
            System.out.println();
            reduce =reduce * 2;
        }
    }
    static void pattern5(int num){
        int rows = (2*num)-1;
        for (int row = 1; row <= rows ; row++) {
            int innerLoop = 0;
            if(row<=num){
                innerLoop = row;
            }else{
                innerLoop = num - (row-num);
            }
            for(int space =1;space<=(num-innerLoop);space++){
                System.out.print(" ");
            }
            for (int col = 1; col <=innerLoop ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}
