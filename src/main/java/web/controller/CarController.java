package web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.config.WebConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import hiber.model.Car;
import hiber.service.CarService;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    @GetMapping(value = "/start")
    public String startCar(@RequestParam("count") int count, ModelMap model){

        CarService carService = WebConfig.getApplicationContextS().getBean(CarService.class);

        List<Car> cars = carService.getCarList(count);


        model.addAttribute("cars", cars);

        return "/car/start";
    }

}
