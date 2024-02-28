package converter;

import org.springframework.stereotype.Service;
import dto.menu.MenuDtoW;
import entities.Menu;

@Service
public class MenuConverter {
    
    public Menu dtoToMenu(MenuDtoW dto) {
        return Menu
                .builder()
                .dishes(dto.getDishes())
                .restaurant(dto.getRestaurant())
                .build();
    }

    public MenuDtoW menuToDto(Menu menu) {
        return MenuDtoW.builder()
                .dishes(menu.getDishes())
                .restaurant(menu.getRestaurant())
                .build();
    }
}
