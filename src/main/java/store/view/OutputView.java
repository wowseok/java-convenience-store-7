package store.view;

import java.util.List;
import store.domain.product.dto.ProductDTORepository;

public class OutputView {
    private final ProductDTORepository dtoRepository;

    public static final String ERROR_FORM = "[ERROR] %s%n";

    public OutputView() {
        this.dtoRepository = ProductDTORepository.getInstance();
    }

    public void printErrorMessage(Throwable throwable) {
        System.out.printf(ERROR_FORM, throwable.getMessage());
        System.out.println();
    }

    public void printIntroMessage() {
        System.out.printf("안녕하세요. W편의점입니다.%n");
        System.out.printf("현재 보유하고 있는 상품입니다.%n%n");
    }

    public void printInventory(List<String> formattedProducts) {
        for (String product : formattedProducts) {
            System.out.println(product);
        }
        System.out.println();
    }

    public void printPurchaseMessage() {
        System.out.println("구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2], [감자칩-1])");
    }

}
