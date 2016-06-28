package repository;

import dtos.PromotionDTO;

import java.util.List;

/**
 * Created by ljunior on 6/27/16.
 */
public interface IPromotionDao {
    List<PromotionDTO> getAll();
    PromotionDTO getByPromotionId(int promotionId);
    PromotionDTO insert(PromotionDTO promotionDTO);
}
