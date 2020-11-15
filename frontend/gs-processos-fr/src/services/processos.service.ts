import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_CONFIG } from 'src/config/api.config';
import { ProcessosDTO } from 'src/models/processos.dto';
import { ProcessoNovoDTO } from 'src/models/processo_novo.dto';
import { StatusProcessosDTO } from 'src/models/status_processos.dto';

@Injectable()
export class ProcessosService {

  constructor(private http: HttpClient) { }

  inserirEditarProcessos(processo: ProcessosDTO): Observable<ProcessoNovoDTO>  {
    if (processo.idProcessos === null) {
        return this.http.post<ProcessoNovoDTO>(`${API_CONFIG.baseUrl}/processos`, processo);
    } else {
      return this.http.put<ProcessoNovoDTO>(`${API_CONFIG.baseUrl}/processos`, processo);
    }
  }

  pesquisarListaProcessos (): Observable<ProcessosDTO[]> {
    return this.http.get<ProcessosDTO[]>(`${API_CONFIG.baseUrl}/processos`);
  }

  buscarProcessoPorId (idProcesso: number): Observable<ProcessosDTO> {
    return this.http.get<ProcessosDTO>(`${API_CONFIG.baseUrl}/processos/${idProcesso}`);
  }

  alterarStatusProcessos (statusProcesso: StatusProcessosDTO): Observable<StatusProcessosDTO> {
    return this.http.post<StatusProcessosDTO>(`${API_CONFIG.baseUrl}/processos/alterarStatusProcessos`, statusProcesso);
  }
}
