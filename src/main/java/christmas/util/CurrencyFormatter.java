package christmas.util;

import christmas.model.OrderAmount;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {
    public static String changeFormat(OrderAmount orderAmount) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.KOREA);
        String formattedAmount = currencyFormat.format(orderAmount.orderAmount());

        return formattedAmount.replace("₩", "");
    }
}
