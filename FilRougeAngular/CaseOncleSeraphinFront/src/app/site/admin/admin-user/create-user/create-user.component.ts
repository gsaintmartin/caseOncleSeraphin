import { UserService } from '../../../../service/user.service';
// tslint:disable-next-line: max-line-length
<<<<<<< HEAD
import { User } from 'C:/Users/formation/Desktop/caseOncleSeraphin/caseOncleSeraphin/FilRougeAngular/CaseOncleSeraphinFront/src/app/user';
=======
import { User } from '../../../../user';
>>>>>>> 83fc68575d203433ec895006d3ccd08b1ff96869
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateuserComponent implements OnInit {

  user: User = new User();
  submitted = false;

  constructor(private userService: UserService,
              private router: Router) {
    }

  ngOnInit() {
  }

  newuser(): void {
    this.submitted = false;
    this.user = new User();
  }

  save() {
    this.userService.createUser(this.user)
      .subscribe(data => console.log(data), error => console.log(error));
    this.user = new User();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/users']);
  }
}
