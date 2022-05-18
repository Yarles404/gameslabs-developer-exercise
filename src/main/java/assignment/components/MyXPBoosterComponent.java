package assignment.components;

import net.gameslabs.api.Component;
import net.gameslabs.events.GiveXpEvent;
import net.gameslabs.model.Skill;

public class MyXPBoosterComponent extends Component {

    @Override
    public void onLoad() {
        registerEvent(GiveXpEvent.class, this::onGiveXP);
    }

    private void onGiveXP(GiveXpEvent event) {
        // Double xp amounts for CONSTRUCTION SKILL
        if (event.getSkill() == Skill.CONSTRUCTION) {
            event.setXp(event.getXp() * 2);
        }
        // event.setXp(event.getXp() * (event.getSkill() == Skill.CONSTRUCTION ? 2 : 1));
    }

    @Override
    public void onUnload() {
        // Do nothing
    }
}
