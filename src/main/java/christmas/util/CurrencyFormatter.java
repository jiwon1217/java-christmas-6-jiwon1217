package christmas.util;

import christmas.model.OrderAmount;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {
    public static String changeFormat(int amount) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.KOREA);
        String formattedAmount = currencyFormat.format(amount);

        return formattedAmount.replace("₩", "");
    }
}
