package io.tofpu.multiworldedit;

import com.sk89q.worldedit.LocalSession;
import io.tofpu.multiworldedit.meta.OriginalClass;

import java.io.Closeable;

public interface LocalSessionWrapper extends OriginalClass<LocalSession>, Closeable {}
