package trabajo_teorico_iso.dominio;

public class NoEuropeoException extends Exception {
    public NoEuropeoException(String message) {
        super("[ERROR] La persona no es europea");
    }
}
