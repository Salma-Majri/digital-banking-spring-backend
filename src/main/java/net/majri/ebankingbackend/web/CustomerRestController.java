package net.majri.ebankingbackend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.majri.ebankingbackend.dtos.CustomerDTO;
import net.majri.ebankingbackend.exceptions.CustomerNotFoundException;
import net.majri.ebankingbackend.services.BankAccountService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@Slf4j
public class CustomerRestController {
    private BankAccountService bankAccountService;

    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public List<CustomerDTO> customers(){
        return bankAccountService.listCustomers();
    }

    @GetMapping("/customers/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public CustomerDTO getCustomer(@PathVariable(name = "id") Long customerId) throws CustomerNotFoundException {
        return bankAccountService.getCustomer(customerId);
    }

    @PostMapping("/customers")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return bankAccountService.saveCustomer(customerDTO);
    }

    @PutMapping("/customers/{customerId}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public CustomerDTO updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO customerDTO){
        customerDTO.setId(customerId);
        return bankAccountService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/customers/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public void deleteCustomer(@PathVariable Long id){
        bankAccountService.deleteCustomer(id);
    }

    @GetMapping("/customers/search")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public List<CustomerDTO> searchCustomers(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
        return bankAccountService.searchCustomers("%" + keyword + "%");
    }
}