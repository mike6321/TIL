package net.fashiongo.api.common.model.command;

import lombok.Getter;

@Getter
public class FileUploadResponse {

    private String location;

    private String originalFileName;

    private String error;

    private String uploadedFileName;

    public FileUploadResponse() {
    }

    @Override
    public String toString() {
        return "FileUploadResponse{" +
                "location='" + location + '\'' +
                ", originalFileName='" + originalFileName + '\'' +
                ", error='" + error + '\'' +
                ", uploadedFileName='" + uploadedFileName + '\'' +
                '}';
    }
}
