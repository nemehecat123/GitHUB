public abstract class IgraZaDva{
    private  int igralec ; // ce je 1 je na vrsti 1 cene je dva
    protected boolean JePrviNaslednji =true ;
    protected int nRač =0;
    protected IPlayer rač1;
    protected IPlayer rač2;
    public void setIgralec(int začne){
        if (začne ==2)
        JePrviNaslednji =false;
        else
        JePrviNaslednji = true ;

    }
    public int getIgralec(){
        if(JePrviNaslednji)
        return 1;
        else
        return 2;
    }
    public void spremeniIgralca(){
        JePrviNaslednji =! JePrviNaslednji;
    }
     public int getNRač(){
         return nRač;
     }

     public void dodajRačIgralca(IPlayer x){
         if (nRač ==0) {
             rač2 =x;
         }
         else{
             if (nRač==1) {
                 rač1 =x;

             }
             else{
                 return;
             }
         }
        nRač++;
     }

 public abstract boolean  konecIgre();
 public abstract String dobiZmagovalca();
}
