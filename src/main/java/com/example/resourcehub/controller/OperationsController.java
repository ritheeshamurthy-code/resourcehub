//package com.example.resourcehub.controller;
//
//public class OperationsController {
//}

package com.example.resourcehub.controller;

import com.example.resourcehub.*;
import com.example.resourcehub.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/operations")
@CrossOrigin(origins = "*")
public class OperationsController {

    @Autowired private CheckinRepository checkinRepository;
    @Autowired private NotificationRepository notificationRepository;
    @Autowired private MaintenanceRepository maintenanceRepository;
    @Autowired private AnalyticsSummaryRepository analyticsRepository;
    @Autowired private BookingRepository bookingRepository;

    // Check-in API (QR Scan Simulator)
    @PostMapping("/checkin/{bookingId}")
    public ResponseEntity<?> verifyCheckin(@PathVariable Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        checkin checkin = new checkin();
        checkin.setBooking(booking);
        checkin.setCheckinTime(LocalDateTime.now());
        checkin.setVerified(true);
        return ResponseEntity.ok(checkinRepository.save(checkin));
    }

    // Notifications API
    @GetMapping("/notifications/{userId}")
    public List<Notification> getUserNotifications(@PathVariable Long userId) {
        return notificationRepository.findByUser_UserId(userId);
    }

    // Maintenance API
    @PostMapping("/maintenance/schedule")
    public Maintenance scheduleMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    // Analytics API
    @GetMapping("/analytics")
    public List<AnalyticsSummary> getAnalytics() {
        return analyticsRepository.findAll();
    }
}
