package trabajo_teorico_iso.presentacion;
import java.util.Scanner;

public class Interfaz {
    public final Scanner sc = new Scanner(System.in);
    public final Scanner sc_int = new Scanner(System.in);

    public String leerString() {
        String cadena = sc.nextLine();
        return cadena;
    }

    public int leerInt() {
        boolean seguir = true;
        int numero=0;

        do{
            try {
                numero = sc_int.nextInt();
                seguir = false;
            } catch (Exception e) {
                System.out.println("Error al introducir el numero");
                sc_int.next();
                seguir = true;
            }
        }while(seguir);

        return numero;
    }

    public String leerTitulacion(){
        String titulacion;

        mostrarTitulaciones();
        titulacion = sc.nextLine();

        while (!comprobarTitulacion(titulacion)) {
            System.out.println("Error al introducir la titulacion");
            titulacion = sc.nextLine();
        }
        
        return titulacion;
    }

    private boolean comprobarTitulacion(String titulacion){
        if(titulacion.toUpperCase().equals("GRADUADO ESCOLAR") || titulacion.toUpperCase().equals("INSTITUTO") || titulacion.toUpperCase().equals("BACHILLER") || 
            titulacion.toUpperCase().equals("GRADO UNIVERSITARIO") || titulacion.toUpperCase().equals("MASTER") || titulacion.toUpperCase().equals("DOCTORADO")){
            return true;
        }else{
            return false;
        }
    }

    private void mostrarTitulaciones(){
        System.out.println("GRADUADO ESCOLAR");
        System.out.println("INSTITUTO");
        System.out.println("BACHILLER");
        System.out.println("GRADO UNIVERSITARIO");
        System.out.println("MASTER");
        System.out.println("DOCTORADO\n--------------------------");
    }
}
