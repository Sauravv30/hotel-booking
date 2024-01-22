package com.hrs.booking.repository;


import com.hrs.booking.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Booking repository.
 */
@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

    /**
     * Find by user id optional.
     *
     * @param userId the user id
     * @return the optional
     */
    Optional<List<BookingEntity>> findByUserId(long userId);
//    Optional<HotelEntity> findByHotelAndRoomId(long hotelId, long roomId);
}
