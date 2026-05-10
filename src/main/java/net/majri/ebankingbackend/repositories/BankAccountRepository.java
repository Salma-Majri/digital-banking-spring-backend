package net.majri.ebankingbackend.repositories;

import net.majri.ebankingbackend.entities.BankAccount;
import net.majri.ebankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}