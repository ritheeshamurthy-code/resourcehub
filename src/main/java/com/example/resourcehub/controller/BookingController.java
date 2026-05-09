//package com.example.resourcehub.controller;
//
//public class BookingController {
//}

package com.example.resourcehub.controller;

import com.example.resourcehub.Booking;
import com.example.resourcehub.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        // 1. Check for Conflicts directly in the controller
        List<Booking> conflicts = bookingRepository.findConflicts(
                booking.getResource().getResourceId(),
                booking.getStartTime(),
                booking.getEndTime()
        );

        if (!conflicts.isEmpty()) {
            return ResponseEntity.badRequest().body("POTENTIAL CONFLICT: Resource is already booked during this time.");
        }

        // 2. Save if no conflicts
        booking.setStatus("APPROVED");
        Booking savedBooking = bookingRepository.save(booking);
        return ResponseEntity.ok(savedBooking);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getUserBookings(@PathVariable Long userId) {
        return bookingRepository.findByUser_UserId(userId);
    }

    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
