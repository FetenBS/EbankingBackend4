package org.sid.mappers;

import org.sid.dtos.CurrentAccountDTO;
import org.sid.dtos.CustomerDTO;
import org.sid.dtos.SavingAccountDTO;
import org.sid.entities.CurrentAccount;
import org.sid.entities.Customer;
import org.sid.entities.SavingAccount;
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
public SavingAccount fromSavingAccountDTO(SavingAccountDTO savingAccountDTO) {
	SavingAccount savingAccount=new SavingAccount();
	BeanUtils.copyProperties(savingAccountDTO, savingAccount);
	savingAccount.setCustomer(fromCustomerDTO(savingAccountDTO.getCustomerDto()));
	return savingAccount;
}
public SavingAccountDTO fromAccountDTO(SavingAccount savingAccount) {
	SavingAccountDTO savingAccountDTO=new SavingAccountDTO();
	BeanUtils.copyProperties(savingAccount, savingAccountDTO);
	savingAccountDTO.setCustomerDto(fromCustomer(savingAccount.getCustomer()));
	return savingAccountDTO;
	
}
public CurrentAccount fromCurrentAccountDTO(CurrentAccountDTO currentAccountDTO) {
	CurrentAccount currentAccount=new CurrentAccount();
	BeanUtils.copyProperties(currentAccountDTO, currentAccount);
	currentAccount.setCustomer(fromCustomerDTO(currentAccountDTO.getCustomerDto()));
	return currentAccount;
	
}
public CurrentAccountDTO fromCurrentAccount(CurrentAccount currentAccount) {
	CurrentAccountDTO currentAccountDTO=new CurrentAccountDTO();
	BeanUtils.copyProperties(currentAccount, currentAccountDTO);
	currentAccountDTO.setCustomerDto(fromCustomer(currentAccount.getCustomer()));
	return currentAccountDTO;
}
}