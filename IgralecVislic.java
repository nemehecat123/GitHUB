public class IgralecVislic implements IPlayer{
    private  Vislice v ;
    public IgralecVislic(Vislice x) {
        v=x;
    }
    @Override
    public String narediPotezo() {
        String žeČrke =v.prejšnjeČrke.toString();
        char črka;
        do{
            črka = (char)('A'+(int)(Math.random()*26));  // to je da ugibas crko to je "formula"
        } while (žeČrke.indexOf(črka)!=-1);
        return črka +"";
    }
    
}
