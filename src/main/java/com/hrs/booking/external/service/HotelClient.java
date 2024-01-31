package com.hrs.booking.external.service;

import com.hrs.booking.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The interface Hotel client.
 */
@FeignClient(value = "Hotel-Service", fallback = HotelClientFallback.class)
public interface HotelClient {
    /**
     * Request hotel booking room.
     *
     * @param roomId the room id
     * @param status the status
     * @return the room
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/room/book/{roomId}/{status}")
    Room requestHotelBooking(@PathVariable("roomId") Long roomId, @PathVariable("status") String status);
}

/**
 * The type Hotel client fallback.
 */
class HotelClientFallback implements HotelClient {

    @Override
    public Room requestHotelBooking(Long roomId, String status) {
        return new Room(String.valueOf(roomId), false);
    }
}
