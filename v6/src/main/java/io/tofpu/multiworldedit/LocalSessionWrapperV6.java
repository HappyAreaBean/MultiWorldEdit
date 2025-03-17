package io.tofpu.multiworldedit;

import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitPlayer;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.session.SessionManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.IOException;

public final class LocalSessionWrapperV6 implements LocalSessionWrapper {
    private final LocalSession localSession;
    private final SessionManager sessionManager;
    private final BukkitPlayer bukkitPlayer;

    public LocalSessionWrapperV6(Player player) {
        WorldEditPlugin worldEditPlugin = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
        sessionManager = WorldEdit.getInstance().getSessionManager();

        bukkitPlayer = worldEditPlugin.wrapPlayer(player);
        this.localSession = sessionManager.get(bukkitPlayer);
    }

    @Override
    public void close() throws IOException {
        sessionManager.remove(bukkitPlayer);
    }

    @Override
    public LocalSession to() {
        return this.localSession;
    }
}
