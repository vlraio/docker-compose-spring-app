package ru.mirea.dockercomposeapp.models;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "photos")
public class Photo {
    private String id;

    private Binary data;
}
