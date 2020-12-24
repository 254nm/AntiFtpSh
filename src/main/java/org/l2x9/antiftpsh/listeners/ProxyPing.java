package org.l2x9.antiftpsh.listeners;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.Favicon;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;
import org.l2x9.antiftpsh.AntiFtpSh;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class ProxyPing implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPing(ProxyPingEvent event) {
        String hostname = event.getConnection().getVirtualHost().getHostName();
        if (hostname.equalsIgnoreCase(AntiFtpSh.BAD_HOST)) {
            try {
                InputStream stream = getClass().getClassLoader().getResourceAsStream("icon.png");
                if (stream != null) {
                    ServerPing newResponse = new ServerPing();
                    BufferedImage image = ImageIO.read(stream);
                    Favicon favicon = Favicon.create(image);
                    TextComponent description = new TextComponent(ChatColor.translateAlternateColorCodes(
                            '&',
                            "&6Please connect using&r&3 l2x9.org&r&6 instead of&r&3 l2x9.ftp.sh\n" +
                                    "&6Conéctese usando&r&3 l2x9.org&r&6 en lugar de &r &3 l2x9.ftp.sh"
                    ));
                    ServerPing.Protocol protocol = new ServerPing.Protocol("L2X9 1.8 ~ 1.16", 340);
                    newResponse.setFavicon(favicon);
                    newResponse.setVersion(protocol);
                    newResponse.setDescriptionComponent(description);
                    newResponse.setPlayers(event.getResponse().getPlayers());
                    event.setResponse(newResponse);
                    stream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
