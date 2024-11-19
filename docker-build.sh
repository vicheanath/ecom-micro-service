#!/bin/bash

# List of your services directories
services=(
  "apigetway"
  "authentication"
  "cart"
  "catalog"
  "inventory"
  "order"
  "payment"
  "servicediscovery"
  # Add any additional services here
)

# Loop through each service
for service in "${services[@]}"; do

  echo "Building Docker image for service: $service"
  # Check if the directory exists
  if [ -d "$service" ]; then
    # Navigate into the service directory
    cd $service || exit

    # Run Maven command to build the Docker image
    mvn spring-boot:build-image

    # Check if the build command was successful
    if [ $? -eq 0 ]; then
      echo "Successfully built Docker image for $service"
    else
      echo "Failed to build Docker image for $service"
      exit 1
    fi

    # Go back to the root directory
    cd ..
  else
    echo "Directory for $service does not exist. Skipping..."
  fi
done

echo "All services have been processed."
