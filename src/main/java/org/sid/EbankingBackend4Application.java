package org.sid;


import java.util.Date;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.sid.dtos.AccountOperationRepository;
import org.sid.dtos.BanckAccountRepository;
import org.sid.dtos.CustomerRepository;
import org.sid.entities.AccountOperation;
import org.sid.entities.BanckAccount;
import org.sid.entities.CurrentAccount;
import org.sid.entities.Customer;
import org.sid.entities.SavingAccount;
import org.sid.enums.AccountStatus;
import org.sid.enums.OperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@Transactional 
@SpringBootApplication
public class EbankingBackend4Application {
@Autowired
private BanckAccountRepository banckAccountRepository;
	public static void main(String[] args) {
		SpringApplication.run(EbankingBackend4Application.class, args);
	}
	CommandLineRunner commandLineRunner() {
		return args->{
			BanckAccount banckAccount=banckAccountRepository.findById((long) 4).orElse(null);
			if(banckAccount!=null) {
System.out.println("*****");
System.out.println(banckAccount.getId());
System.out.println(banckAccount.getBalance());
System.out.println(banckAccount.getStatus());
System.out.println(banckAccount.getCreatedAt());
System.out.println(banckAccount.getCustomer().getName());
System.out.println(banckAccount.getClass().getSimpleName());
if(banckAccount instanceof CurrentAccount) {
System.out.println("OverDraft=>"+((CurrentAccount) banckAccount).getOverDraft());
}
else if (banckAccount instanceof SavingAccount) {
System.out.println("Rate=>"+((SavingAccount) banckAccount).getInterestRate());

}
banckAccount.getAccountOperations().forEach(op->{
System.out.println(op.getType()+"/t"+op.getOperationDate()+"/t"+op.getAmount());
});

		
			}	
			
			
			
			
			
			
			
			
		}
				
				;}
	@Bean
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
