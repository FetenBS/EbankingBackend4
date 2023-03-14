package org.sid.services;

import java.util.List;

import org.sid.Exception.BalanceNotSufficentException;
import org.sid.Exception.BankAccountNotFoundException;
import org.sid.Exception.CustomerNotFoundException;
import org.sid.dtos.CurrentAccountDTO;
import org.sid.dtos.CustomerDTO;
import org.sid.dtos.SavingAccountDTO;
import org.sid.entities.BanckAccount;
import org.sid.entities.Customer;

public interface BanckAccountService {
//Customer saveCustomer(Customer customer);
CurrentAccountDTO saveCurrentBanckAccount(double initialBalance,double overDraft,Long customerId) throws CustomerNotFoundException ;
SavingAccountDTO saveSavingBanckAccount(double initialBalance,double interestRate,Long customerId) throws CustomerNotFoundException ;




List<CustomerDTO> listCustomers();
BanckAccount getBanckAccount(Long accountId);
//void debit(String accountId,double amount,String description);
//void credit(String accountId,double amount,String description);
//void transfert(String accountIdSource, String accountIdDestination,double amount) throws BankAccountNotFoundException, BalanceNotSufficentException;
List<BanckAccount> banckAccountsList();
void credit(Long accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficentException;
List<BanckAccount> bankAccountList();
void transfert(Long accountIdSource, Long accountIdDestination, double amount)
		throws BankAccountNotFoundException, BalanceNotSufficentException;
void debit(Long id, double d, String string) throws BankAccountNotFoundException, BalanceNotSufficentException;
CustomerDTO getCustomerDTO(Long customerId) throws CustomerNotFoundException;
CustomerDTO saveCustomer(CustomerDTO customerDTO);
CustomerDTO updateCustomer(CustomerDTO customerDTO);
void deleteCustomer(Long customerId);
}

