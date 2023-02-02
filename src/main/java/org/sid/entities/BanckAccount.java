package org.sid.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.sid.enums.AccountStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE", length=4)
@Data @AllArgsConstructor @NoArgsConstructor
public class BanckAccount {
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	private double balance;
	private Date createdAt;
	@Enumerated(EnumType.ORDINAL)
	private AccountStatus status;
@ManyToOne
	private Customer customer;
@OneToMany(mappedBy="banckAccount")
	private List<AccountOperation> accountOperations;
}
