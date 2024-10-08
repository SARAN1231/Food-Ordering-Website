
import './App.css';
import { CssBaseline, ThemeProvider } from '@mui/material';
import { DarkTheme } from './Theme/DarkTheme';
import Navbar from './Components/Navbar/Navbar';
import Home from './Components/Home/Home';
import RestaurantDetails from './Components/Restaurant/RestaurantDetails';
import Cart from './Components/Cart/Cart';
import Profile from './Components/profle/Profile';
import CustomerRoutes from './Components/Routers/CustomerRoutes';

function App() {
  return (
    <ThemeProvider theme={DarkTheme}>
      <CssBaseline/>
      <Navbar/>
      {/* <Home /> */}
      {/* <RestaurantDetails /> */}
      {/* <Cart /> */}
      {/* <Profile /> */}
      <CustomerRoutes/>
    </ThemeProvider>
  );
}

export default App;
