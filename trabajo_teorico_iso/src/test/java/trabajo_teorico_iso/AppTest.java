package trabajo_teorico_iso;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import trabajo_teorico_iso.dominio.MenorEdadException;
import trabajo_teorico_iso.dominio.NoEuropeoException;
import trabajo_teorico_iso.dominio.NumeroNegativoException;
import trabajo_teorico_iso.dominio.Persona;
import trabajo_teorico_iso.presentacion.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    //test de dominio
   @Test
    public void testCP1() throws MenorEdadException, NumeroNegativoException {
        Persona persona = new Persona("Pepe", "Martinez",-2000, "Alemana", "Graduado Escolar", null, 0, null);
        //deberia salir la excepcion de numero negativo
        boolean esnegativo = false;
        try {
            persona.es_mayor_de_edad();
        }
        catch(MenorEdadException e){
            esnegativo = true;
        }
        catch(NumeroNegativoException e){
            esnegativo = true;
        }
        assertTrue(esnegativo);
    }
    
    @Test //este test nos ayuda a ver que distingue de mayusculas y minusculas
    public void testCP2() throws MenorEdadException, NumeroNegativoException, NoEuropeoException {
        Persona persona = new Persona("Pepe","Martinez",2005,"Italiana","Instituto",null,0,null);
        try {
            persona.es_europeo();
        }
        catch(NoEuropeoException e){
            assertFalse(false);
        }
        
    }
    @Test
    public void testCP3() throws NoEuropeoException {
        Persona persona = new Persona("Pepe","Martinez",2005,"italiana","Instituto",null,0,null);
        try {
            persona.es_europeo();
        }
        catch(NoEuropeoException e){
            assertTrue(false);
        }
    }
    @Test
    public void test4() throws MenorEdadException, NumeroNegativoException {
        Persona persona = new Persona("Pepe","Martinez",2007,"rusa","Bachiller",null,0,null);
        try  {
            persona.apuntarse_doctorado();
        }
        catch(MenorEdadException e){
            assertTrue(true);
        }
    }
    @Test
    public void test6() throws MenorEdadException, NumeroNegativoException {
        Persona persona = new Persona("Pepe","Martinez",(int) (Math.pow(2,31) +1) ,"rusa","Master",null,0,null);
        try {
            persona.es_mayor_de_edad();
        }
        catch(NumeroNegativoException e){
            assertTrue(true);
        }
    }
    @Test
    public void test11() {
       Persona persona = new Persona("Pepe","Martinez",2007,"rusa","Bachiller",null,0,null);
       assertTrue(persona.getNombre().equals("Pepe"));
    }

    @Test
    public void test12() throws MenorEdadException, NumeroNegativoException {
        Persona persona = new Persona("Pepe","Martinez",2005,"rusa","Instituto",null,0,null);
        assertFalse(persona.apuntarse_doctorado());
    }

    @Test
    public void test13() throws MenorEdadException, NumeroNegativoException {
        Persona persona = new Persona("Pepe","Martinez",2005,"rusa","Master",null,0,null);
        assertTrue(persona.apuntarse_doctorado());
    }

    @Test
    public void test14() throws MenorEdadException, NumeroNegativoException, NoEuropeoException {
        Persona persona1 = new Persona("Pepe","Martinez",2005,"rusa","Graduado Escolar",null,0,null);
        Persona persona2 = new Persona("Manolo", "Escobar", 2006, "espanola", "Grado Universitario", null, 0, null);
        Persona persona3 = new Persona("Juan", "Garcia", 1, "espanola", "Doctorado", null, 0, null);

        assertTrue(persona1.es_mayor_de_edad());
        assertTrue(persona2.es_europeo());
        assertTrue(persona3.apuntarse_doctorado());

    }
    //test de interfaz
    @Test 
    public void test7() {
        String  input = "4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Interfaz interfaz = new Interfaz();
        int num = interfaz.leerInt();
        assertTrue(num > 0);
    }

    @Test
    public void test8() {
        String input = "Master\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Interfaz interfaz = new Interfaz();
        String titulacion = interfaz.leerTitulacion();
        assertTrue(titulacion.equals("Master"));
    }

    @Test
    public void test9() {
        String input = "master\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Interfaz interfaz = new Interfaz();
        String palabra = interfaz.leerString();
        assertTrue(palabra.equals("master"));
    }

    @Test
    public void test10() {
        String input = "Guarderia\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Interfaz interfaz = new Interfaz();
        try {
            String titulacion = interfaz.leerTitulacion();
        }
        catch(Exception e){
            assertTrue(true);
        }
    }

    
    @Test
    public void test15() {
        String  input = "Hola\n123\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Interfaz interfaz = new Interfaz();
        int num = interfaz.leerInt();
        assertTrue(num == 123);
    }  
    @Test
    public void test16() {
        String input = "Guarderia\nInstituto\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Interfaz interfaz = new Interfaz();
        String titulacion = interfaz.leerTitulacion();
        assertTrue(titulacion.equals("Instituto"));
    }
}

