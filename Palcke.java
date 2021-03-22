public class Palcke extends IgraZaDva implements IIgra{
private int npalčk;
public Palcke() {
    npalčk=11;
    JePrviNaslednji =true;

}
    public Palcke(int š) {      
        npalčk=š;
        JePrviNaslednji =true;

    }
public Palcke(int š, int začne) {
    npalčk =š;
    setIgralec(začne);
}
 public boolean vzemiPalčke(int n){
     if (n <1||n>3||n>npalčk) {
         return false;
         
     }
     else{
     npalčk -=n;
     return true;
     }
 }



    @Override
    public String getPromptIgre() {
       
        return "\n Vzemi od 1 do" +Math.min(3, npalčk)  +"palčke";

    }

    @Override
    public String reportIgra() {
       if (!konecIgre()) {
           return "Na Mizi je "+npalčk+"palčk \n Na vrsti je "+ getIgralec();
       }
       else{
           return "zmagal je"+dobiZmagovalca();
       }
    }

    @Override
    public void Igraj(Ivmesnik ui) {
        if(rač1 !=null)
        ui.prompt("Igralec 1 je "+ rač1.toString());
        if(rač2 !=null)
        ui.report("Igralec 1 je "+ rač2.toString());
        while(!konecIgre()){
            IPlayer rač =null;
            ui.report(reportIgra());
            switch (getIgralec()) {
                case 1:
                    rač =rač1;
                    break;

                case 2:
                    rač =rač1;
                    break;

                 default:
                    break;
            }
            int p =0;
            if (rač!=null) {
                // da naredi računalnik potezo
                p = Integer.parseInt(rač.narediPotezo());
                ui.report(rač.toString() + " pobere  "+ p+" Palčk\n");
            }
            else // igra uporabnik
            {
                ui.prompt(getPromptIgre());
                p=Integer.parseInt(ui.getUserInput());
            }
            if (vzemiPalčke(p))
            spremeniIgralca();
        }
        ui.report(reportIgra());

    }

    @Override
    public boolean konecIgre() {
       return npalčk<=0;
    }

    @Override
    public String dobiZmagovalca() {
        return "Igralec"+getIgralec();
    }
    public int getNpalčk() {
        return npalčk;
    }
    public void setNpalčk(int npalčk) {
        this.npalčk = npalčk;
    }
    
}
