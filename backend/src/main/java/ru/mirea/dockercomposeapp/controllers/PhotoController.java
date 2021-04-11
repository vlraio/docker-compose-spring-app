package ru.mirea.dockercomposeapp.controllers;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mirea.dockercomposeapp.services.PhotoService;

@RestController
@RequestMapping("/server-manager/api/img/usr")
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoService photoService;

    @GetMapping("/{photoId}")
    public byte[] getPhoto(@PathVariable String photoId) throws NotFoundException {
        return photoService.fetchPhotoById(photoId);
    }
}
