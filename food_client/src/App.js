
import './App.css';
import { CssBaseline, ThemeProvider } from '@mui/material';
import { DarkTheme } from './Theme/DarkTheme';
import Navbar from './Components/Navbar/Navbar';
import Home from './Components/Home/Home';
import RestaurantDetails from './Components/Restaurant/RestaurantDetails';

function App() {
  return (
    <ThemeProvider theme={DarkTheme}>
      <CssBaseline/>
      <Navbar/>
      {/* <Home /> */}
      <RestaurantDetails />
    </ThemeProvider>
  );
}

export default App;
