package com.sd.devicemanagement.mapper;

import com.sd.devicemanagement.dto.DeviceDTO;
import com.sd.devicemanagement.model.Device;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeviceMapper {
    DeviceDTO toDTO(Device device);

    List<DeviceDTO> toDTOs(List<Device> devices);

    Device toEntity(DeviceDTO deviceDTO);

    List<Device> toEntities(List<DeviceDTO> deviceDTOs);
}
