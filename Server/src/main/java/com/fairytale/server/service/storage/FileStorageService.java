package com.fairytale.server.service.storage;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileStorageService {

    private final Storage storage; // Storage 객체 주입

    @Autowired
    public FileStorageService(Storage storage) { // 생성자에서 Storage 객체 주입
        this.storage = storage;
    }

    public String uploadFile(MultipartFile file, String filePath) throws IOException {
        // 파일을 Byte 배열로 변환
        byte[] bytes = file.getBytes();

        // Storage에 업로드할 파일의 경로 설정
        BlobId blobId = BlobId.of(storage.getOptions().getProjectId(), filePath);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/jpeg").build(); // 파일 타입 설정

        // Storage에 업로드
        Blob blob = storage.create(blobInfo, bytes);

        // 업로드된 파일의 URL 반환
        return blob.getMediaLink();
    }

    public String profileFile(MultipartFile file, String filePath) throws IOException {
        // 파일을 Byte 배열로 변환
        byte[] bytes = file.getBytes();

        // Storage에 업로드할 파일의 경로 설정
        BlobId blobId = BlobId.of(storage.getOptions().getProjectId(), filePath);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/png").build(); // 파일 타입 설정

        // Storage에 업로드
        Blob blob = storage.create(blobInfo, bytes);

        // 업로드된 파일의 URL 반환
        return blob.getMediaLink();
    }
}
