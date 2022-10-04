package com.jeff.learningspring.business;

import com.jeff.learningspring.data.Guest;
import com.jeff.learningspring.data.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> findAllGuests(){
        List<Guest> guests = (List<Guest>) guestRepository.findAll();
        if(guests != null) {
            return guests;
        } else {
            throw new RuntimeException("There are no Guests");
        }
    }

    public Guest saveGuest(Guest guest){
        return guestRepository.save(guest);
    }
}
