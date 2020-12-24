package org.l2x9.antiftpsh.listeners;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;
import org.l2x9.antiftpsh.AntiFtpSh;

public class PlayerJoin implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PreLoginEvent event) {
        String hostname = event.getConnection().getVirtualHost().getHostName();
        if (hostname.equalsIgnoreCase(AntiFtpSh.BAD_HOST)) {
            String reason = ChatColor.translateAlternateColorCodes(
                    '&',
                    "&3&lL2&r&b&lX9&r" +
                            "\n" +
                            "&7&m-------------------------------------------------------" +
                            "\n\n" +
                            "&6Please connect using&r&3 l2x9.org&r&6 instead of&r&3 l2x9.ftp.sh" +
                            "\n" +
                            "&6Conéctese usando&r&3 l2x9.org&r&6 en lugar de &r &3 l2x9.ftp.sh" +
                            "\n\n" +
                            "&7&m-------------------------------------------------------"
            );
            System.out.println(ChatColor.translateAlternateColorCodes(
                    '&',
                    "[&3&lAnti&r&b&lFtpSh&r] &6Prevented&r&3 " + event.getConnection().getName() + "&r&6 from using l2x9.ftp.sh")
            );
            TextComponent component = new TextComponent(reason);
            event.getConnection().disconnect(component);
        }
    }
}
