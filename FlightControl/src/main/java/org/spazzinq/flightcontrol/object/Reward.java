/*
 * This file is part of FlightControl, which is licensed under the MIT License.
 * Copyright (c) 2024 George Fang
 */

package org.spazzinq.flightcontrol.object;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.spazzinq.flightcontrol.FlightControl;

import java.util.List;

public class Reward extends BukkitRunnable {
    @Getter
    private final Category category;
    @Getter
    private final List<String> commands;

    @Override
    public void run() {
        // FlightControl.getInstance().getLogger().info("Running reward");
        for (Player p : Bukkit.getOnlinePlayers()) {
            // FlightControl.getInstance().getLogger().info("Found " + p.getName());
            if (category == FlightControl.getInstance().getCategoryManager().getCategory(p)) {
                for (String command : commands) {
                    if (command == null || command.trim().isEmpty()) {
                        continue;
                    }
                    String parsedCommand = command.replaceAll("%player%", p.getName()).trim();
                    if (!parsedCommand.isEmpty()) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), parsedCommand);
                    }
                }
            }
        }
    }

    public Reward(Category category, List<String> commands) {
        this.category = category;
        this.commands = commands;
    }
}
