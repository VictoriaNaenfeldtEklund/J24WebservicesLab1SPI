package se.iths.webservices.provider.delivery;

import se.iths.webservices.service.DeliveryService;

import java.math.BigDecimal;

public class PriceyPrice implements DeliveryService {
    @Override
    public String getName() {
        return "PriceyPrice";
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal("10000");
    }
}
