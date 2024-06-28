package com.equipatour.coreservice;
import static org.junit.jupiter.api.Assertions.*;
import com.equipatour.coreservice.core.vehiclemanagement.domain.model.Vehicle;
import com.equipatour.coreservice.core.vehiclemanagement.resources.summaries.VehicleSummaryDto;
import com.equipatour.coreservice.shared.domain.model.VehicleStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.equipatour.coreservice.core.vehiclemanagement.mapper.VehicleMapper;

import java.util.List;

public class VehicleMapperImplTest {

    private VehicleMapper vehicleMapper;

    @BeforeEach
    public void setUp() {
        vehicleMapper = new VehicleMapper() {
            @Override
            public VehicleSummaryDto vehicleToSummaryDto(Vehicle entity) {
                return null;
            }

            @Override
            public List<VehicleSummaryDto> vehicleToSummaryDtos(List<Vehicle> entities) {
                return null;
            }
        };
    }

    @Test
    public void testMapEntityToDto() {
        // Crea una entidad de ejemplo
        Vehicle vehicleEntity = new Vehicle();
        vehicleEntity.setVehicleState(VehicleStatus.SIN_ASIGNAR);
        vehicleEntity.setVehicleModel("Test Model");
        vehicleEntity.setVehicleBrand("Test Brand");
        vehicleEntity.setVehicleWeight(10L);
        vehicleEntity.setVehicleDriver("Test Driver");
        vehicleEntity.setVehicleSeats(10L);
        vehicleEntity.setVehicleAgency("Test Agency");

        // Mapea la entidad al DTO
        VehicleSummaryDto vehicleDTO = vehicleMapper.vehicleToSummaryDto(vehicleEntity);

        // Verifica que los campos se mapearon correctamente
        assertEquals(VehicleStatus.SIN_ASIGNAR, vehicleDTO.getVehicleState());
        assertEquals("Test Model", vehicleDTO.getVehicleModel());
        assertEquals("Test Brand", vehicleDTO.getVehicleBrand());
        assertEquals(10L, vehicleDTO.getVehicleWeight());
        assertEquals("Test Driver", vehicleDTO.getVehicleDriver());
        assertEquals(10L, vehicleDTO.getVehicleSeats());
        assertEquals("Test Agency", vehicleDTO.getVehicleAgency());
    }
}
