public class Radio implements IPrehravac{
    private String znacka;
    public void prehraj(boolean hraj) {
        if (true){
            System.out.println("Radio spusteno");
        }else {
            System.out.println("Radio ukončeno");
        }
    }
    public String toString() {
        return "" + znacka;
    }
}

