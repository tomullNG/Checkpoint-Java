import org.example.*;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderTest {

    @Test
    public void readLagerbeholdningTest() {
        FileReader fr = new FileReader();
        VareHandler vh = new VareHandler();

        VareListe<Vare> vareListe = fr.ReadFile("lagerbeholdning.json", vh);

        Iterator<Vare> iterator = vareListe.liste.values().iterator();

        Vare firstVare = null;

        if (iterator.hasNext()) {
            firstVare = iterator.next();
        }

        assert firstVare != null;
        assertEquals("A", firstVare.item_id);
        assertEquals("Telefon", firstVare.name);
    }
}
