package com.jeff.learningspring.business;

import com.jeff.learningspring.data.Room;
import com.jeff.learningspring.data.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        List<Room> rooms = (List<Room>) roomRepository.findAll();
        if (rooms != null) {
            return rooms;
        } else {
            throw new RuntimeException("There are no rooms");
        }
    }
}
