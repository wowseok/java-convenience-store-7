package store.domain.promotion;

public class PromotionFactory {

    public static void createPromotion(String name, int buy, int get, String start_date, String end_date) {
        PromotionRepository repository = PromotionRepository.getInstance();
        repository.addPromotion(new Promotion(name, buy, get, start_date, end_date));
    }
}
