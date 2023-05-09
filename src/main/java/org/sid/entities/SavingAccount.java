package org.sid.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.sid.enums.AccountStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("SA")
@Data @NoArgsConstructor @AllArgsConstructor
public class SavingAccount extends BanckAccount {
private double interestRate;
//private AccountStatus status;
}
