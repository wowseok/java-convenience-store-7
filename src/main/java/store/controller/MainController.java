package store.controller;

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
