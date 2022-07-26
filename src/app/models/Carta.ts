export class Carta {
    id: string;
    name: string;
    description: string;
    url: string;
    poder: number;
  
    constructor(id: string, name: string, description: string, url: string, poder: number) {
      this.id = id;
      this.name = name;
      this.description = description;
      this.url = url;
      this.poder = poder;
    }
}