package com.jeff.learningspring.util;

import com.jeff.learningspring.data.Guest;
import com.jeff.learningspring.data.GuestRepository;
import com.jeff.learningspring.data.Room;
import com.jeff.learningspring.data.RoomRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;

    public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        Iterable<Guest> guests = this.guestRepository.findAll();
        rooms.forEach(System.out::println);
        guests.forEach(System.out::println);
    }
}
