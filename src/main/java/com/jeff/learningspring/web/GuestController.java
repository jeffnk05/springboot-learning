package com.jeff.learningspring.web;

import com.jeff.learningspring.business.GuestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getGuests(){
        guestService.findAllGuests();
        return "guests";
    }
}
