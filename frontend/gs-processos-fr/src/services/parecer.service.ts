import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_CONFIG } from 'src/config/api.config';
import { CadastrarParecerDTO } from 'src/models/cadastrar_parecer.dto';
import { ParecerDTO } from 'src/models/parecer.dto';
import { ParecerAtribuicaoDTO } from 'src/models/parecer_atribuicao.dto';

@Injectable()
export class ParecerService {

  constructor(private http: HttpClient) { }

  atribuirParecer(parecer: ParecerAtribuicaoDTO): Observable<ParecerDTO>  {
    return this.http.post<ParecerDTO>(`${API_CONFIG.baseUrl}/parecer/atribuirProcessoUsuario`, parecer);
  }

  cadastrarParecer(cadParecer: CadastrarParecerDTO): Observable<ParecerDTO>  {
    return this.http.post<ParecerDTO>(`${API_CONFIG.baseUrl}/parecer/cadastrarParecer`, cadParecer);
  }

  pesquisarListaParecerPorUsuario(): Observable<ParecerDTO[]> {
    return this.http.get<ParecerDTO[]>(`${API_CONFIG.baseUrl}/parecer`);
  }
}
