package view.factories;

import dtos.PromotionDTO;
import view.models.PromotionVM;

/**
 * Created by ljunior on 6/28/16.
 */
public interface IPromotionVMFactory {
    PromotionVM create(PromotionDTO promotionDTO);
}
