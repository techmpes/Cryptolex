
public class Koumpi {
    private char gramma;
    private int epilegmeno;
    private int grammh;
    private int sthlh;
    private int bathmologia;
        
    public Koumpi(char gramma) {
        this.gramma = gramma;
    }
    
    public int getBathmologia(){
        return bathmologia;
    }
    
    int podoi(){
        switch (this.gramma) {
            case 'Α':
            case 'Ε':
            case 'Η':
            case 'Ο':
            case 'Ι':
            case 'Ν':
            case 'Σ':
            case 'Τ':
                return 1;
            case 'Κ':
            case 'Π':
            case 'Ρ':
            case 'Υ':
                return 2;
            case 'Λ':
            case 'Μ':
            case 'Ω':
                return 3;
            case 'Γ':
            case 'Δ':
                return 4;
            case 'Ζ':
            case 'Θ':
            case 'Β':
            case 'Φ':
                return 8;
            default:
                return 10;
        }
    }
    
    public char getgramma(){
        return gramma;
    }
    
    void thesh(int grammh,int sthlh){
        this.grammh = grammh;
        this.sthlh = sthlh;
    }
    
    int getgrammh(){
        return this.grammh;
    }
    
    int getsthlh(){
        return this.sthlh;
    }
    
    int epilegmeno(){
        return this.epilegmeno;
    }
    
    void epelekse(int epilegmeno){
        this.epilegmeno = epilegmeno;
    }
    
    @Override
    public String toString(){
        return ""+this.gramma;
    }        
}
