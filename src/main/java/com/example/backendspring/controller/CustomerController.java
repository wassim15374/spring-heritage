package com.example.backendspring.controller;

import com.example.backendspring.dto.CustomerDTO;
import com.example.backendspring.exception.CustomerNotFoundException;
import com.example.backendspring.service.BankAccountService;
import com.example.backendspring.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerController {

    private CustomerService customerService;
    public CustomerController( CustomerService customerService) {

        this.customerService = customerService;
    }
    @GetMapping("/customer")
 public    List<CustomerDTO> ListCustomers(){
       return  customerService.listCustomer();
    }
    @GetMapping("/customer/{id}")
    public  CustomerDTO getCustomer( @PathVariable("id") Long customerId) throws CustomerNotFoundException {
       return customerService.getCustomer(customerId);
    }

    @PostMapping("/customer")

    public  CustomerDTO savedCustomer(@RequestBody CustomerDTO customerDTO){
        return  customerService.saveCustomer(customerDTO);
    }
    @PutMapping("/customer/{customerId}")
    public CustomerDTO updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO customerDTO){
        customerDTO.setId(customerId);
        return customerService.updateCustomer(customerDTO);
    }
 @DeleteMapping("/customer/{id}")
    public  void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
 }

}
