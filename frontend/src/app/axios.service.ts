import { Injectable } from '@angular/core';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class AxiosService {

  constructor() {
    axios.defaults.baseURL = "http://localhost:8080/api/v1"
    axios.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8';
  }

  request(method: string, url: string, data?: any): Promise<any> {
    return axios({
      method: method,
      url: url,
      data: data
    });
  }
}
