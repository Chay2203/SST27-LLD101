package com.example.video;

import java.util.Objects;
public class SharpenAdapter {
    private final LegacySharpen legacySharpen;
    public SharpenAdapter(LegacySharpen legacySharpen) {
        this.legacySharpen = Objects.requireNonNull(legacySharpen, "legacySharpen");
    }
    public Frame[] sharpen(Frame[] frames, int strength) {
        Objects.requireNonNull(frames, "frames");
        String framesHandle = "FRAMES:" + frames.length + ":" + 
                             (frames.length > 0 ? frames[0].w + "x" + frames[0].h : "0x0");
        String resultHandle = legacySharpen.applySharpen(framesHandle, strength);
        return frames;
    }
}
