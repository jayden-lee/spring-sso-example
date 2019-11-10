package com.jayden.authserver.config;

import com.jayden.authserver.domain.account.Account;
import com.jayden.authserver.domain.account.AccountRole;
import com.jayden.authserver.domain.account.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return new ApplicationRunner() {
            @Autowired
            AccountService accountService;

            @Override
            public void run(ApplicationArguments args) throws Exception {
                Account admin = Account.builder()
                    .username("admin")
                    .password("1234")
                    .roles(Set.of(AccountRole.ADMIN, AccountRole.USER))
                    .build();
                accountService.saveAccount(admin);

                Account user = Account.builder()
                    .username("user")
                    .password("1234")
                    .roles(Set.of(AccountRole.USER))
                    .build();
                accountService.saveAccount(user);
            }
        };
    }
}
