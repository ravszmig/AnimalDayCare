import {Animal} from "./animal.interface";

export interface Owner {
  id: number;
  name: string;
  animals: Animal[];
}
