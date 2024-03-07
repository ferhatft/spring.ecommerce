package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Likes;
import com.example.spring_ecommerce.entities.Wishlist;

import java.util.List;
import java.util.Optional;

public interface LikesService {
    List<Likes> getAll();

    Optional<Likes> getByID(int id);

    void add(Likes likes);

    void update(Likes likes);

    void delete(int id);
}
