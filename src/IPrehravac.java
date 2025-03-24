public interface IPrehravac {
    void prehraj(boolean hraj);
    default void prehraj(String nazevPisnicky) {
        System.out.println("Prozatim neni mozny prehrat konkretni pisnicku");
    }
}
