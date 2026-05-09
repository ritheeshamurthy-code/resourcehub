package com.example.resourcehub;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "analytics_summary")
public class AnalyticsSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analytics_id")
    private Long analyticsId;

    @OneToOne
    @JoinColumn(name = "resource_id", nullable = false)
    private Resource resource;

    @Column(name = "total_bookings")
    private Integer totalBookings = 0;

    @Column(name = "total_usage_hours")
    private Integer totalUsageHours = 0;

    @Column(name = "no_show_count")
    private Integer noShowCount = 0;

    @Column(name = "cancellation_count")
    private Integer cancellationCount = 0;

    @Column(name = "utilization_percentage")
    private Double utilizationPercentage;

    @Column(name = "last_updated", insertable = false, updatable = false)
    private LocalDateTime lastUpdated;

    // TODO: Generate Standard Getters and Setters
}