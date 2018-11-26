package com.start.springOne.controller;

import com.start.springOne.dto.PersonDto;
import com.start.springOne.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController // spring ma odczytac to tak jakbym hostowal
public class HelloController {

    private PersonRepository personRepository;

    @Autowired
    public HelloController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping ("/hello")// pod jakim adresem ma byc dostepna usluga, endpointer
    public String hello (){
        return "hello world !!!";

    }

    @RequestMapping("/person")
    public Optional<PersonDto> findById
            (@RequestParam(value="id") Long id){

        return personRepository.findById(id);
    }

    @RequestMapping("/save")
    public @ResponseBody String saveUser
            (@RequestParam(value = "firstName") String firstName,@RequestParam("age") int age, @RequestParam(value = "address")
             String address, @RequestParam(value = "sex") String sex) {

        PersonDto n = new PersonDto();
        n.setAddress(address);
        n.setAge(age);
        n.setFirstName(firstName);
        n.setSex(sex);

        personRepository.save(n);
        return "Save";

    }


}
