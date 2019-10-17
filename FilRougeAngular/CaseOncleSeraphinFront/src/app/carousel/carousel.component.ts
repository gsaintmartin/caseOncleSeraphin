import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css']
})
export class CarouselComponent implements OnInit {
  // Some random event list
  eventList = [
    {
      event: ' Event 1',
      eventLocation: 'EL DORADO 15 ans 43%',
      // tslint:disable-next-line: max-line-length
      eventDescription: '  '
      ,
      img: 'assets/images/bottles/CARROUSSEL/el-dorado-15.jpg',

    },
     {
      event: ' Event 2',
      eventLocation: 'FLOR DE CANA 18 ans 40%',
      // tslint:disable-next-line: max-line-length
      eventDescription: 'Le 31 juillet 1970, une coutume vieille de 300 ans prenait fin. ',
      img: 'assets/images/bottles/CARROUSSEL/flor-de-cana-18.jpg',

    },
     {
      event: ' Event 3',
      eventLocation: 'SAVANNA 15 ans 1999 Millenium 43%',
      // tslint:disable-next-line: max-line-length
      eventDescription: 'Le 31 juillet 1970, une coutume vieille de 300 ans prenait fin. ',
      img: 'assets/images/bottles/CARROUSSEL/savanna.jpg',

    },

  ];


  constructor() {
  }
  ngOnInit() {
  }
}
