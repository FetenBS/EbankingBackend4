package org.sid.dtos;

import java.util.Date;

import org.sid.enums.AccountStatus;

import lombok.Data;
@Data
public class CurrentAccountDTO extends BanckAccountDTO {
	private Long id;
	private double balance;
	private Date createdAt;
	private AccountStatus status;
	private CustomerDTO customerDto;
	private double overDraft;
}
