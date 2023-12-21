package trabajo_teorico_iso.dominio;
import java.util.*;

public class Persona {

    private String nombre; 
    private String apellidos; 
    private int nacimiento; 
    private String nacionalidad;
    private NivelEducacion titulacion; 
    private String certificado_ingles; 
    private int numero_telefono;	 
    private String correo_electronico; 
        
    public Persona(String nombre,String apellidos, int nacimiento, String nacionalidad, String titulacion, String certificado_ingles, int numero_telefono, String correo_electronico) { 	//constructor 
        
        this.nombre=nombre; 
        this.apellidos=apellidos; 
        this.nacimiento=nacimiento; 
        this.nacionalidad=nacionalidad; 
        this.titulacion=obtener_titulacion(titulacion); 
        this.certificado_ingles=certificado_ingles; 
        this.numero_telefono=numero_telefono; 
        this.correo_electronico=correo_electronico;
        
    }

    //----------------------------------------------------GETTERS----------------------------------------------------//
    public String getNombre() {
        return nombre;
    }

    //----------------------------------------------------METODOS----------------------------------------------------//
    private NivelEducacion obtener_titulacion(String titulacion){
        NivelEducacion nivel = null;
        switch (titulacion.toUpperCase()) {
            case "GRADUADO ESCOLAR":
                nivel = NivelEducacion.GRADUADO_ESCOLAR;
                break;
            case "INSTITUTO":
                nivel = NivelEducacion.INSTITUTO;
                break;
            case "BACHILLER":
                nivel = NivelEducacion.BACHILLER;
                break;
            case "GRADO UNIVERSITARIO":
                nivel = NivelEducacion.GRADO_UNIVERSITARIO;
                break;
            case "MASTER":
                nivel = NivelEducacion.MASTER;
                break;
            case "DOCTORADO":
                nivel = NivelEducacion.DOCTORADO;
                break;
            default:
                break;
        }
        return nivel;
    }
    
    public boolean es_mayor_de_edad() throws MenorEdadException, NumeroNegativoException {

        if (this.nacimiento <= 0) {
            throw new NumeroNegativoException("El numero es negativo");
        }

        if (2023 - this.nacimiento >= 18) {
            return true;
        } else {
            if (2023 - this.nacimiento < 0) {
                throw new NumeroNegativoException("El numero es negativo");
            } else {
                throw new MenorEdadException("La persona es menor de edad");
            }
        }
    }
        
    public boolean es_europeo() throws NoEuropeoException {
        Map<String, Integer> Lista_nacionalidades_europeas = new HashMap<>();
        generar_lista_nacionalidades_europeas(Lista_nacionalidades_europeas);

        if (Lista_nacionalidades_europeas.containsKey(this.nacionalidad)) {
            return true;
        } else {
            throw new NoEuropeoException("La persona no es europea");
        }
    }

    private void generar_lista_nacionalidades_europeas(Map<String, Integer> Lista_nacionalidades_europeas){
        Lista_nacionalidades_europeas.put("alemana", 1);
        Lista_nacionalidades_europeas.put("austriaca", 1);
        Lista_nacionalidades_europeas.put("belga", 1);
        Lista_nacionalidades_europeas.put("bulgara", 1);
        Lista_nacionalidades_europeas.put("chipriota", 1);
        Lista_nacionalidades_europeas.put("croata", 1);
        Lista_nacionalidades_europeas.put("danesa", 1);
        Lista_nacionalidades_europeas.put("eslovaca", 1);
        Lista_nacionalidades_europeas.put("eslovena", 1);
        Lista_nacionalidades_europeas.put("espanola", 1);
        Lista_nacionalidades_europeas.put("estionio", 1);
        Lista_nacionalidades_europeas.put("finlandesa", 1);
        Lista_nacionalidades_europeas.put("francesa", 1);
        Lista_nacionalidades_europeas.put("heleno", 1);
        Lista_nacionalidades_europeas.put("hungara", 1);
        Lista_nacionalidades_europeas.put("irlandesa", 1);
        Lista_nacionalidades_europeas.put("italiana", 1);
        Lista_nacionalidades_europeas.put("letonesa", 1);
        Lista_nacionalidades_europeas.put("lituana", 1);
        Lista_nacionalidades_europeas.put("luxemburguesa", 1);
        Lista_nacionalidades_europeas.put("maltesa", 1);
        Lista_nacionalidades_europeas.put("holandesa", 1);
        Lista_nacionalidades_europeas.put("polaca", 1);
        Lista_nacionalidades_europeas.put("portuguesa", 1);
        Lista_nacionalidades_europeas.put("britanico", 1);
        Lista_nacionalidades_europeas.put("checa", 1);
        Lista_nacionalidades_europeas.put("rumana", 1);
        Lista_nacionalidades_europeas.put("sueca", 1);
    }
        
    public boolean apuntarse_doctorado() throws MenorEdadException, NumeroNegativoException {
        if (es_mayor_de_edad() && this.titulacion.compareTo(NivelEducacion.MASTER) >= 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
}
