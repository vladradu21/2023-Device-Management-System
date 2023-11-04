package com.sd.devicemanagement.contoller;

import com.sd.devicemanagement.dto.DeviceDTO;
import com.sd.devicemanagement.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/devices")
@CrossOrigin("http://localhost:4200")
public class DeviceController {
    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping("/{username}")
    public DeviceDTO save(@RequestBody DeviceDTO deviceDTO, @PathVariable String username) {
        return deviceService.save(deviceDTO, username);
    }

    @GetMapping("/get/{name}/{username}")
    public DeviceDTO getByName(@PathVariable String name, @PathVariable String username) {
        return deviceService.getByNameAndUsername(name, username);
    }

    @GetMapping("/all/{username}")
    public List<DeviceDTO> getAll(@PathVariable String username) {
        return deviceService.getAllByUsername(username);
    }

    @GetMapping("/allDevices")
    public List<DeviceDTO> getAll() {
        return deviceService.getAll();
    }

    @PutMapping("/update/{username}")
    public void update(@RequestBody DeviceDTO deviceDTO, @PathVariable String username) {
        deviceService.update(deviceDTO, username);
    }

    @DeleteMapping("/delete/{name}/{username}")
    public void delete(@PathVariable String name, @PathVariable String username) {
        deviceService.delete(name, username);
    }
}
