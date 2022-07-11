package learningJava;
import java.util.*;

public class TicTacToe {
    public static void grid(char[][] a){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if(a[0][0]==(char)0){
            System.out.print(" " + " |");
        }
        else{
            System.out.print(a[0][0]+" |");
        }
        if(a[0][1]==(char)0){
            System.out.print(" "+" " + " |");
        }
        else{
            System.out.print(" "+a[0][1] + " |");
        }
        if(a[0][2]==(char)0){
            System.out.print(" " +" ");
        }
        else{
            System.out.print(" " +a[0][2]);
        }
        System.out.println();
        System.out.print("----------");
        System.out.println();
        if(a[1][0]==(char)0){
            System.out.print(" " +" |");
        }
        else{
            System.out.print(a[1][0]+" |");
        }
        if(a[1][1]==(char)0){
            System.out.print(" "+" " + " |");
        }
        else{
            System.out.print(" "+a[1][1] + " |");
        }
        if(a[1][2]==(char)0){
            System.out.print(" " +" ");
        }
        else{
            System.out.print(" " +a[1][2]);
        }
        System.out.println();
        System.out.print("----------");
        System.out.println();
        if(a[2][0] == (char)0){
            System.out.print(" " +" |");
        }
        else{
            System.out.print(a[2][0]+" |");
        }
        if(a[2][1]==(char)0){
            System.out.print(" "+" " + " |");
        }
        else{
            System.out.print(" "+a[2][1] + " |");
        }
        if(a[2][2]==(char)0){
            System.out.print(" " +" ");
        }
        else{
            System.out.print(" " +a[2][2]);
        }
        System.out.println();

    }
    public static boolean check(char[][] a, char c){
        if(a[1][1] == c&&a[0][2]==c&&a[2][0] == c){
            return true;
        }
        else if(a[0][0]==c&&a[1][1]==c&&a[2][2]==c){
            return true;
        }
        else if(a[0][1]==c&&a[1][1]==c&&a[2][1]==c){
            return true;
        }
        else if(a[1][0]==c&&a[1][1]==c&&a[1][2]==c){
            return true;
        }
        else if(a[0][1]==c&&a[1][0]==c&&a[2][0]==c){
            return true;
        }
        else if(a[2][0]==c&&a[2][1]==c&&a[2][2]==c){
            return true;
        }
        else if(a[0][2]==c&&a[1][2]==c&&a[2][2]==c){
            return true;
        }
        else if(a[0][0]==c&&a[0][1]==c&&a[0][2]==c){
            return true;
        }
        return false;

    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 = s.next();
        String s2 = s.next();
        char[][] tictoe = new char[3][3];
        HashMap<Integer,int[]> m = new HashMap<>();
        int t = 1;
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                int[] arr = new int[2];
                arr[0] = i;
                arr[1] = j;
                m.put(t,arr);
                t++;
            }
        }
        boolean flag1 = true;
        int k = -2;
        int h = 1;
        while(k==-2&&h<=9){

            if(flag1){
                System.out.println(s1 + " turn: " + "Enter the cell number(1-9)");
                int n = s.nextInt();
                if((n<1||n>9)|| (tictoe[(m.get(n))[0]][(m.get(n))[1]]=='x'|| tictoe[(m.get(n))[0]][(m.get(n))[1]]=='o')){
                    while ((n<1||n>9)|| (tictoe[(m.get(n))[0]][(m.get(n))[1]]=='x'|| tictoe[(m.get(n))[0]][(m.get(n))[1]]=='o')){
                        n= s.nextInt();
                    }
                }
                tictoe[(m.get(n))[0]][(m.get(n))[1]] = 'o';
                grid(tictoe);
                if(check(tictoe,'o')) {
                    k = 1;
                }
            }

            else{
                System.out.println(s2 + " turn: " + "Enter the cell number(1-9)");
                int n = s.nextInt();
                if((n<1||n>9)|| (tictoe[(m.get(n))[0]][(m.get(n))[1]]=='x'|| tictoe[(m.get(n))[0]][(m.get(n))[1]]=='o')){
                    while ((n<1||n>9)|| (tictoe[(m.get(n))[0]][(m.get(n))[1]]=='x'|| tictoe[(m.get(n))[0]][(m.get(n))[1]]=='o')){
                        n= s.nextInt();
                    }
                }
                tictoe[(m.get(n))[0]][(m.get(n))[1]] = 'x';
                grid(tictoe);
                if(check(tictoe,'x')){
                    k = 2;
                }
            }
            flag1 = !flag1;
            h++;
        }
        if(k==1){
            System.out.println();
            System.out.println(s1 + " wins");
        }
        else if(k==2){
            System.out.println();
            System.out.println(s2 + " wins");
        }
        else{
            System.out.println();
            System.out.println("Draw");
        }
    }
}
