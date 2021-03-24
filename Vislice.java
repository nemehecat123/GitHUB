public class Vislice extends IgraZaDva implements IIgra{
    private String SkritaBeseda;
    private StringBuffer TrenutnaBeseda=new StringBuffer();
     StringBuffer prejšnjeČrke=new StringBuffer();
    private int ŠteviloČrkDoKonca;
    private final int življenja =9;
    public Vislice() {
        SkritaBeseda =getSkritaBeseda();
        for(int k =0;k<SkritaBeseda.length();k++){  // napolni besedo zs zvezdicami
            TrenutnaBeseda.append("*");
        }
        ŠteviloČrkDoKonca =SkritaBeseda.length();
    }
    public String getSkritaBeseda() {
        int x  =(int)(Math.random()*10+1);
        switch (x) {
            case 1:
            return "PRIPEKA";
            case 2:
            return "ZVEZEK";
            case 3:
            return "DEZINFEKTOR";
            case 4:
            return "DALJINEC";
            case 5:
            return "FLOMASTER";
            case 6:
            return "POSODA";
            case 7:
            return "NAVODILA";
            case 8:
            return "KEMIK";
            case 9:
            return "OBESEK";
            case 10:
            return "TORBICA";
                
            default:
                break;
        }
        return "";
    }
    @Override
    public String getPromptIgre() {
        return "\n izberi si eno črko";
    }
    @Override
    public String reportIgra() {
        if(!konecIgre())
        return "beseda"+TrenutnaBeseda.toString()+ 
        "\n ugibane črke so "+prejšnjeČrke;
        else
        return " zmagal je igralec "+ getIgralec()+" \n KONEC IGRE";
    }
    @Override
    public void Igraj(Ivmesnik ui) {
        if(rač1 !=null)
        ui.prompt("Igralec 1 je "+ rač1.toString());
        if(rač2 !=null)
        ui.report("Igralec 2 je "+ rač2.toString());
        while(!konecIgre())
        {
            IPlayer rač =null; // hranis ce je napotezi
            ui.report(reportIgra());
            switch (getIgralec()) {
                case 1:
                    rač =rač1;
                    break;

                case 2:
                    rač =rač2;
                    break;

                 default:
                    break;
            }
            char črka = ' ';
            if (rač!=null) {
                // da naredi računalnik potezo
                črka =(rač.narediPotezo().toUpperCase().charAt(0));
                ui.report(rač.toString() + " izbere "+ črka+"\n");
                UgibajČrko (črka);
                spremeniIgralca();
            }
            else // igra uporabnik
            {
                ui.prompt(getPromptIgre());
                String odgovor =ui.getUserInput().toUpperCase();
                if(odgovor.length()>1)
                {
                    //uporabnik je vnesu celo besedo 
                    if (odgovor.equals(SkritaBeseda)) {
                      ŠteviloČrkDoKonca=0;
                        
                    }
                    else{
                        // javi napačno besedo 
                        ui.report("Beseda ni prava");
                        
                    }
                    
                }
                else
                {
                    črka = odgovor.charAt(0);
                    UgibajČrko (črka);
                    spremeniIgralca();
                }
            }
           
        }
            ui.report(reportIgra());
        }
        

    
    @Override
    public boolean konecIgre() {
        return ŠteviloČrkDoKonca<=0;
    }
    @Override
    public String dobiZmagovalca() {
       
        return "igralec "+getIgralec();
    }
    public boolean UgibajČrko(char črka){
        prejšnjeČrke.append(črka);  // tiste črke ku jih ze imam
        if (SkritaBeseda.indexOf(črka)==-1) { // ce je ni noter
            return false;            
        }
        for (int k =0 ;k <SkritaBeseda.length();k++){
            if (SkritaBeseda.charAt(k)==črka) {
                {
                    if (TrenutnaBeseda.charAt(k)==črka) {
                        return false;
                        
                    }else{
                        TrenutnaBeseda.setCharAt(k, črka);
                        ŠteviloČrkDoKonca--;
                    }
                }
                
            }
        }
        return true;
    }

    public String preglejBesedo(Ivmesnik ui, String s){
        

        return " ";
    }
    public String VzeteČrke(){
        return "";
    }
    
 }
    

