package dev.arhimedes.makersharks;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class MakersharksApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void writeDocumentationSnippets() {

        var modules = ApplicationModules.of(MakersharksApplication.class).verify();

        new Documenter(modules)
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml();
    }

}
