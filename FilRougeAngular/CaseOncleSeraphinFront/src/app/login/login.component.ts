import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { LoginInfo } from '../login-info';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username = '';
  password = '';
  invalidLogin = false;

  loginInfo: LoginInfo = new LoginInfo();

  constructor(private activeModalService: NgbActiveModal,
    // tslint:disable-next-line: align
    private loginservice: AuthenticationService) { }

  ngOnInit() {
  }

  passBack() {
    this.activeModalService.close(this.loginInfo);
  }

  dismiss() {
    this.activeModalService.close();
  }
  checkLogin() {
    if (this.loginservice.authenticate(this.username, this.password)
    ) {
      this.invalidLogin = false;

    } else {
       this.invalidLogin = true;
    }
  }
}
