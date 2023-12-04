package dev.moetaz.anime;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeService {
    @Autowired
    private AnimeRepository animeRepository;

    public List<Anime> getAllAnimes(){
        return animeRepository.findAll();
    }

    public Optional<Anime> getSingleAnime (String ranking ) {
        return animeRepository.findAnimeByRanking(ranking);
    }

}
