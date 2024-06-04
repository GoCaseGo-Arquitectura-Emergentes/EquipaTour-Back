package com.equipatour.coreservice.shared.util;

import com.equipatour.coreservice.shared.domain.model.SerieNumber;
import com.equipatour.coreservice.shared.domain.repositories.SerieNumberRepository;
import com.equipatour.coreservice.shared.exceptions.BusinessRuleException;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SerieNumberUtil {

    private final SerieNumberRepository serieNumberRepository;

    @Autowired
    public SerieNumberUtil(SerieNumberRepository serieNumberRepository) {
        this.serieNumberRepository = serieNumberRepository;
    }

    public SerieNumber generateCorrelative(@NotNull String type) {
        Optional<SerieNumber> serieNumberOptional = serieNumberRepository.findByType(type);
        if (serieNumberOptional.isPresent()) {
            SerieNumber update = serieNumberOptional.get();
            update.setNumber(String.format("%0" + update.getDigits() + "d", Integer.parseInt(update.getNumber()) + 1));
            return update;
        } else {
            throw new BusinessRuleException("No se encontro el correlativo para el tipo " + type);
        }
    }

}
