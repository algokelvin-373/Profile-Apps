package com.kelvin.App1;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private PeopleRepository peopleRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests - Using Params
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String address, @RequestParam String description) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        setDataPeople(name, address, description);
        return "Saved";
    }

    @PostMapping(path="/v2/add") // Map ONLY POST Requests - Using Params
    public @ResponseBody String addUser(@RequestBody String reqPeople) {
        JSONObject jsonReq = new JSONObject(reqPeople);
        String name = jsonReq.getString("name");
        String address = jsonReq.getString("address");
        String description = jsonReq.getString("description");
        System.out.println("Data People: " + jsonReq.toString());

        setDataPeople(name, address, description);

        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<People> getAllUsers() {
        // This returns a JSON or XML with the users
        return peopleRepository.findAll();
    }

    private void setDataPeople(String name, String address, String description) {
        People people = new People();
        people.setName(name);
        people.setAddress(address);
        people.setDescription(description);
        peopleRepository.save(people);
    }
}
