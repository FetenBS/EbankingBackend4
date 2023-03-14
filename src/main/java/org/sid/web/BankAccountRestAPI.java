package org.sid.web;

import org.sid.services.BanckAccountService;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
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
	
	
	
}
