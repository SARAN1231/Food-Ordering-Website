import {
  Accordion,
  AccordionDetails,
  AccordionSummary,
  Button,
  Checkbox,
  FormControlLabel,
  FormGroup,
} from "@mui/material";

import ExpandCircleDownIcon from "@mui/icons-material/ExpandCircleDown";

// const ingredients = [
//   { category: "Nuts & seeds", ingredients: "Cashews" },
//   { category: "Protein", ingredients: "Protein" },
//   { category: "Protein", ingredients: "Bacon strips" },
// ];

const demos = [
  { category: "Nuts & seeds", ingredients: ["Cashews"] },
  { category: "Protein", ingredients: ["Protein", "Bacon strips"] },
];

const MenuCard = () => {

    const handlecheckboxchange = (ingredient) => {
        console.log(ingredient);
    }
  return (
    <Accordion>
      <AccordionSummary
        expandIcon={<ExpandCircleDownIcon />}
        aria-controls="panell-content"
        id="panel1-header"
      >
        <div className="lg:flex items-center justify-between">
          <div className="lg:flex items-center lg:gap-5">
            <img src="https://via.placeholder.com/150" alt="" />
            <div className="space-y-1 lg:space-y-5 lg:max-w-2xl">
              <p className="font-semibold text-lg">Chicken Biryani</p>
              <p>$499</p>
              <p className="text-gray-400">nice food</p>
            </div>
          </div>
        </div>
      </AccordionSummary>
      <AccordionDetails>
        <form>
          <div className="flex gap-5 flex-wrap">
            {demos.map((demo, index) => (
              <div>
                <p className="font-semibold">{demo.category}</p>
                <FormGroup>
                  {demo.ingredients.map((ingredient, index) => (
                    <FormControlLabel
                      key={index}
                      control={<Checkbox onChange={() => handlecheckboxchange(ingredient)} />}
                      label={ingredient}
                    />
                  ))}
                </FormGroup>
              </div>
            ))}
          </div>

          <div className="pt-5">
            <Button variant="contained" disabled={false} type="submit">
        
              {true ? "Add to Cart" : "Out OF Stock"}
            </Button>
          </div>
        </form>
      </AccordionDetails>{" "}
    </Accordion>
  );
};

export default MenuCard; 
