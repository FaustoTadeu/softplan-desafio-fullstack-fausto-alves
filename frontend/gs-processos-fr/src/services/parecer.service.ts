import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_CONFIG } from 'src/config/api.config';
import { ParecerDTO } from 'src/models/parecer.dto';
import { ParecerAtribuicaoDTO } from 'src/models/parecer_atribuicao.dto';

@Injectable()
export class ParecerService {

  constructor(private http: HttpClient) { }

  inserirEditarParecer(parecer: ParecerDTO): Observable<ParecerDTO>  {
    if (parecer.idParecer === null) {
        return this.http.post<ParecerDTO>(`${API_CONFIG.baseUrl}/parecer`, parecer);
    } else {
      return this.http.put<ParecerDTO>(`${API_CONFIG.baseUrl}/parecer`, parecer);
    }
  }

  atribuirParecer(parecer: ParecerAtribuicaoDTO): Observable<ParecerDTO>  {
    return this.http.post<ParecerDTO>(`${API_CONFIG.baseUrl}/parecer/atribuirProcessoUsuario`, parecer);
  }
}
