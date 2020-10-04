import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class Prices {

    public boolean checkCard(final Integer cardNumber) {
        for (int i = 2; i < (cardNumber / 2); i++) {
            if (cardNumber % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String putMessage() {
        String newMessage = "We do not have promotions at the moment.";
        return newMessage;
    }

    public String fullPrice(int price, String currency, int tax) {
        return price + " " + currency + " this is the price, and the current tax is " + "%" + tax;
    }

}
