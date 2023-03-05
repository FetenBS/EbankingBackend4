package org.sid.mappers;

import org.sid.dtos.CustomerDTO;
import org.sid.entities.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.BeanUtil;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//import com.fasterxml.jackson.databind.util.BeanUtil;
@Service
public class BankAccountMapperImpl  {
public CustomerDTO fromCustomer(Customer customer) {
	CustomerDTO customerDTO=new CustomerDTO();
	BeanUtils.copyProperties(customer, customerDTO);
	/*customerDTO.setName(customer.getName());
	customerDTO.setId(customer.getId());
	customerDTO.setEmail(customer.getEmail());*/
	return customerDTO;
	
}
public Customer fromCustomerDTO(CustomerDTO customerDTO) {
	Customer customer=new Customer();
	BeanUtils.copyProperties(customerDTO, customer);
	/*customer.setId(customerDTO.getId());
	customer.setName(customer.getEmail());
	customer.setName(customerDTO.getName());
	customer.getBanckAccounts();*/
	return customer;

	
}
}
