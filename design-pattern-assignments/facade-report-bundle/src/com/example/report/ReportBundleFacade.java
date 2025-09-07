package com.example.report;

import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
public class ReportBundleFacade {
    private final JsonWriter jsonWriter;
    private final Zipper zipper;
    private final AuditLog auditLog;
    public ReportBundleFacade() {
        this.jsonWriter = new JsonWriter();
        this.zipper = new Zipper();
        this.auditLog = new AuditLog();
    }
    public Path export(Map<String, Object> data, Path outDir, String baseName) {
        Objects.requireNonNull(data, "data");
        Objects.requireNonNull(outDir, "outDir");
        Objects.requireNonNull(baseName, "baseName");
        Path jsonFile = jsonWriter.write(data, outDir, baseName);
        Path zipFile = zipper.zip(jsonFile, outDir.resolve(baseName + ".zip"));
        auditLog.log("exported " + zipFile);
        return zipFile;
    }
}
