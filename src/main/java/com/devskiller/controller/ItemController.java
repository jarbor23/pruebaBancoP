package com.devskiller.controller;

import com.devskiller.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ItemController {
    @Autowired
    ItemService itemService;
    @GetMapping("/titles")
    public  @ResponseBody List<String> getTitles(@RequestParam Double rating) {
        return itemService.getTitlesWithAverageRatingLowerThan(rating);
    }
}
