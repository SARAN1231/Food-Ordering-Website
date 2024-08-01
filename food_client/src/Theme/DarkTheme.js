import { createTheme } from "@mui/material";

export const DarkTheme = createTheme({
    palette: {
        mode: "dark", // Sets the theme to dark mode
        primary: {
            main: "#e91e63", // Sets the primary color to a shade of pink
        },
        secondary: {
            main: "#5A20CB", // Sets the secondary color to a shade of purple
        },
        black: {
            main: "#242B2E", // Custom color named black
        },
        background: {
            main: "#000000", // Custom background main color
            default: "#0D0D0D", // Default background color
            paper: "#0D0D0D", // Background color for paper elements
        },
        textColor: {
            main: "#111111", // Custom text color
        },
    },
});
