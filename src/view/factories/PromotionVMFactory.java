package view.factories;

import dtos.PromotionDTO;
import view.models.PromotionVM;

/**
 * Created by ljunior on 6/28/16.
 */
public class PromotionVMFactory implements IPromotionVMFactory {
    private static PromotionVMFactory instance;

    private PromotionVMFactory() { }

    public static PromotionVMFactory getInstance() {
        if (instance == null)
            instance = new PromotionVMFactory();

        return instance;
    }

    @Override
    public PromotionVM create(PromotionDTO promotionDTO) {
        return new PromotionVM(promotionDTO);
    }

}
