package com.equipatour.coreservice.shared.util;
import com.equipatour.coreservice.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidationUtil {

    private final UserRepository userRepository;

    public ValidationUtil(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

//    public Vehicle findVehicleById(Long id) {
//        return vehicleRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id: " + id));
//    }

//    public Tourist findTouristById(Long id) {
//        return touristRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Tourist not found with id: " + id));
//    }


//    public Tourist findTouristByUserId(String id) {
//        return touristRepository.findByUserId(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Tourist not found with user id: " + id));
//    }
//
//    public Activity findActivityById(Long id) {
//        return activityRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Activity not found with id: " + id));
//    }
//
//    public Department findDepartmentById(Long id) {
//        return departmentRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
//    }
//
//    public Department findDepartmentByName(String name) {
//        return departmentRepository.findByName(name)
//                .orElseThrow(() -> new ResourceNotFoundException("Department not found with name: " + name));
//    }
//
//    public Destination findDestinationById(Long id) {
//        return destinationRepository.findById(id).orElse(new Destination());
//    }
//    public Region findRegionById(Long id) {
//        return regionRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Region not found with id: " + id));
//    }
//
//    public Schedule findTourExperienceById(Long id) {
//        return scheduleRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("TourExperience not found with id: " + id));
//    }
//
//    public TourPackage findTourPackageById(Long id) {
//        return tourPackageRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("TourPackage not found with id: " + id));
//    }

}
