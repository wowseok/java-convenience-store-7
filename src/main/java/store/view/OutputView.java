package store.view;

public class OutputView {

    public static final String ERROR_FORM = "[ERROR] %s%n";

    public void printErrorMessage(Throwable throwable) {
        System.out.printf(ERROR_FORM, throwable.getMessage());
        System.out.println();
    }

    public void printIntroMessage() {
        System.out.printf("안녕하세요. W편의점입니다.%n");
        System.out.printf("현재 보유하고 있는 상품입니다.%n%n");
    }

}
