package com.nvisia.microservice.camel.order;

/**
 * Interface for services to process orders as part of order management.
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
public interface OrderManagementService {

   /**
    * Retrieves an order by the order ID passed.
    * 
    * @param id
    * @return
    */
   Order getOrder(int id);
}
