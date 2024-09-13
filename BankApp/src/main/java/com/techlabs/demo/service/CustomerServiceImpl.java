package com.techlabs.demo.service;

import com.techlabs.demo.dto.CustomerDto;
import com.techlabs.demo.dto.PageResponseDto;
import com.techlabs.demo.entity.Customer;
import com.techlabs.demo.repo.CustomerRepository;
import com.techlabs.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String addCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPassword(customerDto.getPassword());

        customerRepository.save(customer);
        return "Customer successfully created with email: " + customerDto.getEmail();
    }

    @Override
    public CustomerDto getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));

        return mapToDto(customer);
    }

    @Override
    public PageResponseDto<CustomerDto> getAllCustomers(int pageNumber, int pageSize) {
        // Create a pageable object
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        // Fetch paginated data from the repository
        Page<Customer> customerPage = customerRepository.findAll(pageable);

        // Convert entities to DTOs
        List<CustomerDto> customerDtos = customerPage.getContent()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
		return null;
    }
    @Override
    public String updateProfile(Long customerId, CustomerDto customerDto) {
        Customer existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));

        existingCustomer.setFirstName(customerDto.getFirstName());
        existingCustomer.setLastName(customerDto.getLastName());
        existingCustomer.setEmail(customerDto.getEmail());
        existingCustomer.setPassword(customerDto.getPassword());

        customerRepository.save(existingCustomer);
        return "Customer profile successfully updated for customer ID: " + customerId;
    }


    private CustomerDto mapToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId(customer.getCustomerId().intValue());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPassword(customer.getPassword());
        return customerDto;
    }

	@Override
	public PageResponseDto<CustomerDto> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}
}
