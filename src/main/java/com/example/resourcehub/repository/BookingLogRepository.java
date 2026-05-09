//package com.example.resourcehub.repository;
//
//public class BookingLogRepository {
//}

package com.example.resourcehub.repository;

import com.example.resourcehub.BookingLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingLogRepository extends JpaRepository<BookingLog, Long> {
    List<BookingLog> findByBooking_BookingId(Long bookingId);
}
