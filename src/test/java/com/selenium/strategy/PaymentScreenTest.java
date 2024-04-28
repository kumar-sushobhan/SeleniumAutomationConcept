package com.selenium.strategy;

import com.selenium.googleFactory.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.Map;

public class PaymentScreenTest extends BaseTest {
    private PaymentScreen paymentScreen;

    @BeforeTest
    void setPaymentScreen() {
        this.paymentScreen = new PaymentScreen(this.driver);
    }

    @Test(dataProvider = "getData")
    void paymentTest(String paymentOption, Map<String, String> paymentDetails) {
        this.paymentScreen.goTo();
        this.paymentScreen.getUserInformation().enterDetails("Kumar", "Sushobhan", "sushobhanworld@gmail.com");
        this.paymentScreen.setPaymentOption(PaymentOptionsFactory.get(paymentOption));
        this.paymentScreen.getPaymentOption().enterPaymentInformation(paymentDetails);
        String orderNumber = this.paymentScreen.getOrder().placeOrder();
        System.out.println("Order Number : " + orderNumber);
    }

    @DataProvider
    public Object[][] getData() {
        Map<String, String> cc = Maps.newHashMap();
        cc.put("cc", "123123123123123");
        cc.put("year", "2026");
        cc.put("cvv", "789");

        Map<String, String> nb = Maps.newHashMap();
        nb.put("bank", "WELLS FARGO");
        nb.put("acc_number", "myAccount123");
        nb.put("pin", "999");

        return new Object[][]{
                {"CC", cc},
                {"NB", nb}
        };
    }
}
