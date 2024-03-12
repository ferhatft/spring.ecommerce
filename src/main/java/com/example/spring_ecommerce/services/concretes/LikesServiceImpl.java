package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Likes;
import com.example.spring_ecommerce.repositories.abstracts.LikesRepository;
import com.example.spring_ecommerce.services.abstracts.LikesService;
import com.example.spring_ecommerce.services.dtos.like.request.AddLikeRequest;
import com.example.spring_ecommerce.services.dtos.like.request.UpdateLikeRequest;
import com.example.spring_ecommerce.services.dtos.like.response.ListLikesResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class LikesServiceImpl implements LikesService {
    private LikesRepository likesRepository;

    @Override
    public List<ListLikesResponse> getAll() {
        return null;
    }

    @Override
    public Optional<Likes> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public void add(AddLikeRequest request) {

    }

    @Override
    public void update(UpdateLikeRequest request) {

    }

    @Override
    public void delete(int id) {

    }
}
