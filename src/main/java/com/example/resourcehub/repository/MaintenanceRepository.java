//package com.example.resourcehub.repository;
//
//public class MaintenanceRepository {
//}
package com.example.resourcehub.repository;

import com.example.resourcehub.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
    List<Maintenance> findByResource_ResourceId(Long resourceId);
}