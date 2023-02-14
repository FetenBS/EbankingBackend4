package org.sid.services;

import java.util.List;

import org.sid.Exception.CustomerNotFoundException;
import org.sid.entities.BanckAccount;
import org.sid.entities.Customer;

public interface BanckAccountService {
Customer saveCustomer(Customer customer);
BanckAccount saveCurrentBanckAccount(double initialBalance,double overDraft,Long customerId) throws CustomerNotFoundException ;
BanckAccount saveSavingBanckAccount(double initialBalance,double interestRate,Long customerId) throws CustomerNotFoundException ;




List<Customer> listCustomers();
BanckAccount getBanckAccount(Long accountId);
void debit(String accountId,double amount,String description);
void credit(String accountId,double amount,String description);
void transfert(String accountIdSource, String accountIdDestination,double amount);
}

