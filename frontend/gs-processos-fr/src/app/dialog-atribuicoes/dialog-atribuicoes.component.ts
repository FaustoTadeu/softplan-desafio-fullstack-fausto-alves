import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialog } from '@angular/material';
import { DialogAtribuicaoDTO } from 'src/models/dialog_atribuicao.dto';
import { UsuariosDTO } from 'src/models/usuarios.dto';
import { FormControl } from '@angular/forms';
import { ParecerService } from 'src/services/parecer.service';
import { DialogOverviewComponent } from '../dialog-overview/dialog-overview.component';
import { ParecerAtribuicaoDTO } from 'src/models/parecer_atribuicao.dto';

@Component({
    selector: 'app-dialog-atribuicoes',
    templateUrl: './dialog-atribuicoes.component.html',
    styleUrls: ['./dialog-atribuicoes.component.scss']
})
export class DialogAtribuicoesComponent implements OnInit {
    idProcessos: number;
    numeroProcessos: string;
    tituloProcessos: string;
    usuarios: UsuariosDTO[];
    usuarioSelecionado = new FormControl();
    nvParecer: number;

    constructor(
        public dialogRef: MatDialogRef<DialogAtribuicoesComponent>,
        @Inject(MAT_DIALOG_DATA) public data: DialogAtribuicaoDTO,
        private parecerService: ParecerService,
        private dialog: MatDialog
    ) {}

    ngOnInit() {
        this.idProcessos = this.data.idProcessos;
        this.numeroProcessos = this.data.numeroProcessos;
        this.tituloProcessos = this.data.tituloProcessos;
        this.usuarios = this.data.usuariosProcessos;
    }

    onNoClick(): void {
        this.dialogRef.close();
    }

    atribuirParecer() {
        if (this.usuarioSelecionado.value == null || this.usuarioSelecionado.value === undefined
            || this.idProcessos == null || this.idProcessos === undefined ) {
                this.openDialog('400', 'Dados Inválidos', 'Todos os campos são obrigatórios. Preencha todos.');
                return false;
            }
            const parecerAtribuicaoDto = new  ParecerAtribuicaoDTO();
            parecerAtribuicaoDto.idProcesso = this.idProcessos;
            parecerAtribuicaoDto.idUsuario = this.usuarioSelecionado.value;

            this.parecerService.atribuirParecer(parecerAtribuicaoDto).subscribe(response => {
                this.dialogRef.close();
            },
            error => {});

    }

    openDialog(status, error, message) {
        this.dialog.open(DialogOverviewComponent, {
            width: '350px',
            data: {
                   titulo: status + ' - ' + error,
                   texto: message
                  },
        });
       }
}
