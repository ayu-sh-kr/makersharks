package dev.arhimedes.makersharks.helper.runners;

import dev.arhimedes.makersharks.helper.model.CountModel;
import dev.arhimedes.makersharks.helper.reposiotries.CountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationRunner implements CommandLineRunner {

    private final CountRepository countRepository;

    @Override
    public void run(String... args) {
        if(countRepository.existsById(1)){
            return;
        }
        CountModel countModel = new CountModel(1, 1);
        countRepository.save(countModel);
    }
}
