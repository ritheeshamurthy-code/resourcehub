//package com.example.resourcehub.controller;
//
//public class ResourceController {
//}

package com.example.resourcehub.controller;

import com.example.resourcehub.Resource;
import com.example.resourcehub.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
@CrossOrigin(origins = "*")
public class ResourceController {

    @Autowired
    private ResourceRepository resourceRepository;

    @GetMapping
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    @GetMapping("/available")
    public List<Resource> getAvailableResources() {
        return resourceRepository.findByStatus("AVAILABLE");
    }

    @PostMapping("/add")
    public Resource addResource(@RequestBody Resource resource) {
        return resourceRepository.save(resource);
    }
}
