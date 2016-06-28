package domain;

import dtos.PromotionDTO;
import infrastructure.exceptions.RecordNotFoundException;

import java.util.List;

public interface IPromotionService {
    List<PromotionDTO> getPromotions();
    PromotionDTO insert(String text, int numberOfPurchases, double percentage);
    PromotionDTO getPromotionByPassenger(String document) throws RecordNotFoundException;
}
