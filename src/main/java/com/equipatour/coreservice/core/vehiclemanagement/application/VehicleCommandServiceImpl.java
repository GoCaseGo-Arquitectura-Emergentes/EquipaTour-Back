package com.equipatour.coreservice.core.vehiclemanagement.application;


import com.equipatour.coreservice.core.vehiclemanagement.domain.commands.CreateVehicleCommand;
import com.equipatour.coreservice.core.vehiclemanagement.domain.commands.DeleteVehicleCommand;
import com.equipatour.coreservice.core.vehiclemanagement.domain.commands.UpdateVehicleCommand;
import com.equipatour.coreservice.core.vehiclemanagement.domain.model.Vehicle;
import com.equipatour.coreservice.core.vehiclemanagement.domain.queries.GetVehicleByIdQuery;
import com.equipatour.coreservice.core.vehiclemanagement.domain.repositories.VehicleRepository;
import com.equipatour.coreservice.core.vehiclemanagement.domain.services.VehicleCommandService;
import com.equipatour.coreservice.shared.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleCommandServiceImpl implements VehicleCommandService {

    private final VehicleRepository vehicleRepository;

    public VehicleCommandServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> handle() {
        return vehicleRepository.findAll(Sort.by(Sort.Order.asc("createdDate")));
    }

    @Override
    public Vehicle handle(UpdateVehicleCommand command) {
        Vehicle vehicle = vehicleRepository.findById(command.id())
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id: " + command.id()));

        vehicle.setVehicleState(command.requestDto().getVehicleState());
        vehicle.setVehicleModel(command.requestDto().getVehicleModel());
        vehicle.setVehicleBrand(command.requestDto().getVehicleBrand());
        vehicle.setVehicleWeight(command.requestDto().getVehicleWeight());
        vehicle.setVehicleDriver(command.requestDto().getVehicleDriver());
        vehicle.setVehicleSeats(command.requestDto().getVehicleSeats());
        vehicle.setVehicleAgency(command.requestDto().getVehicleAgency());
        vehicleRepository.save(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle handle(GetVehicleByIdQuery command) {
        return vehicleRepository.findById(command.id())
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id: " + command.id()));
    }

    @Override
    public Vehicle handle(CreateVehicleCommand commandFromDto) {
        Vehicle vehicle = new Vehicle(commandFromDto.requestDto());
        vehicleRepository.save(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle handle(DeleteVehicleCommand command) {
        Vehicle vehicle = vehicleRepository.findById(command.id())
                .orElseThrow(() -> new ResourceNotFoundException("TourPackage not found with id: " + command.id()));
        vehicleRepository.deleteById(vehicle.getId());
        return vehicle;
    }
}
