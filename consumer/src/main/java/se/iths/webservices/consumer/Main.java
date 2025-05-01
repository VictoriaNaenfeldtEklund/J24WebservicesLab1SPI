package se.iths.webservices.consumer;

import se.iths.webservices.service.DeliveryService;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ServiceLoader<DeliveryService> deliveryServiceLoader = ServiceLoader.load(DeliveryService.class);
        Map<Integer, DeliveryService> deliveryServiceMap = createDeliveryServiceMapWithIdKey(deliveryServiceLoader);
        DeliveryService deliveryService = getUserChoiceOfDeliveryService(deliveryServiceMap);
        System.out.printf("\nYour order will be sent with delivery company:\nName: %-20s Price: %6s kr", deliveryService.getName(), deliveryService.getPrice().toString());
    }

    private static Map<Integer, DeliveryService> createDeliveryServiceMapWithIdKey(ServiceLoader<DeliveryService> deliveryServiceLoader) {

        Map<Integer, DeliveryService> deliveryServiceMap = new HashMap<>();
        int id = 1;

        for(DeliveryService deliveryService : deliveryServiceLoader) {
            deliveryServiceMap.put(id, deliveryService);
            id++;
        }

        if(deliveryServiceMap.isEmpty()) {
            throw new RuntimeException("No delivery service found");
        }

        return deliveryServiceMap;
    }

    private static DeliveryService getUserChoiceOfDeliveryService(Map<Integer, DeliveryService> deliveryServiceMap) {

        Scanner scanner = new Scanner(System.in);

        while(true){

            try {

                System.out.println("\nPlease choose a delivery company for your order:");
                deliveryServiceMap.forEach((id, service) -> System.out.printf("\n%d. Name: %-20s Price: %6s kr", id, service.getName(), service.getPrice().toString()));
                System.out.print("\nEnter the number of your choice: ");
                DeliveryService deliveryService = deliveryServiceMap.get(Integer.parseInt(scanner.nextLine()));

                if(deliveryService == null) {
                    throw new NullPointerException();
                }

                return deliveryService ;

            } catch (NumberFormatException | NullPointerException | ClassCastException e) {
                System.out.println("\nPlease enter a valid choice for your delivery service.");
            }
        }
    }

}
