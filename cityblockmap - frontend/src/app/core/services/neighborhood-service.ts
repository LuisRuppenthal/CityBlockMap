import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { Neighborhood } from '../models/neighborhood.model';

@Injectable({
  providedIn: 'root',
})

export class NeighborhoodService {
  private http = inject(HttpClient);
  private apiUrl = 'http://127.0.0.1:8080/neighborhoods';

  getAll(): Observable<Neighborhood[]> {
    return this.http.get<Neighborhood[]>(this.apiUrl);
    //.pipe(tap(response => console.log('Resposta do backend:', response)));
  }

  getById(id: number): Observable<Neighborhood> {
    return this.http.get<Neighborhood>(`${this.apiUrl}/${id}`);
  }
}  