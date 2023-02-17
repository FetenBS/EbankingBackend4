package org.sid.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.sid.Exception.BalanceNotSufficentException;
import org.sid.Exception.BankAccountNotFoundException;
import org.sid.Exception.CustomerNotFoundException;
import org.sid.entities.AccountOperation;
import org.sid.entities.BanckAccount;
import org.sid.entities.CurrentAccount;
import org.sid.entities.Customer;
import org.sid.entities.SavingAccount;
import org.sid.enums.OperationType;
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
		
		return customerRepository.findAll();
	}

	@Override
	public BanckAccount getBanckAccount(Long accountId) throws BankAccountNotFoundException{
		BanckAccount banckAccount=banckAccountRepository.findById(accountId).orElseThrow(()->new BankAccountNotFoundException("bankAccount not found"));
		return null;
	}

	public void debit(Long accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficentException{
		BanckAccount banckAccount=getBanckAccount(accountId);
		if( banckAccount.getBalance()<amount) {
		throw	new BalanceNotSufficentException("solde insuffisant");
		
		
		}AccountOperation accountOperation=new AccountOperation();
		accountOperation.setType(OperationType.DEBIT);
		accountOperation.setAmount(amount);
		accountOperation.setOperationDate(new Date());
		accountOperation.setDescription(description);
		accountOperation.setBanckAccount(banckAccount);
		accountOperationRepository.save(accountOperation);
		banckAccount.setBalance(banckAccount.getBalance()-amount);
		banckAccountRepository.save(banckAccount);
	}

	public void credit(Long accountId, double amount, String description) {
	BanckAccount bankAccount=getBanckAccount(accountId);
	AccountOperation accountOperation=new AccountOperation();
	accountOperation.setType(OperationType.CREDIT);
	accountOperation.setAmount(amount);
	accountOperation.setOperationDate(new Date());
	accountOperation.setDescription(description);
	accountOperation.setBanckAccount(bankAccount);
	accountOperationRepository.save(accountOperation);
	bankAccount.setBalance(bankAccount.getBalance()+amount);	
	banckAccountRepository.save(bankAccount);
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
SavingAccount savedBanckAccount=banckAccountRepository.save(savingAccount);
		
		return savedBanckAccount;
	}


	@Override
	public void debit(String accountId, double amount, String description) {
	
		
	}


	@Override
	public void credit(String accountId, double amount, String description) {
	
		
	}


	
	/*public void debit(Long accountId, double amount, String description) {
		BanckAccount banckAccount=getBanckAccount(accountId);
		
		
	}*/

	

	

}
