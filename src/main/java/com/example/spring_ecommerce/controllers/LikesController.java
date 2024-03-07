package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.City;
import com.example.spring_ecommerce.entities.Likes;
import com.example.spring_ecommerce.services.abstracts.LikesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/likes")
@AllArgsConstructor
public class LikesController {

    private LikesService likesService;


    @GetMapping
    public List<Likes> get(){
        return likesService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Likes> getByID(@PathVariable int id) {
        return likesService.getByID(id);
    }

    @PostMapping()
    public void add(@RequestBody Likes likes){
        likesService.add(likes);
    }

    @PutMapping
    public void update(@RequestBody Likes likes) {
        likesService.update(likes);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        likesService.delete(id);
    }

}
