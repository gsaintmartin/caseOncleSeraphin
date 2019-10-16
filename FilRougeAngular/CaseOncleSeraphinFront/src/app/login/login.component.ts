import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { LoginInfo } from '../login-info';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginInfo: LoginInfo = new LoginInfo();

  constructor(private activeModalService: NgbActiveModal) { }

  ngOnInit() {
  }

  passBack() {
    this.activeModalService.close(this.loginInfo);
  }

  dismiss() {
    this.activeModalService.close();
  }
}
