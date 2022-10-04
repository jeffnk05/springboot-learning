package com.jeff.learningspring.webservice;

import com.jeff.learningspring.business.RoomService;
import com.jeff.learningspring.data.Room;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomRestController {

    private final RoomService roomService;

    public RoomRestController(RoomService roomService) {
        this.roomService = roomService;
    }

   @GetMapping(path = "/rooms")
    public List<Room> getRooms() {
        return roomService.getAllRooms();
   }
}
