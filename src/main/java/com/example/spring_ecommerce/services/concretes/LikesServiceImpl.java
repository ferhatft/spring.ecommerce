package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Likes;
import com.example.spring_ecommerce.repositories.abstracts.LikesRepository;
import com.example.spring_ecommerce.services.abstracts.LikesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class LikesServiceImpl implements LikesService {
    private LikesRepository likesRepository;

    @Override
    public List<Likes> getAll() {
        return likesRepository.findAll();
    }

    @Override
    public Optional<Likes> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public void add(Likes likes) {

    }

    @Override
    public void update(Likes likes) {

    }

    @Override
    public void delete(int id) {

    }
}
