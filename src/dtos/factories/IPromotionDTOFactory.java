package dtos.factories;

import dtos.PromotionDTO;

import java.sql.ResultSet;

public interface IPromotionDTOFactory {
    PromotionDTO create(ResultSet rs);
    PromotionDTO create(String text, int numberOfPurchases, double percentage);
}
