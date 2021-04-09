package ru.mirea.dockercomposeapp.services;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.mirea.dockercomposeapp.models.Photo;
import ru.mirea.dockercomposeapp.repositories.PhotoRepository;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PhotoService {
    private final PhotoRepository photoRepository;

    @Transactional
    public String save(MultipartFile file) throws IOException {
        Photo photo = new Photo();
        photo.setData(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        photoRepository.save(photo);
        return photo.getId();

    }

    @Transactional
    public byte[] fetchPhotoById(String id) throws NotFoundException {
        return photoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Photo with id " + id + " was not found")).getData().getData();
    }
}
