package com.algaworks.algasensors.temperature.processing;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.UUID;

public class UUIDv7Utils {
    private UUIDv7Utils() {
    }

    public static OffsetDateTime extractOffsetDateTime(UUID uuidv7) {
        if (uuidv7 == null) {
            return null;
        }

        // Bytewise operation
        // Extrai os bits mais significativos do UUIDv7 e remove os bits de versão e variante
        long timestamp = uuidv7.getMostSignificantBits() >>> 16; // Extract the timestamp from the UUIDv7

        return OffsetDateTime.ofInstant(java.time.Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());

        // Extract the timestamp from the UUIDv7 string -- IA
        // long timestamp = Long.parseLong(uuidv7.substring(0, 13), 16);
        // return OffsetDateTime.ofInstant(java.time.Instant.ofEpochMilli(timestamp), java.time.ZoneOffset.UTC);
    }
}
