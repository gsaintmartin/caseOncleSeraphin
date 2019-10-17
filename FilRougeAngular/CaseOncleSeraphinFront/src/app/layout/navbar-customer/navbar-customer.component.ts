import { Component, OnInit } from '@angular/core';
import { LoginComponent } from 'src/app/login/login.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AuthenticationService } from 'src/app/service/authentication.service';

@Component({
  selector: 'app-navbar-customer',
  templateUrl: './navbar-customer.component.html',
  styleUrls: ['./navbar-customer.component.css']
})
export class NavbarCustomerComponent implements OnInit {

  constructor(private modalService: NgbModal, public loginService: AuthenticationService) { }

  navbarOpen = false;

  ngOnInit() {
  }

  toggleNavbar() {

this.navbarOpen = !this.navbarOpen;

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

