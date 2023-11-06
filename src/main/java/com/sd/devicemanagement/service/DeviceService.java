package com.sd.devicemanagement.service;

import com.sd.devicemanagement.dto.DeviceDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public interface DeviceService {
    DeviceDTO save(DeviceDTO deviceDTO, String username);

    DeviceDTO getByNameAndUsername(String name, String username);

    List<DeviceDTO> getAllByUsername(String username);

    List<DeviceDTO> getAll();

    void update(DeviceDTO deviceDTO, String username);

    void delete(String name, String username);
}
