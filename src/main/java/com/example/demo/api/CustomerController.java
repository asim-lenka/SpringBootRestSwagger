/**
 * 
 */
package com.example.demo.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author asiml
 *
 */
@RestController

  @Api(value="/customer",description="Customer Profile",produces="application/json")
 
@RequestMapping("/api/customer")
public class CustomerController {
	
		@ApiOperation(value = "get customer", response = Customer.class)
	
		@ApiResponses(value = {

			@ApiResponse(code = 200, message = "Customer Details Retrieved", response = Customer.class),

			@ApiResponse(code = 500, message = "Internal Server Error"),

			@ApiResponse(code = 404, message = "Customer not found") })
	 
	
		@RequestMapping(value = "/getCustomer", method = RequestMethod.GET, produces = "application/json")
		public ResponseEntity<Customer> getCustomer() {
			Customer cust = new Customer();
			cust.setName("Asim");
			cust.setId(1234);
			cust.setAddress("Pittsburgh");
			return new ResponseEntity<Customer>(cust, HttpStatus.OK);
		}
	
		@PostMapping(value = "/saveCustomer/{id}")
		public Customer saveCustomer(@PathVariable String id, @RequestBody Customer customer) {
			return new Customer(Integer.parseInt(id), customer.getName(), customer.getAddress());
		}
 
}
