package com.algaworks.algasensors.temperature.processing;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

class UUIDv7Test {

    @Test
    void shouldGenerateUUIDv7() {
        UUID uuid1 = IdGenerator.generateTimeBasedUUID();
        UUID uuid2 = IdGenerator.generateTimeBasedUUID();
        UUID uuid3 = IdGenerator.generateTimeBasedUUID();
        UUID uuid4 = IdGenerator.generateTimeBasedUUID();

        // Na versão 7, é possível extrair a data e hora que o UUID foi gerado
        System.out.println(UUIDv7Utils.extractOffsetDateTime(uuid1));
        System.out.println(UUIDv7Utils.extractOffsetDateTime(uuid2));
        System.out.println(UUIDv7Utils.extractOffsetDateTime(uuid3));
        System.out.println(UUIDv7Utils.extractOffsetDateTime(uuid4));

        OffsetDateTime uuid1DateTime = UUIDv7Utils.extractOffsetDateTime(uuid1).truncatedTo(ChronoUnit.MINUTES);
        OffsetDateTime currentDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.MINUTES);

        assertThat(uuid1DateTime).isEqualTo(currentDateTime);
    }

}
