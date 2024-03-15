package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.core.types.CartProductNotFoundException;
import com.example.spring_ecommerce.entities.Cart;
import com.example.spring_ecommerce.entities.CartProducts;
import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.repositories.abstracts.CartProductRepository;
import com.example.spring_ecommerce.services.abstracts.CartProductsService;
import com.example.spring_ecommerce.services.dtos.cartProduct.request.AddCartProductRequest;
import com.example.spring_ecommerce.services.dtos.cartProduct.request.UpdateCartProductRequest;
import com.example.spring_ecommerce.services.dtos.cartProduct.response.ListCartProductsResponse;
import com.example.spring_ecommerce.services.mappers.CartProductsMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CartProcutsServiceImpl implements CartProductsService {

    private CartProductRepository cartProductRepository;
    @Override
    public List<ListCartProductsResponse> getAll() {
        List<CartProducts> cartProducts = cartProductRepository.findAll();

        List<ListCartProductsResponse> response = new ArrayList<>();

        for (CartProducts dto : cartProducts) {
            ListCartProductsResponse cartProductsResponseresponse = new ListCartProductsResponse(
                    dto.getProducts().getId(),
                    dto.getCarts().getId()
            );

            response.add(cartProductsResponseresponse);
        }

        return response;
    }

    @Override
    public Optional<CartProducts> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public void add(AddCartProductRequest request) {

        Cart cart = new Cart();
        cart.setId(request.getCarts());

        Product product = new Product();
        product.setId(request.getProducts());

        CartProducts cartProducts = new CartProducts();
        cartProducts.setCarts(cart);
        cartProducts.setProducts(product);


//        CartProducts cartProducts = CartProductsMapper.INSTANCE.cartPoroductsFromAddRequest(request);
        cartProductRepository.save(cartProducts);

    }

    @Override
    public void update(UpdateCartProductRequest request) {

        Optional<CartProducts> optionalCartProducts = cartProductRepository.findById(request.getId());


        Cart cart = new Cart();
        cart.setId(request.getCarts());

        Product product = new Product();
        product.setId(request.getProducts());

        if (optionalCartProducts.isPresent()){
            CartProducts cartProducts = optionalCartProducts.get();

            cartProducts.setProducts(product);

            cartProductRepository.save(cartProducts);
        }else {
            throw  new CartProductNotFoundException(" cart Product  not found with ID: " + request.getId());
        }

    }

    @Override
    public void delete(int id) {

    }
}
