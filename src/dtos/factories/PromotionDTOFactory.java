package dtos.factories;

import dtos.PromotionDTO;
import infrastructure.Constants;

import java.sql.ResultSet;

/**
 * Created by ljunior on 6/28/16.
 */
public class PromotionDTOFactory implements IPromotionDTOFactory {
    private static PromotionDTOFactory instance;

    private PromotionDTOFactory() { }

    public static PromotionDTOFactory getInstance() {
        if (instance == null)
            instance = new PromotionDTOFactory();

        return instance;
    }

    @Override
    public PromotionDTO create(ResultSet rs) {
        try {
            int promotionId = rs.getInt(Constants.Promotions.PromotionId);
            String text = rs.getString(Constants.Promotions.Text);
            int numberOfPurchases = rs.getInt(Constants.Promotions.NumberOfPurchases);
            double percentage = rs.getDouble(Constants.Promotions.Percentage);

            return new PromotionDTO(promotionId, text, numberOfPurchases, percentage);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PromotionDTO create(String text, int numberOfPurchases, double percentage) {
        return new PromotionDTO(0, text, numberOfPurchases, percentage);
    }
}
