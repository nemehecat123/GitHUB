import java.util.*;
public class glava {
    public static void main(String[] args) {
        StringBuffer skritaBeseda = new StringBuffer("-----");
        StringBuffer poznanaBeseda =new StringBuffer("kemik");
        int count =0;
        while (poznanaBeseda.length()==skritaBeseda.length()) {
            // 
            preglej(poznanaBeseda, pretvoriString(dobiČrko()), dobiČrko(),skritaBeseda);
            
       }
            System.out.println(skritaBeseda);
        
     
}
public static String dobiČrko(){
    Scanner sc = new Scanner(System.in);
    String črka =sc.nextLine();
    return črka;
}

public static char[] pretvoriString(String s){ 
    
    return s.toCharArray();
}

public static boolean preglej(StringBuffer sb, char[] Črka, String s, StringBuffer neznanaBeseda){

    for(int k =0 ;k <sb.length();k++){
        
         System.out.println(sb);
        if (sb.charAt(k)== Črka[0]) {
            neznanaBeseda.replace(k, k+1,s);
            return true;
        }
    }

return false;
}
}

