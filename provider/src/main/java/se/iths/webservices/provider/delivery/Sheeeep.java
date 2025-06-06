package se.iths.webservices.provider.delivery;

import se.iths.webservices.service.DeliveryService;
import se.iths.webservices.service.annotation.DeliveryZone;
import se.iths.webservices.service.annotation.Zone;

import java.math.BigDecimal;

@DeliveryZone(Zone.A)
public class Sheeeep implements DeliveryService {

    @Override
    public String getName() {
        return "Sheeeep";
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.TEN;
    }
}
