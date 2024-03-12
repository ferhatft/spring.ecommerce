package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.City;
import com.example.spring_ecommerce.entities.Likes;
import com.example.spring_ecommerce.services.abstracts.LikesService;
import com.example.spring_ecommerce.services.dtos.like.request.AddLikeRequest;
import com.example.spring_ecommerce.services.dtos.like.request.UpdateLikeRequest;
import com.example.spring_ecommerce.services.dtos.like.response.ListLikesResponse;
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
    public List<ListLikesResponse> get(){
        return likesService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Likes> getByID(@PathVariable int id) {
        return likesService.getByID(id);
    }

    @PostMapping()
    public void add(@RequestBody AddLikeRequest request){
        likesService.add(request);
    }

    @PutMapping
    public void update(@RequestBody UpdateLikeRequest request) {
        likesService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        likesService.delete(id);
    }

}
