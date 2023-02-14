package org.sid.services;

import javax.transaction.Transactional;

import org.sid.entities.BanckAccount;
import org.sid.entities.CurrentAccount;
import org.sid.entities.SavingAccount;
import org.sid.repositories.BanckAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class BanckService {
	@Autowired
	private BanckAccountRepository banckAccountRepository;
	public void consulter() {
		BanckAccount banckAccount=banckAccountRepository.findById((long) 4).orElse(null);
		if(banckAccount!=null) {
System.out.println("*****");
System.out.println(banckAccount.getId());
System.out.println(banckAccount.getBalance());
System.out.println(banckAccount.getStatus());
System.out.println(banckAccount.getCreatedAt());
System.out.println(banckAccount.getCustomer().getName());
System.out.println(banckAccount.getClass().getSimpleName());
if(banckAccount instanceof CurrentAccount) {
System.out.println("OverDraft=>"+((CurrentAccount) banckAccount).getOverDraft());
}
else if (banckAccount instanceof SavingAccount) {
System.out.println("Rate=>"+((SavingAccount) banckAccount).getInterestRate());

}
banckAccount.getAccountOperations().forEach(op->{
System.out.println(op.getType()+"/t"+op.getOperationDate()+"/t"+op.getAmount());
});

	
		}	
		
		
		
		
		
		
		
		
	}
			
			;}

