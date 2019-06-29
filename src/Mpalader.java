
public class Mpalader extends Koumpi implements Xarakthristika{
    
    private String xroma;
    private int bathmologia;
    private static int megisto_plhthos;
    
    public Mpalader() {
        super('?');
        this.xroma="aspro";
        this.bathmologia=podoi();
        this.megisto_plhthos=2;
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
