package net.majri.ebankingbackend.dtos;

import lombok.Data;
import net.majri.ebankingbackend.entities.Customer;
import net.majri.ebankingbackend.enums.AccountStatus;

import javax.persistence.*;
import java.util.Date;
@Data
public class CurrentBankAccountDTO extends BankAccountDTO {
    @Id
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double overDraft;

}
