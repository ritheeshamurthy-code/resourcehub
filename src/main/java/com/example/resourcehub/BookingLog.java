//package com.example.resourcehub;
//
//public class BookingLog {
//}

package com.example.resourcehub;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking_logs")
public class BookingLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long logId;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @Column(name = "action_type", nullable = false)
    private String actionType;

    private String remarks;

    @Column(name = "action_time", insertable = false, updatable = false)
    private LocalDateTime actionTime;

    // TODO: Generate Standard Getters and Setters
}
