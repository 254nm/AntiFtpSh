package org.l2x9.antiftpsh;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;
import org.l2x9.antiftpsh.listeners.PlayerJoin;
import org.l2x9.antiftpsh.listeners.ProxyPing;

public final class AntiFtpSh extends Plugin {
    public static final String BAD_HOST = "l2x9.ftp.sh";
    PluginManager pluginManager = getProxy().getPluginManager();

    @Override
    public void onEnable() {
        pluginManager.registerListener(this, new PlayerJoin());
        pluginManager.registerListener(this, new ProxyPing());
    }
}
