package Controller;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import Controller.Interfaces.ICreateTowerSubject;
import Model.MainModel;
import Model.Enums.TowerType;
import View.ICreateTowerObserver;

/**
 * CreateWidgetController represents the controller responsible for managing the
 * shop interface
 * used for creating towers in the game. It extends AShopWidgetController and
 * implements the
 * ICreateTowerSubject interface to facilitate tower creation.
 * This controller initializes buttons for various tower types and handles
 * interactions related to
 * tower creation in the game. It also updates button opacity based on the
 * player's available money.
 */

public class CreateWidgetController extends AShopWidgetController implements ICreateTowerSubject {
    ICreateTowerObserver observer;

    /**
     * Constructor for the Shop Widget
     * 
     * @param observer The DrawPanel that is notified when the player wants to
     *                 create a tower
     * @Param model The main model containing the data and logic
     */
    public CreateWidgetController(ICreateTowerObserver observer, MainModel model) {
        super(model);

        this.observer = observer;
        this.model = model;
        buttonPanel.setLayout(new GridLayout(0, 6, 5, 10));

        initHeader("BUY TOWERS");
        initButtons();
        initPlaybutton();
    }

    /**
     * Initializes the buttons that the player click on when they want to create a
     * tower
     */
    private void initButtons() {
        buttons = List.of(
                new CreateButton(2, TowerType.knife, this),
                new CreateButton(3, TowerType.mallet, this),
                new CreateButton(10, TowerType.blowtorch, this),
                new CreateButton(2, TowerType.slicer, this),
                new CreateButton(6, TowerType.freezer, this));
        for (AWidgetButton button : buttons) {
            buttonPanel.add(button);
        }
        add(buttonPanel, BorderLayout.CENTER);
    }

    /**
     * Notifies the observer (DrawPanel) that the player wants to create a tower of
     * 
     * @param towerType The tower the player wants to buy
     * @throws Exception if the player doesn't have enough money to buy the tower
     */
    @Override
    public void notifyObservers(TowerType towerType) {
        try {
            observer.selectTowerToCreate(towerType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Called whenever the players bank changes
     * Calls setOpacity(), turns buttons grey if the player cant afford the tower
     * 
     * @param curMoney The current amount of Money the Player has.
     */
    @Override
    public void updateMoney(int curMoney) {
        for (AWidgetButton button : buttons) {
            button.setOpacity(button.getCost() > curMoney);
        }
    }
}