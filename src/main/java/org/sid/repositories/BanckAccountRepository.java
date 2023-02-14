package org.sid.repositories;

import org.sid.entities.AccountOperation;
import org.sid.entities.BanckAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanckAccountRepository extends JpaRepository<BanckAccount, Long> {

	

}
