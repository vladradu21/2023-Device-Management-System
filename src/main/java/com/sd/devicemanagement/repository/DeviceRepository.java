package com.sd.devicemanagement.repository;

import com.sd.devicemanagement.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
    Optional<Device> findByNameAndUserUsername(String name, String username);

    List<Device> findAllByUserUsername(String username);


    List<Device> findAll();

    void deleteByNameAndUserUsername(String name, String username);
}
