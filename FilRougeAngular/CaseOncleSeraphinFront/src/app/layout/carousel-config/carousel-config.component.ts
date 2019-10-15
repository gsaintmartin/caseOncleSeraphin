import { Component, OnInit } from '@angular/core';
import { CarouselConfig } from 'ngx-bootstrap/carousel';

@Component({
  selector: 'app-carousel-config',
  templateUrl: './carousel-config.component.html',
  styleUrls: ['./carousel-config.component.css'],
  providers: [
    { provide: CarouselConfig, useValue: { interval: 5000, noPause: true, showIndicators: true } }
  ]
})

export class CarouselConfigComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
