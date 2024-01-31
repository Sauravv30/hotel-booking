package com.hrs.booking.service;

import com.hrs.booking.constants.BookingStatus;
import com.hrs.booking.entity.BookingEntity;
import com.hrs.booking.exception.BookingCustomException;
import com.hrs.booking.exception.NotFoundCustomException;
import com.hrs.booking.external.service.HotelClient;
import com.hrs.booking.mapper.BookingMapper;
import com.hrs.booking.model.Booking;
import com.hrs.booking.model.Room;
import com.hrs.booking.repository.BookingRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Booking service.
 */
@Service
@AllArgsConstructor
public class BookingService {
    private BookingRepository bookingRepository;
    private BookingMapper bookingMapper;
    private HotelClient hotelClient;

    /**
     * Get booking by id booking.
     *
     * @param bookingId the booking id
     * @return the booking
     */
    public Booking getBookingById(long bookingId){
        return bookingMapper.entityToModel(getBookingFromId(bookingId));
    }

    private BookingEntity getBookingFromId(long id){
        return bookingRepository.findById(id).orElseThrow(()->new NotFoundCustomException("Did not find booking for this id"+id));
    }

    /**
     * Get booking by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    public List<Booking> getBookingByUserId(long userId){
        List<BookingEntity> persistedEntities = bookingRepository.findByUserId(userId).orElseThrow(() -> new NotFoundCustomException("Did not find booking for this user id" + userId));
        return persistedEntities.stream().map(bookingMapper::entityToModel).collect(Collectors.toList());
    }

    /**
     * Create booking list.
     *
     * @param userId  the user id
     * @param booking the booking
     * @return the list
     */
    public List<Booking> createBooking(Long userId, List<Booking> booking){
        List<BookingEntity> persistedEntities = new ArrayList<>();
        List<BookingEntity> listOfBooking = booking.stream().map(singleBooking -> {
            singleBooking.setUserId(userId);
            singleBooking.setBookingDate(LocalDate.now());
            return singleBooking;
        }).map(bookingMapper::modelToEntity).collect(Collectors.toList());
        try {
        persistedEntities = bookingRepository.saveAll(listOfBooking);
       // persistedEntities.stream().forEach(entity -> hotelClient.requestHotelBooking(entity.getRoomId(), "Booking"));
        }
        catch (Exception e){
            throw new BookingCustomException("Room is already booked by user");
        }
        return persistedEntities.stream().map(bookingMapper::entityToModel).collect(Collectors.toList());
    }

    /**
     * Update booking booking.
     *
     * @param bookingId the booking id
     * @param booking   the booking
     * @return the booking
     */
    public Booking updateBooking(long bookingId, Booking booking){
        BookingEntity persistedEntity = getBookingFromId(bookingId);
        BookingEntity newEntity = bookingMapper.modelToEntity(booking);
        newEntity.setId(persistedEntity.getId());
        // room service update
        return bookingMapper.entityToModel(bookingRepository.save(newEntity));
    }

    /**
     * Cancel booking booking.
     *
     * @param bookingId the booking id
     * @return the booking
     */
    @Transactional
    public Booking cancelBooking(long bookingId){
        BookingEntity persistedEntity = getBookingFromId(bookingId);
        persistedEntity.setBookingStatus(BookingStatus.CANCELLED);
        Room roomDetails = hotelClient.requestHotelBooking(persistedEntity.getRoomId(),"Cancel");
        if (roomDetails.getBooked()) {
            throw new BookingCustomException("Room status not updated");
        }
        //room service call to make the room available
        return bookingMapper.entityToModel(bookingRepository.save(persistedEntity));
    }
}
