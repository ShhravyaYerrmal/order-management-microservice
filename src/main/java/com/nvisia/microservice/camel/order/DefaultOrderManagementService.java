package com.nvisia.microservice.camel.order;

import org.springframework.stereotype.*;

/**
 * Default implementation for order management.
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
@Service("orderManagementService")
public class DefaultOrderManagementService implements OrderManagementService {

   @Override
   public Order getOrder(int id) {
      return new Order(1, "12345");
   }

}
