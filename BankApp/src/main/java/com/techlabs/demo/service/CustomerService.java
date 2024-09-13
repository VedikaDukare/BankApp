package com.techlabs.demo.service;

import com.techlabs.demo.dto.CustomerDto;
import com.techlabs.demo.dto.PageResponseDto;

public interface CustomerService {

    String addCustomer(CustomerDto customerDto);

    CustomerDto getCustomerById(Long customerId);

    PageResponseDto<CustomerDto> getAllCustomers();

    String updateProfile(Long customerId, CustomerDto customerDto);

	PageResponseDto<CustomerDto> getAllCustomers(int pageNumber, int pageSize);
}
