//package com.example.resourcehub.repository;
//
//public class AnalyticsSummaryRepository {
//}

package com.example.resourcehub.repository;

import com.example.resourcehub.AnalyticsSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalyticsSummaryRepository extends JpaRepository<AnalyticsSummary, Long> {
    AnalyticsSummary findByResource_ResourceId(Long resourceId);
}
