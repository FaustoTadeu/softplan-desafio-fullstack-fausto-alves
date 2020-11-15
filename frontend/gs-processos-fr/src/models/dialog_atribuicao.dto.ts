import { UsuariosDTO } from './usuarios.dto';

export class DialogAtribuicaoDTO {
    idProcessos: number;
    numeroProcessos: string;
    tituloProcessos: string;
    usuariosProcessos: UsuariosDTO[];
}
