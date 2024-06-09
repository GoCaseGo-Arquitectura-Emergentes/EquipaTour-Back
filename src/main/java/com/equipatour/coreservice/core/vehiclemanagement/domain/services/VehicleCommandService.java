package com.equipatour.coreservice.core.vehiclemanagement.domain.services;

import com.equipatour.coreservice.core.vehiclemanagement.domain.commands.CreateVehicleCommand;
import com.equipatour.coreservice.core.vehiclemanagement.domain.commands.DeleteVehicleCommand;
import com.equipatour.coreservice.core.vehiclemanagement.domain.commands.UpdateVehicleCommand;
import com.equipatour.coreservice.core.vehiclemanagement.domain.model.Vehicle;
import com.equipatour.coreservice.core.vehiclemanagement.domain.queries.GetVehicleByIdQuery;

import java.util.List;

public interface VehicleCommandService {

    List<Vehicle> handle();

    Vehicle handle(CreateVehicleCommand commandFromDto);

    Vehicle handle(GetVehicleByIdQuery command);

    Vehicle handle(UpdateVehicleCommand command);

    Vehicle handle(DeleteVehicleCommand command);

}

