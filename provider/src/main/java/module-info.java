import se.iths.webservices.provider.delivery.NoGoodDelivery;
import se.iths.webservices.provider.delivery.PriceyPrice;
import se.iths.webservices.provider.delivery.Sheeeep;
import se.iths.webservices.service.DeliveryService;

module se.iths.webservices.spi.provider {
    requires se.iths.webservices.spi.service;

    provides DeliveryService with PriceyPrice, Sheeeep, NoGoodDelivery;
}
