package hu.unideb.inf.kaloriaszamlalo.service.impl;

import hu.unideb.inf.kaloriaszamlalo.data.repository.SzemelyRepository;
import hu.unideb.inf.kaloriaszamlalo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    SzemelyRepository repo;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return repo.findByEmail(username);
            }
        };
    }
}
