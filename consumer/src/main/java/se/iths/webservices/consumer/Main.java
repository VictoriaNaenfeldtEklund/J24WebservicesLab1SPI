package se.iths.webservices.consumer;

import se.iths.webservices.service.DeliveryService;
import se.iths.webservices.service.annotation.DeliveryZone;
import se.iths.webservices.service.annotation.Zone;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ServiceLoader<DeliveryService> deliveryServiceLoader = ServiceLoader.load(DeliveryService.class);

        List<DeliveryService> deliveryServices = deliveryServiceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(ds -> ds.getClass().getAnnotation(DeliveryZone.class).value().equals(Zone.A))
                .toList();

        if(deliveryServices.isEmpty()) {
            throw new RuntimeException("No delivery service found");
        }

        Scanner scanner = new Scanner(System.in);
        DeliveryService deliveryService;

        while(true) {

            try {

                System.out.println("\nPlease choose a delivery company for your order:");
                int i = 1;

                for(DeliveryService ds : deliveryServices) {
                    System.out.printf("\n%s. Name: %-20s Price: %6.2f kr", i++, ds.getName(), ds.getPrice());
                }

                System.out.print("\nEnter the number of your choice: ");
                deliveryService = deliveryServices.get(Integer.parseInt(scanner.nextLine()) - 1);
                scanner.close();
                break;

            } catch (NumberFormatException | IndexOutOfBoundsException e) {

                System.out.println("\nPlease enter a valid choice for your delivery service.");
            }
        }
        System.out.printf("\nYour order will be sent with delivery company:\nName: %-20s Price: %6s kr", deliveryService.getName(), deliveryService.getPrice().toString());
    }
}
