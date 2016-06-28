package domain.services;

import domain.IPromotionService;
import dtos.PromotionDTO;
import dtos.factories.IPromotionDTOFactory;
import repository.IPromotionDao;

import java.util.List;

/**
 * Created by ljunior on 6/28/16.
 */
public class PromotionService implements IPromotionService {
    private static PromotionService instance;
    private IPromotionDao promotionDao;
    private IPromotionDTOFactory promotionDTOFactory;

    private PromotionService(IPromotionDao promotionDao, IPromotionDTOFactory promotionDTOFactory) {
        this.promotionDao = promotionDao;
        this.promotionDTOFactory = promotionDTOFactory;
    }

    public static PromotionService getInstance(IPromotionDao promotionDao, IPromotionDTOFactory promotionDTOFactory) {
        if (instance == null)
            instance = new PromotionService(promotionDao, promotionDTOFactory);

        return instance;
    }

    @Override
    public List<PromotionDTO> getPromotions() {
        return promotionDao.getAll();
    }

    @Override
    public PromotionDTO insert(String text, int numberOfPurchases, double percentage) {
        PromotionDTO promotionDTO = promotionDTOFactory.create(text, numberOfPurchases, percentage);

        return promotionDao.insert(promotionDTO);
    }
}
