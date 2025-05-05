# SPI Example
A small example of a modular java program where DeliveryService interface sets the standard for different DeliveryService providers.
The DeliveryService providers are filtered by the annotation Zone in this implementation.

## Run with Docker

1. Clone this repository
2. Build Docker image
   
   ```docker build -t my-app-name .```
   
3. Run the Docker image
   
   ```docker run -it --rm my-app-name:latest```
   
