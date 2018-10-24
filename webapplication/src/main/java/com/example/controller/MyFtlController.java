package com.example.controller;

import com.example.entity.City;
import com.example.service.CityService;
import com.itextpdf.text.pdf.BaseFont;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@ApiIgnore
public class MyFtlController {
    @Autowired
    private CityService cityService;

    private static Logger logger = LoggerFactory.getLogger(MyFtlController.class);

    @RequestMapping(value = "/ftl/city/{name}", method = RequestMethod.GET)
    public String findOneCity(Model model, @PathVariable("name") String name) {
        City city = new City(3, "aaa", "bbb", "cccc");
        model.addAttribute("city", city);
        return "city";
    }

}