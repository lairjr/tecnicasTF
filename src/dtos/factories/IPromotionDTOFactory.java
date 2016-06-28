package dtos.factories;

import dtos.PromotionDTO;

import java.sql.ResultSet;

/**
 * Created by ljunior on 6/27/16.
 */
public interface IPromotionDTOFactory {
    PromotionDTO create(ResultSet rs);
    PromotionDTO create(String text, int numberOfPurchases, double percentage);
}
