package store.domain.promotion;

import java.util.ArrayList;
import java.util.List;

public class PromotionRepository {
    private static final PromotionRepository INSTANCE = new PromotionRepository();
    private final List<Promotion> promotions = new ArrayList<>();

    private PromotionRepository() {
    }

    public static PromotionRepository getInstance() {
        return INSTANCE;
    }

    public void addPromotion(Promotion promotion) {
        promotions.add(promotion);

    }
}
