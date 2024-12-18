package store.controller;

import store.domain.inventory.InventoryFactory;
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
        service.setUpProductFile(StringParser.parseFileContent(readFile("src/main/resources/products.md")));
        service.setUpPromotionFile(StringParser.parseFileContent(readFile("src/main/resources/promotions.md")));
        InventoryFactory.createInventory();
        outputView.printInventory(service.getFormattedProducts());
        outputView.printPurchaseMessage();
        service.setUpPurchaseProducts(InputView.readLine());
        outputView.printInventory(service.getFormattedProducts());
    }

    private String readFile(String file) {
        return FileReader.readFileToString(file);
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
