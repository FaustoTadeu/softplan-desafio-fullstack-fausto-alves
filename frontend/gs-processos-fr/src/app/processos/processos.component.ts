import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ProcessosService } from 'src/services/processos.service';
import { AuthService } from 'src/services/auth.service';
import { Router } from '@angular/router';
import { ProcessosDTO } from 'src/models/processos.dto';
import { MatDialog } from '@angular/material';
import { DialogOverviewComponent } from '../dialog-overview/dialog-overview.component';
import { ProcessoNovoDTO } from 'src/models/processo_novo.dto';

@Component({
    selector: 'app-processos',
    templateUrl: './processos.component.html',
    styleUrls: ['./processos.component.scss']
})
export class ProcessosComponent implements OnInit {

    nvProcesso: ProcessoNovoDTO;
    idProcessos = new FormControl();
    numeroProcessos = new FormControl();
    tituloProcessos = new FormControl();
    textoProcessos = new FormControl();
    dataProcessos = new FormControl();
    statusProcessos = new FormControl();
    editar: boolean;

    constructor( private processosService: ProcessosService,
        private authService: AuthService,
        private router: Router,
        private dialog: MatDialog) {}

    ngOnInit() {
        this.authService.refreshToken().subscribe(response => {
            this.authService.successfulLogin(response.headers.get('Authorization'));
            this.editar = false;
          },
          error => {
            this.router.navigate(['/login']);
          });
    }

    inserirEditarProcessos() {
        if (this.numeroProcessos.value == null || this.numeroProcessos.value === undefined
            || this.tituloProcessos.value == null || this.tituloProcessos.value === undefined
            || this.textoProcessos.value == null || this.textoProcessos.value === undefined
            ) {
                this.openDialog('400', 'Dados Inválidos', 'Todos os campos são obrigatórios. Preencha todos.');
            return false;
        }
        // tslint:disable-next-line:max-line-length
        const processoObject = this.montaProcesso(this.idProcessos.value, this.numeroProcessos.value, this.tituloProcessos.value, this.textoProcessos.value, this.statusProcessos.value);
        this.processosService.inserirEditarProcessos(processoObject).subscribe(response => {
            this.nvProcesso = response;
            this.editar = false;
            this.idProcessos.setValue(null);
            this.numeroProcessos.setValue(null);
            this.tituloProcessos.setValue(null);
            this.textoProcessos.setValue(null);
            this.dataProcessos.setValue(null);
            this.statusProcessos.setValue('A');
            // tslint:disable-next-line:max-line-length
            this.openDialog('200', 'Processo criado/editado com sucesso',
                            'Número: ' + this.nvProcesso.numeroProcesso + '<br /> Título: ' + this.nvProcesso.tituloProcesso);
        },
        error => {});
    }

    montaProcesso(idProcessos: number, numeroProcessos: string, tituloProcessos: string, textoProcessos: string, statusProcessos: string) {
        const processo = new ProcessosDTO();
        processo.idProcessos = idProcessos;
        processo.numeroProcessos = numeroProcessos;
        processo.tituloProcessos = tituloProcessos;
        processo.textoProcessos = textoProcessos;
        processo.statusProcessos = statusProcessos != null ? statusProcessos : 'A';
        return processo;
    }

   povoarFormulario(event) {
       this.idProcessos.setValue(event.idProcessos);
       this.numeroProcessos.setValue(event.numeroProcessos);
       this.tituloProcessos.setValue(event.tituloProcessos);
       this.textoProcessos.setValue(event.textoProcessos);
       this.dataProcessos.setValue(event.dataProcessos);
       this.statusProcessos.setValue('A');
       this.editar = true;
   }

   limparFormulario() {
        this.idProcessos.setValue(null);
        this.numeroProcessos.setValue(null);
        this.tituloProcessos.setValue(null);
        this.textoProcessos.setValue(null);
        this.dataProcessos.setValue(null);
        this.statusProcessos.setValue('');
        this.editar = false;
   }

   openDialog(status, error, message) {
    this.dialog.open(DialogOverviewComponent, {
        width: '350px',
        data: {
               titulo: status + ' - ' + error,
               texto: message
              }
    });
   }
}
