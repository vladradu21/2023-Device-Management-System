package com.sd.devicemanagement.service.impl;

import com.sd.devicemanagement.dto.DeviceDTO;
import com.sd.devicemanagement.exceptions.DmConflictException;
import com.sd.devicemanagement.exceptions.DmNotFoundException;
import com.sd.devicemanagement.mapper.DeviceMapper;
import com.sd.devicemanagement.model.Device;
import com.sd.devicemanagement.model.User;
import com.sd.devicemanagement.repository.DeviceRepository;
import com.sd.devicemanagement.repository.UserRepository;
import com.sd.devicemanagement.service.DeviceService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;

    private final DeviceMapper deviceMapper;

    private final UserRepository userRepository;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository, DeviceMapper deviceMapper, UserRepository userRepository) {
        this.deviceRepository = deviceRepository;
        this.deviceMapper = deviceMapper;
        this.userRepository = userRepository;
    }

    @Override
    public DeviceDTO save(DeviceDTO deviceDTO, String username) {
        if(deviceRepository.findByNameAndUserUsername(deviceDTO.name(), username).isPresent()) {
            throw new DmConflictException("Device already exists");
        }

        User existingUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new DmNotFoundException("User not found"));

        Device deviceToSave = deviceMapper.toEntity(deviceDTO);
        deviceToSave.setUser(existingUser);
        Device savedDevice = deviceRepository.save(deviceToSave);
        return deviceMapper.toDTO(savedDevice);
    }

    @Override
    public DeviceDTO getByNameAndUsername(String name, String username) {
        return deviceRepository.findByNameAndUserUsername(name, username)
                .map(deviceMapper::toDTO)
                .orElseThrow(() -> new DmNotFoundException("Device not found"));
    }

    @Override
    public List<DeviceDTO> getAllByUsername(String username) {
        return deviceMapper.toDTOs(deviceRepository.findAllByUserUsername(username));
    }

    @Override
    public List<DeviceDTO> getAll() {
        return deviceMapper.toDTOs(deviceRepository.findAll());
    }

    @Override
    public void update(DeviceDTO deviceDTO, String username) {
        deviceRepository.findByNameAndUserUsername(deviceDTO.name(), username).ifPresent(device -> {
            device.setDescription(deviceDTO.description());
            device.setAddress(deviceDTO.address());
            device.setMaxConsumption(deviceDTO.maxConsumption());
            deviceRepository.save(device);
        });
    }

    @Override
    @Transactional
    public void delete(String name, String username) {
        deviceRepository.deleteByNameAndUserUsername(name, username);
    }
}
