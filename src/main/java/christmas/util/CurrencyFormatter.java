package christmas.util;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {
    private static final String WON = "₩";
    private static final String NONE = "";

    private CurrencyFormatter() {
        throw new IllegalArgumentException();
    }

    public static String changeFormat(int amount) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.KOREA);
        String formattedAmount = currencyFormat.format(amount);

        return formattedAmount.replace(WON, NONE);
    }
}
