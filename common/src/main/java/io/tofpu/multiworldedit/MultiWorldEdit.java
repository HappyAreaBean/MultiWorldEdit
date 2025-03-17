package io.tofpu.multiworldedit;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.world.World;
import org.bukkit.entity.Player;

import java.io.File;

public interface MultiWorldEdit {
    ClipboardWrapper read(final File file);

    PasteBuilderWrapper create(final Clipboard clipboard, final EditSession session,
            final World world);
    EditSessionWrapper create(final World world, final int maxBlocks);
    LocalSessionWrapper create(Player player);
    VectorWrapper create(final double x, final double y, final double z);
    ClipboardWrapper create(final Clipboard clipboard);
    RegionWrapper create(final Region region);
}
