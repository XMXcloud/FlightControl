/*
 * This file is part of FlightControl, which is licensed under the MIT License.
 * Copyright (c) 2024 George Fang
 */

package org.spazzinq.flightcontrol.util;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public final class ActionbarUtil {

    /**
     * Sends an actionbar message to a player.
     * Uses the modern Spigot API which is compatible with all Minecraft versions
     * 1.9+.
     * 
     * @param p   the player to send the actionbar to
     * @param msg the message to display
     */
    public static void sendActionbar(Player p, String msg) {
        if (p == null || msg == null || msg.isEmpty()) {
            return;
        }
        try {
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(msg));
        } catch (Exception e) {
            // Fallback silently if actionbar fails - don't spam console
        }
    }
}
