package dev.moetaz.anime;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/animes")


public class AnimeController {
    @Autowired
    private AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> allAnimes() {
        return new ResponseEntity<List<Anime>>(animeService.getAllAnimes(), HttpStatus.OK);
    }

    @GetMapping("/{ranking}")
    public ResponseEntity<Optional<Anime>> getOneAnime(@PathVariable String ranking) {
        return new ResponseEntity<Optional<Anime>>(animeService.getSingleAnime(ranking), HttpStatus.OK);
    }
}
