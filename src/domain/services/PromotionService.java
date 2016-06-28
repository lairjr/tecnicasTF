package domain.services;

import domain.IPromotionService;
import dtos.PromotionDTO;
import dtos.factories.IPromotionDTOFactory;
import infrastructure.exceptions.RecordNotFoundException;
import repository.IPromotionDao;
import repository.ITicketDao;

import java.util.List;

public class PromotionService implements IPromotionService {
    private static PromotionService instance;
    private IPromotionDao promotionDao;
    private ITicketDao ticketDao;
    private IPromotionDTOFactory promotionDTOFactory;

    private PromotionService(IPromotionDao promotionDao, IPromotionDTOFactory promotionDTOFactory, ITicketDao ticketDao) {
        this.promotionDao = promotionDao;
        this.promotionDTOFactory = promotionDTOFactory;
        this.ticketDao = ticketDao;
    }

    public static PromotionService getInstance(IPromotionDao promotionDao, IPromotionDTOFactory promotionDTOFactory, ITicketDao ticketDao) {
        if (instance == null)
            instance = new PromotionService(promotionDao, promotionDTOFactory, ticketDao);

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

    @Override
    public PromotionDTO getPromotionByPassenger(String document) throws RecordNotFoundException {
        int numberOfPurchases = ticketDao.getNumberOfTicketsByPassenger(document);

        List<PromotionDTO> promotionDTOs = promotionDao.getAll();

        for (PromotionDTO promotion : promotionDTOs) {
            if (numberOfPurchases >= promotion.getNumberOfPurchases())
                return promotion;
        }

        throw new RecordNotFoundException();
    }
}
