package infrastructure.mocks;

import dtos.factories.IPromotionDTOFactory;
import repository.IPromotionDao;

/**
 * Created by ljunior on 6/28/16.
 */
public class PromotionGenerator {
    private IPromotionDao promotionDao;
    private IPromotionDTOFactory promotionDTOFactory;
    private static PromotionGenerator instance;

    private PromotionGenerator(IPromotionDao promotionDao, IPromotionDTOFactory promotionDTOFactory) {
        this.promotionDao = promotionDao;
        this.promotionDTOFactory = promotionDTOFactory;
    }

    public static PromotionGenerator getInstance(IPromotionDao promotionDao, IPromotionDTOFactory promotionDTOFactory) {
        if (instance == null)
            instance = new PromotionGenerator(promotionDao, promotionDTOFactory);

        return instance;
    }

    public void generatePromotionMocks() {
        promotionDao.insert(promotionDTOFactory.create("Mais que 10", 10, 15.0));
    }
}
