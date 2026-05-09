package net.majri.ebankingbackend.repositories;

import net.majri.ebankingbackend.entities.AccountOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
}
