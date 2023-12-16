package trabajo_teorico_iso.dominio;

public class MenorEdadException extends Exception {
    public MenorEdadException(String message) {
        super("[ERROR] La persona es menor de edad");
    }
}
