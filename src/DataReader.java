import java.io.IOException;
import java.util.List;

//Interfaccia DataReader
public interface DataReader {
    List<DatoGara> leggiDatoGara(String tipoDato) throws IOException;
}
