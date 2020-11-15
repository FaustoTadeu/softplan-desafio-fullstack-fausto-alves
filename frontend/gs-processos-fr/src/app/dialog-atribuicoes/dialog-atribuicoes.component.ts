import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { DialogDTO } from 'src/models/dialog.dto';
import { DomSanitizer } from '@angular/platform-browser';
import { DialogAtribuicaoDTO } from 'src/models/dialog_atribuicao.dto';
import { UsuariosDTO } from 'src/models/usuarios.dto';
import { FormControl } from '@angular/forms';

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
    posicao = new FormControl();

    constructor(
        public dialogRef: MatDialogRef<DialogAtribuicoesComponent>,
        @Inject(MAT_DIALOG_DATA) public data: DialogAtribuicaoDTO,
        private sanitized: DomSanitizer
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
}
