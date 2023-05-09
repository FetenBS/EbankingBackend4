package org.sid.repositories;

import java.util.List;

import org.sid.entities.AccountOperation;
import org.sid.entities.BanckAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long>{
public List<AccountOperation> findByBanckAccountId( Long banckAccountId);
}
