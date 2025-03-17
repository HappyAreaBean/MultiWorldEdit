package io.tofpu.multiworldedit;

import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.bukkit.BukkitPlayer;
import com.sk89q.worldedit.session.SessionManager;
import org.bukkit.entity.Player;

public final class LocalSessionWrapperV7 implements LocalSessionWrapper {
    private final LocalSession localSession;
    private final SessionManager sessionManager;
    private final BukkitPlayer bukkitPlayer;

    public LocalSessionWrapperV7(Player player) {
        sessionManager = WorldEdit.getInstance().getSessionManager();
        bukkitPlayer = BukkitAdapter.adapt(player);
        this.localSession = sessionManager.get(bukkitPlayer);
    }

    @Override
    public void close() {
        sessionManager.remove(bukkitPlayer);
    }

    @Override
    public LocalSession to() {
        return this.localSession;
    }
}
