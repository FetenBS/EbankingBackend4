package org.sid.web;

import java.util.List;

import org.sid.Exception.BankAccountNotFoundException;
import org.sid.dtos.BanckAccountDTO;
import org.sid.services.BanckAccountService;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RestResource
@RepositoryRestResource
@RepositoryRestController
public class BankAccountRestAPI {
private BanckAccountService banckAccountService;

public BankAccountRestAPI(BanckAccountService banckAccountService) {
	super();
	this.banckAccountService = banckAccountService;
}
@GetMapping("/accounts/{accountId}")
public BanckAccountDTO getBankAccount(@PathVariable Long accountId) throws BankAccountNotFoundException {
	BanckAccountDTO bankAccount=banckAccountService.getBanckAccount(accountId);
	return bankAccount;}
	
	

@GetMapping("/accounts")
public List<BanckAccountDTO> listAccounts(){
	return banckAccountService.banckAccountsList();
	
}

}