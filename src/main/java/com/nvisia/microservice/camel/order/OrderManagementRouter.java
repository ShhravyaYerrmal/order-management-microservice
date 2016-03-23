package com.nvisia.microservice.camel.order;

import org.apache.camel.component.servlet.*;
import org.apache.camel.model.rest.*;
import org.apache.camel.spring.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.context.embedded.*;
import org.springframework.context.annotation.*;

/**
 * Spring boot application that defines the routes available for order
 * management.
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
@SpringBootApplication
public class OrderManagementRouter extends FatJarRouter {

   @Override
   public void configure() {
      restConfiguration().component("servlet").bindingMode(RestBindingMode.json);

      rest("/order").get("{id}").description("Retrieve an order by ID")
            .outType(Order.class)
            .to("bean:orderManagementService?method=getOrder(${header.id})");
   }

   @Bean
   public ServletRegistrationBean servletRegistrationBean() {
      ServletRegistrationBean registration = new ServletRegistrationBean(
            new CamelHttpTransportServlet(), "/api/*");
      registration.setName("CamelServlet");
      return registration;
   }

}
