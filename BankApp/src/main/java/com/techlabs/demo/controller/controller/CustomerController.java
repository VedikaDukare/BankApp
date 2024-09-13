package com.techlabs.demo.controller.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.techlabs.demo.dto.CustomerDto;
import com.techlabs.demo.dto.PageResponseDto;
import com.techlabs.demo.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
@Validated
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Create a new customer
    @PostMapping("/add")
    public ResponseEntity<String> addCustomer(@Valid @RequestBody CustomerDto customerDto) {
        String response = customerService.addCustomer(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Retrieve all customers with pagination
    @GetMapping("/getAll")
    public ResponseEntity<PageResponseDto<CustomerDto>> getAllCustomers(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {
        PageResponseDto<CustomerDto> customersPage = customerService.getAllCustomers();
        return ResponseEntity.ok(customersPage);
    }

    // Retrieve a customer by ID
    @GetMapping("/getById/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {
        CustomerDto customerDto = customerService.getCustomerById(id);
        if (customerDto != null) {
            return ResponseEntity.ok(customerDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Update customer profile
    @PutMapping("/updateProfile/{id}")
    public ResponseEntity<String> updateProfile(
            @PathVariable Long id, 
            @Valid @RequestBody CustomerDto customerDto) {
        String response = customerService.updateProfile(id, customerDto);
        return ResponseEntity.ok(response);
    }
}
