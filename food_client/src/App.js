
import './App.css';
import { CssBaseline, ThemeProvider } from '@mui/material';
import { DarkTheme } from './Theme/DarkTheme';
import Navbar from './Components/Navbar/Navbar';
import Home from './Components/Home/Home';

function App() {
  return (
    <ThemeProvider theme={DarkTheme}>
      <CssBaseline/>
      <Navbar/>
      <Home />
    </ThemeProvider>
  );
}

export default App;
