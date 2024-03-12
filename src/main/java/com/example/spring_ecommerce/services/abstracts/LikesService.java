package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Likes;
import com.example.spring_ecommerce.entities.Wishlist;
import com.example.spring_ecommerce.services.dtos.like.request.AddLikeRequest;
import com.example.spring_ecommerce.services.dtos.like.request.UpdateLikeRequest;
import com.example.spring_ecommerce.services.dtos.like.response.ListLikesResponse;

import java.util.List;
import java.util.Optional;

public interface LikesService {
    List<ListLikesResponse> getAll();

    Optional<Likes> getByID(int id);

    void add(AddLikeRequest request);

    void update(UpdateLikeRequest request);

    void delete(int id);
}
