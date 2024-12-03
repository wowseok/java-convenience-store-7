package store;

import store.controller.MainController;
import store.service.Service;
import store.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(new Service(), new OutputView());
        mainController.run();
    }
}
