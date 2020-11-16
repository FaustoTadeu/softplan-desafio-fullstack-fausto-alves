import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialog } from '@angular/material';
import { FormControl } from '@angular/forms';
import { ParecerService } from 'src/services/parecer.service';
import { DialogOverviewComponent } from '../dialog-overview/dialog-overview.component';
import { DialogParecerDTO } from 'src/models/dialog_parecer.dto';
import { CadastrarParecerDTO } from 'src/models/cadastrar_parecer.dto';

@Component({
    selector: 'app-dialog-parecer',
    templateUrl: './dialog-parecer.component.html',
    styleUrls: ['./dialog-parecer.component.scss']
})
export class DialogParecerComponent implements OnInit {

    idParecer = new FormControl();
    tituloProcesso = new FormControl();
    numeroProcesso = new FormControl();
    textoParecer = new FormControl();
    decisaoParecer = new FormControl();


    constructor(
        public dialogRef: MatDialogRef<DialogParecerComponent>,
        @Inject(MAT_DIALOG_DATA) public data: DialogParecerDTO,
        private parecerService: ParecerService,
        private dialog: MatDialog
    ) {}

    ngOnInit() {
        this.idParecer.setValue(this.data.idParecer);
        this.tituloProcesso.setValue(this.data.tituloProcesso);
        this.numeroProcesso.setValue(this.data.numeroProcesso);
        this.textoParecer.setValue(this.data.textoParecer);
        this.decisaoParecer.setValue(this.data.decisaoParecer);
        console.log(this.tituloProcesso);
    }

    onNoClick(): void {
        this.dialogRef.close();
    }

    cadastrarParecer() {
        if (this.idParecer == null || this.idParecer === undefined ||
            this.textoParecer.value == null || this.textoParecer.value === undefined
            || this.decisaoParecer == null || this.decisaoParecer === undefined ) {
                this.openDialog('400', 'Dados Inválidos', 'Todos os campos são obrigatórios. Preencha todos.');
                return false;
            }
            const cadParecer = new  CadastrarParecerDTO();
            cadParecer.idParecer = this.idParecer.value;
            cadParecer.textoParecer = this.textoParecer.value;
            cadParecer.decisaoParecer = this.decisaoParecer.value;

            this.parecerService.cadastrarParecer(cadParecer).subscribe(response => {
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
