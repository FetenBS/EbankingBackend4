package org.sid.dtos;

import java.util.Date;

import org.sid.enums.OperationType;

import lombok.Data;
@Data
public class AccountOperation {
	private Long id;
	private Date OperationDate;
	private double amount;
	private OperationType type;
	private String description;
}
