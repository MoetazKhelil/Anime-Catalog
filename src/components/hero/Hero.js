import './Hero.css';
import Carousel from 'react-material-ui-carousel';
import { Paper } from '@mui/material';

const Hero = ({animes}) => {
  return (
    <div>
        <Carousel>
            {
                animes.map((anime) => {
                    return(
                        <Paper>
                            <div ClassName = 'anime-card-container'>
                                <div className = "anime-card" style={{"--img": `url(${anime.backdrops[0]})`}}>
                                    <div className = "anime-detail">
                                        <div className = "anime-poster">
                                            <img src={anime.poster} alt ="" className="posters" />
                                        </div>
                                        <div className="anime-title">
                                            <h4>{anime.title}</h4>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </Paper>
                    )
                })
            }
        </Carousel>
    </div>
  )
}

export default Hero