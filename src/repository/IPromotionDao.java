package repository;

import dtos.PromotionDTO;

/**
 * Created by ljunior on 6/27/16.
 */
public interface IPromotionDao {
    PromotionDTO getByPromotionId(int promotionId);
    PromotionDTO insert(PromotionDTO promotionDTO);
}
