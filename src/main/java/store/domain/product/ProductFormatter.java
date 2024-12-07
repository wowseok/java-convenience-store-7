package store.domain.product;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductFormatter {
    public static List<String> formatProducts(List<Product> products) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        List<String> formattedProducts = new ArrayList<>();
        for (Product product : products) {
            specifyFormat(product, numberFormat, formattedProducts);
        }

        return formattedProducts;
    }

    private static void specifyFormat(Product product, NumberFormat numberFormat, List<String> formattedProducts) {
        String promotion = formatPromotion(product.getPromotion());
        String quantity = formatQuantity(product.getQuantity());

        String formattedProduct = String.format("- %s %s원 %s %s",
                product.getName(), numberFormat.format(product.getPrice()), // 쉼표 추가된 가격
                quantity, promotion);
        formattedProducts.add(formattedProduct);
    }

    // 프로모션 포맷 처리
    private static String formatPromotion(String promotion) {
        if ("null".equals(promotion)) {
            return ""; // "null"이면 빈 문자열 반환
        }
        return promotion;
    }

    // 재고 포맷 처리
    private static String formatQuantity(int quantity) {
        if (quantity == 0) {
            return "재고 없음"; // 재고가 0이면 "재고 없음" 반환
        }
        return quantity + "개"; // 그 외에는 "X개" 형식 반환
    }


}
