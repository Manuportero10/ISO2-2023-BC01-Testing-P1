package trabajo_teorico_iso.dominio;

public class NumeroNegativoException extends Exception {
    public NumeroNegativoException(String message) {
        super("[ERROR] El numero es negativo");
    }
}
