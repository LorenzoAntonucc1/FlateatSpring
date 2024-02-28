package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import converter.RestaurantConverter;
import dto.restaurant.RestaurantDtoWAlone;
import dto.restaurant.RestaurantDtoWFull;
import repository.RestaurantRepository;
import repository.UserRepository;

@RestController
public class RestaurantController 
{

    @Autowired
    RestaurantRepository repo;
    
    @Autowired
    UserRepository uRepo;

    @Autowired
    RestaurantConverter conv;
    
    @GetMapping("/restaurants/{id}")
    public List<RestaurantDtoWAlone> getAllRestaurant(@PathVariable Integer id) 
    {
        return  repo.findAll()
               .stream()
               .map(e -> conv.restaurantToDtoWAlone(e,uRepo.findById(id).get()))
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

    @GetMapping("/restaurant/{id}/{id}")
    public RestaurantDtoWFull getRestaurantByUserId(@PathVariable Integer idr, @PathVariable Integer idu) 
    {
        return conv.restaurantToDtoWFull(repo.findById(idr).get(), uRepo.findById(idu).get());
    }
}
