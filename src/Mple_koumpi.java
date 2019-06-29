
public class Mple_koumpi extends Koumpi implements Xarakthristika{
    
    private String xroma;
    private int bathmologia;
    private static int megisto_plhthos;
    
    public Mple_koumpi(char gramma) {
        super(gramma);
        this.xroma="mple";
        this.bathmologia=podoi();
        this.megisto_plhthos=3;
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
