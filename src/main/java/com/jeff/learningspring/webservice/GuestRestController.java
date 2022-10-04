package com.jeff.learningspring.webservice;

import com.jeff.learningspring.business.GuestService;
import com.jeff.learningspring.data.Guest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GuestRestController {

    private final GuestService guestService;

    public GuestRestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping(path = "/guests")
    public List<Guest> getAllGuests() {
        return guestService.findAllGuests();
    }

    @PostMapping(path = "/guest")
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest){
        guestService.saveGuest(guest);
        return new ResponseEntity<>(guest, HttpStatus.CREATED);
    }
}
