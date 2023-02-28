package org.sid.web;

import java.util.List;

import org.sid.entities.Customer;
import org.sid.services.BanckAccountService;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RestResource
@RepositoryRestResource
@RepositoryRestController

@AllArgsConstructor
@Slf4j
public class CustomerRestController {
private BanckAccountService banckAccountService;
@GetMapping("/customerss")
public List<Customer> Customers(){
	return banckAccountService.listCustomers();
}
}