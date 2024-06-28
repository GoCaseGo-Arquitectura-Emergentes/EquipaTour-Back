package com.equipatour.coreservice;
import static org.junit.jupiter.api.Assertions.*;
import com.equipatour.coreservice.core.tourmanagement.domain.model.TourPackage;
import com.equipatour.coreservice.core.tourmanagement.resources.summaries.TourPackageSummaryDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.equipatour.coreservice.core.tourmanagement.mapper.TourMapperImpl;

public class TourMapperImplTest {

    private TourMapperImpl tourMapper;

    @BeforeEach
    public void setUp() {
        tourMapper = new TourMapperImpl();
    }

    @Test
    public void testMapEntityToDto() {
        // Crea una entidad de ejemplo
        TourPackage tourEntity = new TourPackage();
        tourEntity.setPackageName("Test Tour");
        tourEntity.setAvailableSlots(10L);
        tourEntity.setGuideName("Test Guide");


        // Mapea la entidad al DTO
        TourPackageSummaryDto tourDTO = tourMapper.tourPackageToSummaryDto(tourEntity);

        // Verifica que los campos se mapearon correctamente
        assertEquals("Test Tour", tourDTO.getPackageName());
        assertEquals(10L, tourDTO.getAvailableSlots());
        assertEquals("Test Guide", tourDTO.getGuideName());
    }
}

