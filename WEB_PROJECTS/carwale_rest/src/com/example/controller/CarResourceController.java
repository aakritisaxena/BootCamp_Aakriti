package com.example.controller;

import com.example.dao.CarDAO;
import com.example.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.http.MediaType.TEXT_XML_VALUE;
import static org.springframework.util.MimeTypeUtils.APPLICATION_XML_VALUE;

@RestController
public class CarResourceController {

    @Autowired
    CarDAO  carDAO;




    @RequestMapping(value = "car", produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)

    public Car readCarAsJSON() {
        Car car = carDAO.selectByVin(1000);
        return car;
    }

//    @RequestMapping(value = "car", produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)
//    public String readCarAsJSON() {
//        return "{\"vin\":100,\"model\":7, \"make\":\"Audi\", \"price\":200000, \"quantity\":10}";
//    }

    @RequestMapping(value = "car", produces = APPLICATION_XML_VALUE, method = RequestMethod.GET)
    public Car readCarAsXML() {
        Car car = carDAO.selectByVin(1000);
        return car;
       // return "<vin> 100</vin>,<model> 07</model>, <make>Audi</make>, <price>200000</price>, <quantity>10</quantity>";
    }

    //@RequestMapping(value = "car",produces = "text/plain",method = RequestMethod.GET)
    @RequestMapping(value = "car", produces = TEXT_PLAIN_VALUE, method = RequestMethod.GET)
    public String readCar() {
        return "vin - 100,model - 07, make- Audi, price-200000, quantity-10";
    }
}
