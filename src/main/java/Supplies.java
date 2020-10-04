import java.util.ArrayList;
import java.util.List;

public class Supplies {

    public boolean isSupplyOnStock(int amount) {
        boolean result;
        if (amount >= 50) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    public List<String> putSupplyName(String supName) {
        List<String> supNames = new ArrayList<String>();
        supNames.add(supName);
        return supNames;
    }

    public String createTopSupply(String topSupp) {
        return topSupp;
    }
}
