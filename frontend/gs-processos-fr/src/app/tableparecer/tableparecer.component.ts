import { Component, OnInit, ViewChild, Input, Output, EventEmitter } from '@angular/core';
import { MatSort, MatTableDataSource, MatDialog } from '@angular/material';
import { UsuariosService } from 'src/services/usuarios.service';
import { UsuariosDTO } from 'src/models/usuarios.dto';
import { DialogOverviewComponent } from '../dialog-overview/dialog-overview.component';
import { ParecerDTO } from 'src/models/parecer.dto';
import { ParecerService } from 'src/services/parecer.service';
import { DatePipe } from '@angular/common';
import { DialogParecerComponent } from '../dialog-parecer/dialog-parecer.component';

@Component({
    selector: 'app-table-parecer',
    templateUrl: './tableparecer.component.html',
    styleUrls: ['./tableparecer.component.scss']
})
export class TableParecerComponent implements OnInit {

    displayedColumns = ['numeroProcesso', 'tituloProcesso', 'nomeUsuario', 'textoParecer', 'dataParecer', 'decisaoParecer', 'atInParecer'];
    dataSource: MatTableDataSource<ParecerDTO>;


    constructor(private parecerService: ParecerService, private dialog: MatDialog, private datePipe: DatePipe) { }


    @Input()
    set novoParecer(novoProcesso: number) {
        this.reloadPage();
    }

    @ViewChild(MatSort) sort: MatSort;
    ngOnInit() {
        this.parecerService.pesquisarListaParecerPorUsuario().subscribe(response => {
            const dateP = this.datePipe;
            response.forEach(function (value) {
                if (value.dataParecer != null) {
                    value.dataParecer = dateP.transform(value.dataParecer, 'dd/MM/yyyy');
                }
            });
            this.dataSource = new MatTableDataSource(response);
            this.dataSource.sort = this.sort;
          },
          error => {});
    }

    visualizarParecer () {

    }

    cadastrarParecer (idParecer, numero, titulo, textoParecer, decisaoParecer) {
        this.openDialogParecer(idParecer, numero, titulo, textoParecer, decisaoParecer);

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

       openDialogParecer(idParecer, numero, titulo, textoParecer, decisaoParecer) {
        this.dialog.open(DialogParecerComponent, {
            width: '350px',
            height: '450px',
            data: {
                idParecer: idParecer,
                tituloProcesso: titulo,
                numeroProcesso: numero,
                textoParecer: textoParecer,
                decisaoParecer: decisaoParecer
            }
        });
       }
}
