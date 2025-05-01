package se.iths.webservices.provider.delivery;

import se.iths.webservices.service.DeliveryService;
import se.iths.webservices.service.annotation.DeliveryZone;
import se.iths.webservices.service.annotation.Zone;

import java.math.BigDecimal;

@DeliveryZone(Zone.B)
public class NoGoodDelivery implements DeliveryService {

    @Override
    public String getName() {
        return "NoGoodDelivery";
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.ZERO;
    }
}
