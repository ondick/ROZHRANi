public class Smartphone implements IPrehravac {
    private String model;
    public Smartphone(String model) {
        this.model = model;
    }

    public void prehraj(boolean hraj) {
        if (true){
            System.out.println("Prehravani na mobilu "+model+" spusteno");
        }else {
            System.out.println("Prehravani na mobilu "+model+" MP3 ukončeno");
        }
    }
}
