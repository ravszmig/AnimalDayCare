import {Component, OnInit} from '@angular/core';
import {AxiosService} from '../axios.service'
import {NgForOf, CommonModule} from "@angular/common";
import {Owner} from "../interfaces/owner.interface";


@Component({
  selector: 'app-auth-content',
  standalone: true,
  imports: [
    NgForOf,
    CommonModule,
  ],
  templateUrl: './auth-content.component.html',
  styleUrl: './auth-content.component.scss'
})
export class AuthContentComponent implements OnInit {
  owner: Owner | undefined;

  constructor(private axiosService: AxiosService) {}

  ngOnInit(): void {
    console.log("NG on INIT called");
    this.axiosService.request(
      "GET",
      "/owners/get/1",
    ).then(
      (response: any) => {
        if (response.data) {
          this.owner = response.data;
        } else {
          console.error("No data received from the server.");
        }
      }
    );
  }
}
