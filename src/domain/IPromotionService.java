package domain;

import dtos.PromotionDTO;
import infrastructure.exceptions.RecordNotFoundException;

import java.util.List;

/**
 * Created by ljunior on 6/28/16.
 */
public interface IPromotionService {
    List<PromotionDTO> getPromotions();
    PromotionDTO insert(String text, int numberOfPurchases, double percentage);
    PromotionDTO getPromotionByPassenger(String document) throws RecordNotFoundException;
}
