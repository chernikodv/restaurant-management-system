package edu.northeastern.khoury.ds.security;

import edu.northeastern.khoury.ds.domain.model.Account;
import edu.northeastern.khoury.ds.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<Account> maybeAccount = accountRepository.findById(username);
        return maybeAccount.map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException("You've entered an incorrect email and password combination."));
    }
}
