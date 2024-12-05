package store.controller;

import java.util.List;
import store.service.Service;
import store.util.FileReader;
import store.util.StringParser;
import store.view.InputView;
import store.view.OutputView;

public class MainController {
    private final OutputView outputView;
    private final Service service;

    public MainController(Service service, OutputView outputView) {
        this.service = service;
        this.outputView = outputView;
    }

    public void run() {
        process(this::inputBuyItem);
    }

    private void inputBuyItem() {
        outputView.printIntroMessage();
        service.setUpFile(StringParser.parseFileContent(readFile()));
        // Service에서 포맷된 데이터를 가져와 View에 전달
        List<String> formattedProducts = service.getFormattedProducts();
        outputView.printInventory(formattedProducts);
        outputView.printPurchaseMessage();
        service.setUp(InputView.readLine());
    }

    private String readFile() {
        return FileReader.readFileToString("src/main/resources/products.md");
    }


    private void process(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            process(action);
        }
    }
}
