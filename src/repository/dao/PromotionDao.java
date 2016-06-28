package repository.dao;

import dtos.PromotionDTO;
import dtos.factories.IPromotionDTOFactory;
import infrastructure.Constants;
import infrastructure.IDatabase;
import repository.IPromotionDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PromotionDao implements IPromotionDao {
    private static PromotionDao instance;
    private IDatabase db;
    private IPromotionDTOFactory promotionDTOFactory;

    public PromotionDao(IDatabase database, IPromotionDTOFactory promotionDTOFactory) {
        this.db = database;
        this.promotionDTOFactory = promotionDTOFactory;
    }

    public static PromotionDao getInstance(IDatabase database, IPromotionDTOFactory promotionDTOFactory) {
        if (instance == null)
            instance = new PromotionDao(database, promotionDTOFactory);

        return instance;
    }

    @Override
    public List<PromotionDTO> getAll() {
        StringBuilder sql = new StringBuilder();
        List<PromotionDTO> promotionDTOs = new ArrayList<>();

        sql.append(" SELECT * FROM " + Constants.Promotions.TABLE_NAME);
        sql.append(" ORDER BY " + Constants.Promotions.NumberOfPurchases + " DESC ");

        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql.toString());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                promotionDTOs.add(promotionDTOFactory.create(rs));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return promotionDTOs;
    }

    @Override
    public PromotionDTO insert(PromotionDTO promotionDTO) {
        StringBuilder sql = new StringBuilder();

        sql.append(" INSERT INTO " + Constants.Promotions.TABLE_NAME);
        sql.append(" ( ");

        sql.append(Constants.Promotions.Text + ", ");
        sql.append(Constants.Promotions.NumberOfPurchases + ", ");
        sql.append(Constants.Promotions.Percentage);

        sql.append(" ) VALUES (? ,?, ?) ");

        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, promotionDTO.getText());
            ps.setInt(2, promotionDTO.getNumberOfPurchases());
            ps.setDouble(3, promotionDTO.getPercentage());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            rs.next();

            promotionDTO.setPromotionId(rs.getInt(1));

            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return promotionDTO;
    }
}
