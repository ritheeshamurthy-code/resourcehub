//package com.example.resourcehub;
//
//public class Maintainance {
//}


package com.example.resourcehub;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "maintenance")
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maintenance_id")
    private Long maintenanceId;

    @ManyToOne
    @JoinColumn(name = "resource_id", nullable = false)
    private Resource resource;

    @Column(name = "issue_description")
    private String issueDescription;

    @Column(name = "maintenance_start")
    private LocalDate maintenanceStart;

    @Column(name = "maintenance_end")
    private LocalDate maintenanceEnd;

    private String status = "PENDING"; // PENDING, IN_PROGRESS, COMPLETED

    // TODO: Generate Standard Getters and Setters
}
