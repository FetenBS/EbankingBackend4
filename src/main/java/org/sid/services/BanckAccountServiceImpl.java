package org.sid.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.sid.Exception.CustomerNotFoundException;
import org.sid.entities.BanckAccount;
import org.sid.entities.CurrentAccount;
import org.sid.entities.Customer;
import org.sid.entities.SavingAccount;
import org.sid.repositories.AccountOperationRepository;
import org.sid.repositories.BanckAccountRepository;
import org.sid.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class BanckAccountServiceImpl implements BanckAccountService {

private CustomerRepository customerRepository;
private BanckAccountRepository banckAccountRepository;
private AccountOperationRepository accountOperationRepository;

	

	public Customer saveCustomer(Customer customer ) {
	log.info("Saving new Customer");
	Customer savedCustomer=customerRepository.save(customer);
		return savedCustomer;
	}


/*	public BanckAccount saveBanckAccount(double initialBalance, String type, Long customerId) throws CustomerNotFoundException {
		Customer customer=customerRepository.findById(customerId).orElse(null);
		if(customer==null) 
			
		throw new CustomerNotFoundException("Customer not found");
		BanckAccount banckAccount;
		if (type.equals("current")) {
			banckAccount =new CurrentAccount();
		}else {
			banckAccount=new SavingAccount();
		}
		banckAccount.setId((long) Math.random());
		banckAccount.setCreatedAt(new Date());
		banckAccount.setBalance(initialBalance);
		return null;
	}
*/
	@Override
	public List<Customer> listCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BanckAccount getBanckAccount(Long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void debit(String accountId, double amount, String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void credit(String accountId, double amount, String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transfert(String accountIdSource, String accountIdDestination, double amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BanckAccount saveCurrentBanckAccount(double initialBalance, double overDraft, Long customerId)
			throws CustomerNotFoundException {
		Customer customer=customerRepository.findById(customerId).orElse(null);
	    if(customer==null)
		throw new CustomerNotFoundException("Customer not found");
			CurrentAccount currentAccount=new CurrentAccount();
			currentAccount.setId((long) Math.random());
			currentAccount.setCreatedAt(new Date());
			currentAccount.setBalance(initialBalance);
			currentAccount.setOverDraft(overDraft);
			currentAccount.setCustomer(customer);
			CurrentAccount savedBanckAccount=banckAccountRepository.save(currentAccount);
		return savedBanckAccount;
	}

	@Override
	public BanckAccount saveSavingBanckAccount(double initialBalance, double interestRate, Long customerId)
			throws CustomerNotFoundException {
		Customer customer=customerRepository.findById(customerId).orElse(null);
	    if(customer==null)
		throw new CustomerNotFoundException("Customer not found");
	    SavingAccount savingAccount=new SavingAccount();
	    savingAccount.setId(customerId);
savingAccount.setBalance(initialBalance);
savingAccount.setCreatedAt(new Date());
savingAccount.setCustomer(customer);
savingAccount.setInterestRate(interestRate);
SavingAccount saved=banckAccountRepository.save(savingAccount);
		
		return saved;
	}

	

	

}
