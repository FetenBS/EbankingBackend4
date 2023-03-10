package org.sid;


import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.sid.Exception.BalanceNotSufficentException;
import org.sid.Exception.BankAccountNotFoundException;
import org.sid.Exception.CustomerNotFoundException;
import org.sid.dtos.CustomerDTO;
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
import org.springframework.data.repository.CrudRepository;
@Transactional 
@SpringBootApplication
public class EbankingBackend4Application {


	public static void main(String[] args) {
		SpringApplication.run(EbankingBackend4Application.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(BanckAccountService banckAccountService,CustomerRepository customerRepository,BanckAccountRepository banckAccountRepository, CrudRepository<AccountOperation, Long> accountOperationRepository) {
		
		
		return args->{
			Stream.of("AZIZ","YASSINE","Aicha","Adam").forEach(name->{
				CustomerDTO customer=new CustomerDTO();
				customer.setName(name);
				customer.setEmail(name+"@gmail.com");
				//customerRepository.save(customer);
				banckAccountService.saveCustomer(customer);
			});
			banckAccountService.listCustomers().forEach(customer->{
			
					banckAccountService.saveCurrentBanckAccount(Math.random()*90000, 9000, customer.getId());
					banckAccountService.saveSavingBanckAccount(Math.random()*120000, 5.5, customer.getId());
					});
					List<BanckAccount> banckAccounts=banckAccountService.banckAccountsList();
				//banckAccountService.bankAccountList().forEach(account->{
					for (BanckAccount banckAccount:banckAccounts) {
					for (int i=0;i<10;i++) {
					try {
						banckAccountService.credit(banckAccount.getId(),10000+Math.random()*120000, "Credit");
						banckAccountService.debit(banckAccount.getId(),10000+Math.random()*120000,"Debit");
					}catch (CustomerNotFoundException c) {
						c.printStackTrace();
					} catch (BankAccountNotFoundException | BalanceNotSufficentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
						
					}}
				//});
					
					
			//});
		
		};}
			
		//banckAccountService.listCustomers().forEach(customer->{
			
/*banckAccountService.saveCurrentBanckAccount(Math.random()*90000,99000, customer.getId());
banckAccountService.saveSavingBanckAccount(Math.random()*120000, 5.5, customer.getId());
List<BanckAccount> bankAccounts=banckAccountService.banckAccountsList();
banckAccountService.banckAccountsList().forEach(account->{
	for(BanckAccount bankAccount:bankAccounts) {
	for (int i=0;i<10;i++) {
		
	

		banckAccountService.credit(account.getId(), 10000+Math.random()*120000, "Credit");
	
		banckAccountService.debit(account.getId(),10000+Math.random()*120000,"Debit");
	*/
		//});
	//@Bean
CommandLineRunner start(CustomerRepository customerRepository,
		BanckAccountRepository banckAccountRepository,
		AccountOperationRepository accountOperationRepository
		) {
	return args ->{
		Stream.of("AZIZ","YASSINE","Aicha","Adam").forEach(name->{
			Customer customer=new Customer();
			customer.setName(name);
			customer.setEmail(name+"@gmail.com");
			customerRepository.save(customer);
			
		});
		customerRepository.findAll().forEach(cust->{
			CurrentAccount currentAccount= new CurrentAccount();
			currentAccount.setBalance(Math.random()*90000);
			currentAccount.setCreatedAt(new Date());
			currentAccount.setStatus(AccountStatus.CREATED);
			currentAccount.setCustomer(cust);
			currentAccount.setOverDraft(9000);
			banckAccountRepository.save(currentAccount);
			
		
			SavingAccount savingAccount= new SavingAccount();
			savingAccount.setBalance(Math.random()*70000);
			savingAccount.setCreatedAt(new Date());
			savingAccount.setStatus(AccountStatus.CREATED);
			savingAccount.setCustomer(cust);
			savingAccount.setInterestRate(5.5);
			banckAccountRepository.save(savingAccount);
		});
			
			banckAccountRepository.findAll().forEach(acc->{
				for(int i=0;i<5;i++) {
				AccountOperation accountOperation=new AccountOperation();
				accountOperation.setAmount(Math.random()*120000);
				accountOperation.setOperationDate(new Date());
				accountOperation.setType(Math.random()>0.5?OperationType.DEBIT:OperationType.CREDIT);
				accountOperation.setBanckAccount(acc);
				accountOperationRepository.save(accountOperation);
				}	
				
	
		
	});
	
};
}}
