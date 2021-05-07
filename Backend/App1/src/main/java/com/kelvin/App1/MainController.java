package com.kelvin.App1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private PeopleRepository peopleRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String address, @RequestParam String description) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        People people = new People();
//        people.setId(id);
        people.setName(name);
        people.setAddress(address);
        people.setDescription(description);
        peopleRepository.save(people);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<People> getAllUsers() {
        // This returns a JSON or XML with the users
        return peopleRepository.findAll();
    }
}
