package org.sid.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@DiscriminatorValue("CA")
@NoArgsConstructor @AllArgsConstructor
public class CurrentAccount extends BanckAccount {
	
private double overDraft;
}
