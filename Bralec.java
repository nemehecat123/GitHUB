import java.util.*;
public class Bralec implements Ivmesnik {

    @Override
    public String getUserInput() {
        Scanner sc = new Scanner(System.in);
        String rezultat = sc.nextLine();
        return rezultat;  
    }
    @Override
    public void report(String s) {
       System.out.println( s );
        
    }
    @Override
    public void prompt(String s) {
       System.out.println(s);   
    }
}
