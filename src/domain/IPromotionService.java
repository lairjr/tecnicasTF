package domain;

import dtos.PromotionDTO;

import java.util.List;

/**
 * Created by ljunior on 6/28/16.
 */
public interface IPromotionService {
    List<PromotionDTO> getPromotions();
    PromotionDTO insert(String text, int numberOfPurchases, double percentage);
}
