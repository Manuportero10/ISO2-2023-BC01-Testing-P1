package trabajo_teorico_iso;
import trabajo_teorico_iso.dominio.*;
import trabajo_teorico_iso.presentacion.*;

public class App {
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        // le pediremos al usuario los datos de la persona
        System.out.println("Introduzca el nombre de la persona");
        String nombre = interfaz.leerString();
        System.out.println("Introduzca los apellidos de la persona");
        String apellidos = interfaz.leerString();
        System.out.println("Introduzca el año de nacimiento de la persona");
        int nacimiento = interfaz.leerInt();
        System.out.println("Introduzca la nacionalidad de la persona");
        String nacionalidad = interfaz.leerString();
        System.out.println("Introduzca la titulacion de la persona");
        String titulacion = interfaz.leerTitulacion();
        System.out.println("Introduzca el certificado de ingles de la persona");
        String certificado_ingles = interfaz.leerString();
        System.out.println("Introduzca el numero de telefono de la persona");
        int numero_telefono = interfaz.leerInt();
        System.out.println("Introduzca el correo electronico de la persona");
        String correo_electronico = interfaz.leerString();

        // creamos la persona
        Persona persona = new Persona(nombre, apellidos, nacimiento, nacionalidad, titulacion, certificado_ingles, numero_telefono, correo_electronico);

        // llamamos a los metodos relevantes de la persona
        // comprobamos si la persona es mayor de edad
        try{
            if(persona.es_mayor_de_edad()){
                System.out.println("La persona es mayor de edad");
            } else{
                System.out.println("La persona no es mayor de edad");
            }
        }catch(NumeroNegativoException e){
            System.out.println("Error al introducir el año de nacimiento	");
        }catch(MenorEdadException e){
            System.out.println("La persona " + persona.getNombre() + " es menor de edad");
        }

        // comprobamos que la persona es europeo
        try{
            if(persona.es_europeo())
                System.out.println("La persona es europea");
            
        }catch(NoEuropeoException e){
            System.out.println("La persona " + persona.getNombre() + " no es europea");
        }

        // comprobamos si la persona puede apuntarse a un doctorado
       try{
            if(persona.apuntarse_doctorado())
                System.out.println("La persona puede apuntarse a un doctorado");
            else
                System.out.println("La persona no puede apuntarse a un doctorado");
            
        }catch(NumeroNegativoException e){
            System.out.println("Error al introducir el año de nacimiento	");
        }catch(MenorEdadException e){
            System.out.println("La persona " + persona.getNombre() + " es menor de edad, por lo que no puede apuntarse a un doctorado");
        }
 
        System.out.println("Fin del programa");
    }
}

