package org.sid.entities;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Customer {
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
private Long id;
private String name;
private String email;
@OneToMany(mappedBy="customer")
private List<BanckAccount> banckAccounts;
}