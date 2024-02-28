package converter;

import dto.dishtodelivery.DishToDeliveryDtoBase;
import dto.dishtodelivery.DishToDeliveryDtoFull;
import dto.dishtodelivery.DishToDeliveryDtoR;
import entities.DishToDelivery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;


@Service
public class DishToDeliveryConverter {

    public DishToDeliveryDtoBase dishToDeliveryToDtoBase(DishToDelivery dishToDelivery) {
        return DishToDeliveryDtoBase.builder()
                .quantity(dishToDelivery.getQuantity())
                .dish(dishToDelivery.getDish())
                .delivery(dishToDelivery.getDelivery())
                .build();
    }

    public DishToDeliveryDtoR dishToDeliveryToDtoR(DishToDelivery dishToDelivery) {
        DishToDeliveryDtoR dtoR = new DishToDeliveryDtoR();
        dtoR.setId(dishToDelivery.getId());
        dtoR.setQuantity(dishToDelivery.getQuantity());
        dtoR.setDish(dishToDelivery.getDish());
        dtoR.setDelivery(dishToDelivery.getDelivery());
        return dtoR;
    }

    public DishToDeliveryDtoFull dishToDeliveryToDtoFull(DishToDelivery dishToDelivery) {
        DishToDeliveryDtoFull dtoFull = new DishToDeliveryDtoFull();
        dtoFull.setId(dishToDelivery.getId());
        dtoFull.setQuantity(dishToDelivery.getQuantity());
        dtoFull.setDish(dishToDelivery.getDish());
        dtoFull.setDelivery(dishToDelivery.getDelivery());
        return dtoFull;
    }

    public DishToDelivery dtoBaseToDishToDelivery(DishToDeliveryDtoBase dtoBase) {
        return DishToDelivery.builder()
                .quantity(dtoBase.getQuantity())
                .dish(dtoBase.getDish())
                .delivery(dtoBase.getDelivery())
                .build();
    }

    public DishToDelivery dtoRToDishToDelivery(DishToDeliveryDtoR dtoR) {
        DishToDelivery dishToDelivery = dtoBaseToDishToDelivery(dtoR);
        dishToDelivery.setId(dtoR.getId());
        return dishToDelivery;
    }

    public DishToDelivery dtoFullToDishToDelivery(DishToDeliveryDtoFull dtoFull) {
        DishToDelivery dishToDelivery = dtoBaseToDishToDelivery(dtoFull);
        dishToDelivery.setId(dtoFull.getId());
        return dishToDelivery;
    }
}
