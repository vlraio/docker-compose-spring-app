package ru.mirea.dockercomposeapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.dockercomposeapp.models.Photo;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, String> {
}
