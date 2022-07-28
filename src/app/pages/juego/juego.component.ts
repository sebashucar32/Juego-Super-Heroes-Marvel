import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Carta } from 'src/app/models/Carta';
import { CartaServiceService } from 'src/app/services/carta-service.service';

@Component({
  selector: 'app-juego',
  templateUrl: './juego.component.html',
  styleUrls: ['./juego.component.css']
})

export class JuegoComponent implements OnInit {
  public  pin = localStorage.getItem("pin");
  cartas: any;
  cartasAleatorias: any = [];
  nombreCartas: any;
  cartasAleatorias2: any = [];

  public carta1: any;
  
  public carta2: any;
  public carta3: any;
  public carta4: any;
  public carta5: any;
  public carta6: any;
  public carta7: any;
  public carta8: any;
  public carta9: any;
  public carta10: any;
  public carta11: any;

  constructor(private router: Router, private cartaService: CartaServiceService) { }

  ngOnInit(): void {
    this.cartaService.getCartas().subscribe(cartas => {
      this.cartas = cartas;
      console.log(this.cartas);
      let nombreCartas: string[] = [];

      this.cartas.forEach((carta: { url: any; }) => nombreCartas.push(carta.url));
      
      for(let i=0; i < 6; i++) {
        let aleatorio = nombreCartas[Math.floor(Math.random() * nombreCartas.length)];
        this.cartasAleatorias.push(aleatorio);
      }

      for(let i=0; i < 6; i++) {
        let nuevasCartas = this.cartas.filter((cartica: { url: any; }) => cartica.url === this.cartasAleatorias[i]);
        this.cartasAleatorias2.push(nuevasCartas);
      }

      console.log(this.cartasAleatorias2);

      this.carta1 = this.cartasAleatorias2[0];
      this.carta1 = this.carta1[0];

      this.carta2 = this.cartasAleatorias2[1];
      this.carta3 = this.carta2[0];

      this.carta4 = this.cartasAleatorias2[2];
      this.carta5 = this.carta4[0];

      this.carta6 = this.cartasAleatorias2[3];
      this.carta7 = this.carta6[0];

      this.carta8 = this.cartasAleatorias2[4];
      this.carta9 = this.carta8[0];

      this.carta10 = this.cartasAleatorias2[5];
      this.carta11 = this.carta10[0];
    });
  }

  cerrarSesion() {
    localStorage.removeItem("correo");
    localStorage.removeItem("pin");
    this.router.navigateByUrl('/login');
  }
}
