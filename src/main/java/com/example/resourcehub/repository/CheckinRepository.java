//package com.example.resourcehub.repository;
//
//public class CheckinRepository {
//}

package com.example.resourcehub.repository;

import com.example.resourcehub.checkin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckinRepository extends JpaRepository<checkin, Long> {
    checkin findByBooking_BookingId(Long bookingId);
}
