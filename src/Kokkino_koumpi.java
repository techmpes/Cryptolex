
public class Kokkino_koumpi extends Koumpi implements Xarakthristika{
    
    private String xroma;
    private int bathmologia;
    private static int megisto_plhthos;
    
    
    public Kokkino_koumpi(char gramma) {
        super(gramma);
        this.xroma="kokkino";
        this.bathmologia=podoi()*2;
        this.megisto_plhthos=4;
    }
    public String getXroma(){
        return xroma;
    }
    public int getBathmologia(){
        return bathmologia;
    }
    public static int getMegisto(){
        return megisto_plhthos;
    }
}
