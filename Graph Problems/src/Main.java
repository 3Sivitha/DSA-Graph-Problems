import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//monkeys
        int k=sc.nextInt();//no. of eatable bananas
        int j=sc.nextInt();//no. of eatable peanuts
        int m=sc.nextInt();//bananas
        int p=sc.nextInt();//peanuts
        if(k<=0 || j<=0 || n<=0 || m<=0 || p<=0){
            System.out.println("Invalid Input");
            return;
        }
        int v=(m/k)+(p/j);
        int res=n-v;
        if(res<0){
            System.out.println(0);
        }
        else
            System.out.println(res);
    }
}