import { Component, OnInit, ViewChild, Input, Output, EventEmitter } from '@angular/core';
import { MatSort, MatTableDataSource, MatDialog } from '@angular/material';
import { UsuariosDTO } from 'src/models/usuarios.dto';
import { EmailDTO } from 'src/models/email.dto';
import { DialogOverviewComponent } from '../dialog-overview/dialog-overview.component';
import { StatusProcessosDTO } from 'src/models/status_processos.dto';
import { ProcessosDTO } from 'src/models/processos.dto';
import { ProcessosService } from 'src/services/processos.service';
import { DatePipe } from '@angular/common';
import { UsuariosService } from 'src/services/usuarios.service';
import { DialogAtribuicoesComponent } from '../dialog-atribuicoes/dialog-atribuicoes.component';

@Component({
    selector: 'app-table-processos',
    templateUrl: './tableprocessos.component.html',
    styleUrls: ['./tableprocessos.component.scss']
})
export class TableProcessosComponent implements OnInit {


    @Output() change = new EventEmitter();

    statusProcesso = new StatusProcessosDTO();
    email = new EmailDTO();
    displayedColumns = ['numeroProcessos', 'tituloProcessos', 'textoProcessos', 'dataProcessos', 'atribuicoesProcessos',  'atInProcessos'];
    dataSource: MatTableDataSource<ProcessosDTO>;


    constructor(
        private processosService: ProcessosService,
        private usuariosService:  UsuariosService,
        private dialog: MatDialog,
        private datePipe: DatePipe) { }

    @Input()
    set novoProcesso(novoProcesso: ProcessosDTO) {
        this.reloadPage();
    }

    @Input()
    set novoParecer(novoProcesso: number) {
        this.reloadPage();
    }

    @ViewChild(MatSort) sort: MatSort;
    ngOnInit() {
        this.processosService.pesquisarListaProcessos().subscribe(response => {
            const dateP = this.datePipe;
            response.forEach(function (value) {
                if (value.dataProcessos != null) {
                    value.dataProcessos = dateP.transform(value.dataProcessos, 'dd/MM/yyyy');
                }
            });
            this.dataSource = new MatTableDataSource(response);
            this.dataSource.sort = this.sort;
          },
          error => {});
    }

    ativaInativaProcessos(idProcesso: number, event: any) {
        this.statusProcesso.checked = event.checked === true ? 'A' : 'I';
        this.statusProcesso.idProcessos = idProcesso;
        const statusProcesso = event.checked === true ? 'Ativado' : 'Inativado';
        this.processosService.alterarStatusProcessos(this.statusProcesso).subscribe(response => {
            this.openDialog('200', 'Status Alterado', 'Processo ' + idProcesso + ' ' + statusProcesso + ' com sucesso!');
            this.reloadPage();
        },
        error => {
            this.openDialog('500', 'Erro de Servidor', 'Ocorreu um erro ao ativar/inativar o usuario.');
        });
    }

    apagarProcessos (idProcesso: number) {
        this.statusProcesso.checked = 'E';
        this.statusProcesso.idProcessos = idProcesso;
        this.processosService.alterarStatusProcessos(this.statusProcesso).subscribe(response => {
            this.openDialog('200', 'Exclusão de Processo', 'Processo ' + idProcesso + ' excluído de forma permanente com sucesso.');
            this.reloadPage();
        },
        error => {
            this.openDialog('500', 'Erro de Servidor', 'Ocorreu um erro ao excluir o processo.');
        });
    }

    editarProcessos(processoDTO: ProcessosDTO) {
        if ( processoDTO.statusProcessos !== 'A' ) {
            this.openDialog('400', 'Edição não permitida', 'Somente é permitido alterar processo com status de Ativo!');
        } else {
            this.change.emit(processoDTO);
        }
    }

    atribuirUsuarioProcesso (idProcesso: number, numeroProcesso: string, tituloProcesso: string ) {
        this.usuariosService.pesquisarListaUsuarios().subscribe(response => {
            this.openDialogAtribuicoes(idProcesso, numeroProcesso, tituloProcesso, response);
          },
          error => {});
    }

    reloadPage () {
        this.ngOnInit();
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

    openDialogAtribuicoes(idProcessso, numeroProcesso, tituloProcesso, response) {

        this.dialog.open(DialogAtribuicoesComponent, {
            width: '500px',
            data: {
                   idProcessos: idProcessso,
                   numeroProcessos: numeroProcesso,
                   tituloProcessos: tituloProcesso,
                   usuariosProcessos: response
                  }
        }).afterClosed().subscribe( () => {
           this.reloadPage();
        });
       }


}
