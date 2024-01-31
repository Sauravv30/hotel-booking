package com.hrs.booking.mapper;

import com.hrs.booking.entity.BookingEntity;
import com.hrs.booking.model.Booking;
import org.mapstruct.Mapper;

/**
 * The interface Booking mapper.
 */
@Mapper(componentModel = "spring")
public interface BookingMapper {
    /**
     * Model to entity booking entity.
     *
     * @param booking the booking
     * @return the booking entity
     */
    BookingEntity modelToEntity(Booking booking);

    /**
     * Entity to model booking.
     *
     * @param bookingEntity the booking entity
     * @return the booking
     */
    Booking entityToModel(BookingEntity bookingEntity);

}
