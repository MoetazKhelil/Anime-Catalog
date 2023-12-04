package dev.moetaz.anime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "animes")
@Data
@AllArgsConstructor  // constructor that takes all attributes as input
@NoArgsConstructor   // constructor that doesnt take any attribute
public class Anime {
    @Id
    private ObjectId id;
    private String ranking;
    private String title;
    private String releaseDate;
    private List<String> genres;
    private String poster;
    private List<String> backdrops;

    @DocumentReference
    private List<Review> reviewIds;
}
