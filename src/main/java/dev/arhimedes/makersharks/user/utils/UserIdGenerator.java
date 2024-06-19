package dev.arhimedes.makersharks.user.utils;

import dev.arhimedes.makersharks.helper.reposiotries.CountRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class UserIdGenerator implements IdentifierGenerator {

    private static final String PREFIX = "UID";

    private final ApplicationContext applicationContext;

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {

        var countRepository = applicationContext.getBean(CountRepository.class);
        String value = PREFIX + LocalDate.now().getYear() + countRepository.getCustomerCount();
        countRepository.incrementUserCount();
        return value;
    }
}
