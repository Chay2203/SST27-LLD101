package com.example.config;

import java.nio.file.Path;

/** Thin wrapper that now delegates to the Singleton instance. */
public class SettingsLoader {
    public AppSettings load(Path file) {
        AppSettings s = AppSettings.getInstance();
        s.loadFromFile(file);
        return s;
    }
}
