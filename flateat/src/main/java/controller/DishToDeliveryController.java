package controller;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import converter.DishToDeliveryConverter;
import dto.dishtodelivery.DishToDeliveryDtoFull;
import entities.DishToDelivery;
import repository.DishToDeliveryRepository;

@RestController
@RequestMapping("/dishToDelivery")
public class DishToDeliveryController {

    @Autowired
    DishToDeliveryRepository repo;

    @Autowired
    DishToDeliveryConverter conv;

    @GetMapping("/all")
    public List<DishToDeliveryDtoFull> getAllDishToDelivery() {
        return repo.findAll()
                .stream()
                .map(e -> conv.dishToDeliveryToDtoFull(e))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DishToDeliveryDtoFull getDishToDeliveryById(@PathVariable Integer id) {
        return conv.dishToDeliveryToDtoFull(repo.findById(id).orElse(null));
    }

    @PostMapping("/add")
    public DishToDeliveryDtoFull addDishToDelivery(@RequestBody DishToDeliveryDtoFull dishToDeliveryDto) {
        DishToDelivery dishToDelivery = conv.dtoFullToDishToDelivery(dishToDeliveryDto);
        return conv.dishToDeliveryToDtoFull(repo.save(dishToDelivery));
    }

    @PutMapping("/{id}")
    public DishToDeliveryDtoFull updateDishToDelivery(@PathVariable Integer id, @RequestBody DishToDeliveryDtoFull dishToDeliveryDto) {
        DishToDelivery existingDishToDelivery = repo.findById(id).orElse(null);
        if (existingDishToDelivery != null) {
            DishToDelivery updatedDishToDelivery = conv.dtoFullToDishToDelivery(dishToDeliveryDto);
            updatedDishToDelivery.setId(id);
            return conv.dishToDeliveryToDtoFull(repo.save(updatedDishToDelivery));
        }
        return null;
    }
}
