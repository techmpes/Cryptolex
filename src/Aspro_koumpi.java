public class Aspro_koumpi extends Koumpi implements Xarakthristika{
    
    private String xroma;
    private int bathmologia;
    private int megisto_plhthos;
    
    public Aspro_koumpi(char gramma) {
        super(gramma);
        this.xroma="astpro";
        this.bathmologia=podoi();
        this.megisto_plhthos=-1;
    }
    
    public String getXroma(){
        return xroma;
    }
    
    public int getBathmologia(){
        return bathmologia;
    }
    public int getMegisto(){
        return megisto_plhthos;
    }

}
