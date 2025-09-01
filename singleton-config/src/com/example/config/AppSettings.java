package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * Thread-safe, lazily initialized Singleton for application settings.
 */
public final class AppSettings implements Serializable {
    private static final long serialVersionUID = 1L;

    private static volatile AppSettings INSTANCE;
    private static boolean instanceCreated = false;

    private final Properties props = new Properties();

    private AppSettings() {
        if (instanceCreated) {
            throw new IllegalStateException("AppSettings instance already created");
        }
        instanceCreated = true;
    }

    public static AppSettings getInstance() {
        AppSettings localRef = INSTANCE;
        if (localRef == null) {
            synchronized (AppSettings.class) {
                localRef = INSTANCE;
                if (localRef == null) {
                    localRef = new AppSettings();
                    INSTANCE = localRef;
                }
            }
        }
        return localRef;
    }

    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }

    public void loadFromFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            props.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }
}
