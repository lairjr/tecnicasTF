package repository;

import dtos.PromotionDTO;

import java.util.List;

public interface IPromotionDao {
    List<PromotionDTO> getAll();
    PromotionDTO insert(PromotionDTO promotionDTO);
}
