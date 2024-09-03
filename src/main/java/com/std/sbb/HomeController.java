package com.std.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class HomeController {
    int count = -1;
    @GetMapping("/home/main")
    @ResponseBody
    public String showMain(){
        return "안녕하세요.";
    }
    @GetMapping("/home/main2")
    @ResponseBody
    public String showMain2(){
        return "반갑습니다.";
    }
    @GetMapping("/home/main3")
    @ResponseBody
    public String showMain3(){
        return "즐거웠습니다.";
    }
    @GetMapping("/home/increcement")
    @ResponseBody
    public int showIncrecement(){
        count++;
        return count;
    }

    @GetMapping("/home/minus")
    @ResponseBody
    public int showMinus(@RequestParam(value = "a", defaultValue = "0")int a, @RequestParam(value = "b", defaultValue = "0") int b){
        return a-b;
    }

    @GetMapping("/home/multiply")
    @ResponseBody
    public int showMutiply(@RequestParam(value = "a", defaultValue = "0")int a, @RequestParam(value = "b", defaultValue = "0") int b){
        return a*b;
    }

    @GetMapping("/home/divide")
    @ResponseBody
    public int showDivide(@RequestParam(value = "a", defaultValue = "0")int a, @RequestParam(value = "b", defaultValue = "0") int b){
        return a/b;
    }

    @GetMapping("/home/plus")
    @ResponseBody
    public int showPlus(@RequestParam(value = "a", defaultValue = "0")int a, @RequestParam(value = "b", defaultValue = "0") int b){
        return a+b;
    }

    @GetMapping("/home/remain")
    @ResponseBody
    public int showRemain(@RequestParam(value = "a", defaultValue = "0")int a, @RequestParam(value = "b", defaultValue = "0") int b){
        return a%b;
    }
    @GetMapping("/home/returnCar")
    @ResponseBody
    public Car showReturnCar(){
        Car car = new Car(1,100,"벤츠",new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
        }});

        car.setId(2);
        car.setName("아우디");
        car.setSpeed(200);
        car.setIds(new ArrayList<>(){{
            add(4);
            add(5);
            add(6);
        }});
        return car;
    }

}


