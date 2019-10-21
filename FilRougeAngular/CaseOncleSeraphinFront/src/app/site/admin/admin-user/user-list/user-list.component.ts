import { UserDetailsComponent } from '../user-details/user-details.component';
import { Observable } from 'rxjs';
import { UserService } from '../user.service';
import { User } from '../user';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: Observable<User[]>;

  constructor(private employeeService: UserService,
              private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.employees = this.employeeService.getUserList();
  }

  deleteEmployee(id: number) {
    this.userService.deleteUser(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  userDetails(id: number) {
    this.router.navigate(['details', id]);
  }
}
