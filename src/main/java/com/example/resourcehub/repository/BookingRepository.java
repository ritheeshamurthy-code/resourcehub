package com.example.resourcehub.repository;

import com.example.resourcehub.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    // The Magic Query: Checks if a room is already booked during the requested time!
    @Query("SELECT b FROM Booking b WHERE b.resource.resourceId = :resourceId " +
            "AND b.status = 'APPROVED' " +
            "AND ((b.startTime < :endTime AND b.endTime > :startTime))")
    List<Booking> findConflicts(@Param("resourceId") Long resourceId,
                                @Param("startTime") LocalDateTime startTime,
                                @Param("endTime") LocalDateTime endTime);

    List<Booking> findByUser_UserId(Long userId);
}