package view.factories;

import dtos.PromotionDTO;
import view.models.PromotionVM;

public interface IPromotionVMFactory {
    PromotionVM create(PromotionDTO promotionDTO);
}
