import {Component} from '@angular/core';
import {AxiosService} from '../axios.service'
import {NgForOf, CommonModule} from "@angular/common";


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
export class AuthContentComponent {
  dog: any; // Change the type as per your data structure

  constructor(private axiosService: AxiosService) {
  }

  ngOnInit(): void {
    console.log("NG on INIT called");
    this.axiosService.request(
      "GET",
      "/animals/get/1",
    ).then(
      (response: { data: any }) => {
        if (response.data) {
          this.dog = response.data;
        } else {
          console.error("No data received from the server.");
        }
      }
    );
  }
}
