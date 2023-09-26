import java.lang.reflect.Constructor;

public final class PR431Main {
    
    private static PR431Main instance;
    public String nom,cognom;
    public int edat;
    public static void main(String[] args) {

        System.out.println("Aquest exemple:");
        System.out.println("- Triga una estona a iniciar l'objecte");
        System.out.println("- Mostra que 1 i 2 tenen la mateixa instància de l'objecte (Hola, Adeu)");
        System.out.println("- Mostra que 3 no té la mateixa instància (Pepito)");
        System.out.println("");

        System.out.println(".. .iniciant 1 ...");
        PR431Main instance1 = PR431Main.getInstance("jose","miguel",12);
        System.out.println(instance1.toString());

        System.out.println(".. .iniciant 2 ...");
        PR431Main instance2 = getNewDestroyedInstance("a","e",13);
        System.out.println(instance2.toString());

        System.out.println(".. .iniciant 3 ...");
        PR431Main instance3 = getNewDestroyedInstance("a", "b", 15);
        System.out.println(instance3.toString());
    }

    static PR431Main getNewDestroyedInstance (String nom, String cognom, int edat) {
        
        PR431Main result = null;
        try {
            Constructor<?>[] constructors = PR431Main.class.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                result = (PR431Main) constructor.newInstance(nom,cognom,edat);
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    private PR431Main(String nom,String cognom,int edat) {
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

    public static PR431Main getInstance(String nom,String cognom,int edat) {
        if (instance == null) {
            instance = new PR431Main(nom,cognom,edat);
        }
        return instance;
    }

    @Override
    public String toString() {
      return " Nom: " + nom + ", Cognom: " + cognom + ", Edat: " + edat;
    }

    
}
