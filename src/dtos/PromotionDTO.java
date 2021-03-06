package dtos;

public class PromotionDTO {
    private int promotionId;
    private String text;
    private int numberOfPurchases;
    private double percentage;

    public PromotionDTO(int promotionId, String text, int numberOfPurchases, double percentage) {
        this.promotionId = promotionId;
        this.text = text;
        this.numberOfPurchases = numberOfPurchases;
        this.percentage = percentage;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public String getText() {
        return text;
    }

    public int getNumberOfPurchases() {
        return numberOfPurchases;
    }

    public double getPercentage() {
        return percentage;
    }
}
