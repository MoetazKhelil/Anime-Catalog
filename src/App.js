import './App.css';
import api from './api/axiosConfig';
import {useState, useEffect} from 'react';
import Layout from './components/Layout';
import {Routes, Route} from 'react-router-dom'
import Home from './components/home/Home';

function App() {

  const [animes, setAnimes] = useState([]);

  const getAnimes = async () =>{

    try
    {

      const response = await api.get("/api/v1/animes");

      console.log(response.data);

      setAnimes(response.data);

    } 
    catch(err)
    {
      console.log(err);
    }

  }

  useEffect(() => {
    getAnimes();
  },[])

  return (
    <div className="App">
      
      <Routes>
        <Route path="/" element={<Layout/>}>
          <Route path="/" element={<Home animes = {animes} />}></Route>


        </Route>

      </Routes>
    </div>
  );
}

export default App;
