package assignment.components;

import java.util.HashMap;
import java.util.Map;

import assignment.events.GiveItemEvent;
import assignment.events.MineOreEvent;
import assignment.model.Ore;
import net.gameslabs.api.Component;
import net.gameslabs.api.Player;
import net.gameslabs.model.Skill;
import net.gameslabs.events.GetPlayerLevel;
import net.gameslabs.events.GiveXpEvent;

public class MyMiningComponent extends Component {
    // I prefer to use a map instead of a switch statement
    public static Map<Ore, Integer> ORE_LEVEL_REQUIREMENTS = new HashMap<Ore, Integer>() {
        {
            put(Ore.COAL, 5);
            put(Ore.COPPER, 0);
            put(Ore.IRON, 10);
            put(Ore.GOLD, 15);
            put(Ore.REDSTONE, 15);
            put(Ore.DIAMOND, 20);
            put(Ore.EMERALD, 25);
            put(Ore.QUARTZ, 15);
        }
    };

    public static Map<Ore, Integer> ORE_XP_REWARD = new HashMap<Ore, Integer>() {
        {
            put(Ore.COAL, 10);
            put(Ore.COPPER, 5);
            put(Ore.IRON, 20);
            put(Ore.GOLD, 40);
            put(Ore.REDSTONE, 40);
            put(Ore.DIAMOND, 80);
            put(Ore.EMERALD, 160);
            put(Ore.QUARTZ,40);
        }
    };

    @Override
    public void onLoad() {
        registerEvent(MineOreEvent.class, this::onMineOre);
    }

    private void onMineOre(MineOreEvent event) {
        Ore ore = event.getOre();
        Player player = event.getPlayer();
        GetPlayerLevel playerLevel = new GetPlayerLevel(player, Skill.MINING);
        send(playerLevel);
        int level = playerLevel.getLevel();

        if (level >= ORE_LEVEL_REQUIREMENTS.get(ore)) {
            send(new GiveXpEvent(player, Skill.MINING, ORE_XP_REWARD.get(ore)));
            send(new GiveItemEvent(player, ore.toString()));
        } else {
            event.setCancelled(true);
            // notify user that he is not skilled enough to mine this ore
        }
    }

    @Override
    public void onUnload() {
        // Do nothing
    }
    
}
