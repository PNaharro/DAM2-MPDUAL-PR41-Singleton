public final class PR430Main {

    public static void main(String[] args) {

        System.out.println("Aquest exemple:");
        System.out.println("- Triga una estona a iniciar l'objecte");
        System.out.println("- Mostra que 1 i 2 tenen la mateixa instància de l'objecte (Hola, Adeu)");
        System.out.println("- Mostra que 3 no té la mateixa instància (Pepito)");
        System.out.println("");

        System.out.println(".. .iniciant 1 ...");
        PR430Main instance1 = PR430Main.getInstance("jose","miguel",12);
        System.out.println(instance1.toString());

        System.out.println(".. .iniciant 2 ...");
        PR430Main instance2 = PR430Main.getInstance("a","e",13);
        System.out.println(instance2.toString());

        System.out.println(".. .iniciant 3 ...");
        PR430Main instance3 = PR430Main.getInstance("z","q",15);
        System.out.println(instance3.toString());
    }

    private static PR430Main instance;
    public String nom,cognom;
    public int edat;

    private PR430Main(String nom,String cognom,int edat) {
        // Simulem una inicialització lenta
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
    }

    public static PR430Main getInstance(String nom,String cognom,int edat) {
        if (instance == null) {
            instance = new PR430Main(nom,cognom,edat);
        }
        return instance;
    }

    @Override
    public String toString() {
        return " Nom: " + nom + ", Cognom: " + cognom + ", Edat: " + edat;
    }
}
