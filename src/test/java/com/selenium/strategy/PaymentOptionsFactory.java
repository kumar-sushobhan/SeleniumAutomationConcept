package com.selenium.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentOptionsFactory {
    private static final Supplier<PaymentOption> CC = () -> new CreditCard();
    private static final Supplier<PaymentOption> NB = () -> new NetBanking();

    private static final Map<String, Supplier<PaymentOption>> MAP = new HashMap<>();
    static {
        MAP.put("CC", CC);
        MAP.put("NB", NB);
    }

    public static PaymentOption get(String option){
        return MAP.get(option).get();
    }
}
