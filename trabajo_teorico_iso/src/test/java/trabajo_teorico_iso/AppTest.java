package trabajo_teorico_iso;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import trabajo_teorico_iso.dominio.MenorEdadException;
import trabajo_teorico_iso.dominio.NoEuropeoException;
import trabajo_teorico_iso.dominio.NumeroNegativoException;
import trabajo_teorico_iso.dominio.Persona;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
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
        assertTrue(persona.apuntarse_doctorado());
    }
}
