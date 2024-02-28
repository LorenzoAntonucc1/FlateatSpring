package controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import converter.RestaurantConverter;
import dto.restaurant.RestaurantDtoWsec;
import entities.Restaurant;
import repository.RestaurantRepository;

@RestController
public class RestaurantController 
{

    @Autowired
    RestaurantRepository repo;

    @Autowired
    RestaurantConverter conv;
    
    @GetMapping("/restaurants")
    public List<RestaurantDtoWsec> getAllRestaurant() 
    {
        return repo.findAll()
               .stream()
               .map(e -> conv.restaurantToDto(e))
               .toList();
    }

    // @GetMapping("/restaurant/search")
    // public List<RestaurantDtoWsec> searchRestaurantByNameAndFoodType(@RequestParam String partialName,@RequestParam String foodType) 
    // {
    //     List<Restaurant> restaurantsByName = repo.findByNameContaining(partialName);
    //     List<Restaurant> restaurantsByFoodType = repo.findByFoodTypesContaining(foodType);

        
    //     List<Restaurant> intersection = restaurantsByName.stream()
    //             .filter(restaurantsByFoodType::contains)
    //             .collect(Collectors.toList());

    //     return intersection.stream()
    //             .map(conv::restaurantToDto)
    //             .collect(Collectors.toList());
    // }

    @GetMapping("/restaurants/{id}")
    public RestaurantDtoWsec getRestaurantById(@PathVariable Integer id) 
    {
        return conv.restaurantToDto(repo.findById(id).orElse(null));
    }

    @PostMapping("/restaurants/add")
    public RestaurantDtoWsec addRestaurant(@RequestBody RestaurantDtoWsec restaurantDto) 
    {
        Restaurant restaurant = conv.dtoToRestaurant(restaurantDto);
        return conv.restaurantToDto(repo.save(restaurant));
    }

    @PutMapping("/restaurants/{id}")
    public RestaurantDtoWsec updateRestaurant(@PathVariable Integer id, @RequestBody RestaurantDtoWsec restaurantDto) 
    {
        Restaurant existingRestaurant = repo.findById(id).orElse(null);
        if (existingRestaurant != null) {
            Restaurant updatedRestaurant = conv.dtoToRestaurant(restaurantDto);
            updatedRestaurant.setId(id); 
            return conv.restaurantToDto(repo.save(updatedRestaurant));
        }
        return null; 
    }
}
