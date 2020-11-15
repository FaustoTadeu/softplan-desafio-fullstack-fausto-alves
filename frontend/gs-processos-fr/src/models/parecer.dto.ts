import { ProcessosDTO } from './processos.dto';
import { UsuariosDTO } from './usuarios.dto';

export class ParecerDTO {
    idParecer: number;
    textoParecer: string;
    decisaoParecer: string;
    dataParecer: string;
    usuarioParecer: UsuariosDTO;
    processoParecer: ProcessosDTO;
}
