package com.jeff.learningspring.web;

import com.jeff.learningspring.business.GuestService;
import com.jeff.learningspring.data.Guest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getGuest(Model model){
        List<Guest> guests = guestService.findAllGuests();
        model.addAttribute("guest", guests);
        return "hotel-guests";
    }
}
