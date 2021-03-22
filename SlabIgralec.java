public class SlabIgralec implements IPlayer{
    Palcke r;
    public SlabIgralec(Palcke igra) {
        r =igra;    
    }
    @Override
    public String narediPotezo() {
        // vrni nakljušno stevilo med 1 in 3
       int p = (int)(Math.random()*3+1);
       int š =Math.min(p, r.getNpalčk());
       return š+"";
    }
    
}
