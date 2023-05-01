import Daffodil from "../../public/images/Daffodil.jpeg";
import Cactus from "../../public/images/Cactus.jpeg";
import Tulip from "../../public/images/Tulip.jpeg";
import Sunflower from "../../public/images/Sunflower.jpeg";
import Orchid from "../../public/images/Orchid.jpeg";
import Default from "../../public/images/Default.jpeg";

export const getImage = (type: string): any => {
  switch (type) {
    case "Daffodil":
      return Daffodil;
    case "Cactus":
      return Cactus;
    case "Tulip":
      return Tulip;
    case "Sunflower":
      return Sunflower;
    case "Orchid":
      return Orchid;
    default:
      return Default;
  }
};