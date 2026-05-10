package net.majri.ebankingbackend.dtos;

import lombok.Data;
import net.majri.ebankingbackend.enums.AccountStatus;
import java.util.Date;

@Data
public class SavingBankAccountDTO extends BankAccountDTO{
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double interestRate;

}
