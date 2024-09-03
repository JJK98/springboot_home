package com.std.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class PersonController {
    int count;
    ArrayList<Person> People;
    PersonController(){
        count = 0;
        People = new ArrayList<Person>();
    }
    @GetMapping("/person/add")
    public String addPerson(@RequestParam("name")String name, @RequestParam("age")int age){
        count++;
        Person person = new Person(count, name, age);
        People.add(person);
        return String.format("%d번째 사람이 추가되었습니다.",count);

    }
    @GetMapping("/person/people")
    public List<Person> PeopleList(){
        return People;
    }

    @GetMapping("/person/remove")
    public String removePerson(@RequestParam("id") int id){
        Person person = FindId(id);
        if(person == null){
            return id+"번째 사람이 존재하지 않습니다.";
        } else{
            People.remove(person);
            return id+"번째 사람이 삭제되었습니다.";
        }
    }
    @GetMapping("/person/modify")
    public String modifyPerson(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("age") int age){
        Person person = FindId(id);
        if(person == null){
            return id+"번째 사람이 존재하지 않습니다.";
        } else{
            person.setName(name);
            person.setAge(age);
            return id+"번째 사람이 수정되었습니다.";
        }
    }


    public Person FindId(int id){
        Person FindId = null;
        for(Person item : People){
            if(item.getId() == id) FindId = item;
        }
        return FindId;
    }
}

@AllArgsConstructor
@Getter
@Setter
class Person {
    private int id;
    private String name;
    private int age;
}