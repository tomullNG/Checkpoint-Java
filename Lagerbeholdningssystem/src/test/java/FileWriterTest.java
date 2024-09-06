import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileWriterTest {
    @Test
    public void updateLagerbeholdningTest() {
        FileWriter fw = new FileWriter();
        FileReader fr = new FileReader();
        VareHandler vh = new VareHandler();

        VareListe<Vare> initialVareListe = fr.ReadFile("lagerbeholdning.json", vh);

        Vare initialFoundVare = null;
        for (Vare vare : initialVareListe.liste.values()) {
            if ("A".equals(vare.item_id)) {
                initialFoundVare = vare;
                break;
            }
        }

        assert initialFoundVare != null : "Initial item with ID 'A' not found";

        int initialCount = initialFoundVare.count;

        int decrement = 20; // User input
        fw.UpdateStorage("A -" + decrement, "lagerbeholdning.json");

        VareListe<Vare> updatedVareListe = fr.ReadFile("lagerbeholdning.json", vh);

        Vare updatedFoundVare = null;
        for (Vare vare : updatedVareListe.liste.values()) {
            if ("A".equals(vare.item_id)) {
                updatedFoundVare = vare;
                break;
            }
        }

        assert updatedFoundVare != null : "Updated item with ID 'A' not found";

        int updatedCount = updatedFoundVare.count;

        assertEquals(initialCount - decrement, updatedCount, "The count was not updated correctly");
    }
}
