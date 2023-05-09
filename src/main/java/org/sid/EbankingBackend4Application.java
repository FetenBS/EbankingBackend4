package org.sid;


import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.sid.Exception.BalanceNotSufficentException;
import org.sid.Exception.BankAccountNotFoundException;
import org.sid.Exception.CustomerNotFoundException;
import org.sid.dtos.BanckAccountDTO;
import org.sid.dtos.CurrentAccountDTO;
import org.sid.dtos.CustomerDTO;
import org.sid.dtos.SavingAccountDTO;
import org.sid.entities.AccountOperation;
import org.sid.entities.BanckAccount;
import org.sid.entities.CurrentAccount;
import org.sid.entities.Customer;
import org.sid.entities.SavingAccount;
import org.sid.enums.AccountStatus;
import org.sid.enums.OperationType;
import org.sid.repositories.AccountOperationRepository;
import org.sid.repositories.BanckAccountRepository;
import org.sid.repositories.CustomerRepository;
import org.sid.services.BanckAccountService;
import org.sid.services.BanckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.data.repository.CrudRepository;
@Transactional 
@SpringBootApplication

public class EbankingBackend4Application {


	public static void main(String[] args) {
		SpringApplication.run(EbankingBackend4Application.class, args);
	}

	

	@Bean
	
CommandLineRunner commandLineRunner(CustomerRepository customerRepository,BanckAccountService banckAccountService,
		BanckAccountRepository banckAccountRepository,
		AccountOperationRepository accountOperationRepository
		) {
	return args ->{
		Stream.of("AZIZ","YASSINE","Aicha","Adam").forEach(name->{
			CustomerDTO customer=new CustomerDTO();
			customer.setName(name);
			customer.setEmail(name+"@gmail.com");
			banckAccountService.saveCustomer(customer);
			
		});
	
		
		banckAccountService.listCustomers().forEach(customer->{
			try {
			banckAccountService.saveCurrentBanckAccount(Math.random()*90000, 9000, customer.getId());
			banckAccountService.saveSavingBanckAccount(Math.random()*120000, 5.5, customer.getId());
			}catch (CustomerNotFoundException e) {
				e.printStackTrace();
			}
		});
			List<BanckAccountDTO> banckAccounts=banckAccountService.banckAccountsList();
		
			for (BanckAccountDTO bankAccount:banckAccounts){
				if (BanckAccountDTO.getBankAccount() != null) {
	               for (int i = 0; i <10 ; i++) {
	                
	                    
	                    if(bankAccount instanceof SavingAccountDTO ){
	                        
	                        banckAccountService.debit(((SavingAccountDTO) banckAccountRepository).getId(), 1000+Math.random()+9000, "debit");
	                    } else{
	                       // ((CurrentAccountDTO) bankAccount).getId();
	                    }
	                    banckAccountService.credit(((CurrentAccountDTO) bankAccount).getId(),10000+Math.random()*120000,"Credit");
	                
	                }System.out.println("error");
	                	
	                }
	            }
	       
		
	

		

		};	
		
	}	
		
}	
	
	

	








