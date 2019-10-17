import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AuthenticationService } from 'src/app/service/authentication.service';
import { LoginComponent } from 'src/app/login/login.component';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private modalService: NgbModal, public loginService: AuthenticationService) { }

  ngOnInit() {
  }

  openModal() {
    const modalRef = this.modalService.open(LoginComponent);
    modalRef.result.then((result) => {
      if (result) {
        console.log(result);
      }
    });
  }
}
