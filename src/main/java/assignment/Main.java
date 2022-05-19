package assignment;

import assignment.components.*;
import net.gameslabs.model.Assignment;

public class Main {

    public static void main(String[] args) {
        new Assignment(
            new MyXPBoosterComponent(),
            new MyInventoryComponent()
        ).run();
    }
}
