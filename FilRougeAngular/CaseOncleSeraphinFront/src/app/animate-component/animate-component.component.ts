import { Component, OnInit , Input} from '@angular/core';
import {trigger, state, style, animate, transition, keyframes} from '@angular/animations';
@Component({
  selector: 'app-animate-component',
  templateUrl: './animate-component.component.html',
  styleUrls: ['./animate-component.component.css'],
  animations: [
trigger ('changeState', [
state ('state1', style({backgroundColor: 'green', transform: 'scale(1)'})),
state ('state2', style({backgroundColor: 'red', transform: 'scale(1.5)'})),
transition ('*=> state1', animate ('300ms')),
transition('*=> state2', animate ('2000ms'))
])
]
})
export class AnimateComponentComponent implements OnInit {

  @Input() currentState;

  constructor() { }

  ngOnInit() {
  }

}
