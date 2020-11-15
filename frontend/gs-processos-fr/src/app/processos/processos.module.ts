import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProcessosRoutingModule } from './processos.routing.module';
import { ProcessosComponent } from './processos.component';
import { MatFormFieldModule, MatSelectModule, MatOptionModule, MatTabsModule,
         MatButtonModule, MatInputModule, MatTableModule, MatIconModule,
         MatRadioModule, MatSlideToggleModule } from '@angular/material';
import { FormsModule } from '../layout/forms/forms.module';
import { ReactiveFormsModule } from '@angular/forms';
import { TableUsuariosComponent } from '../tableusuarios/tableusuarios.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { NgxMaskModule } from 'ngx-mask';
import { TableProcessosComponent } from '../tableprocessos/tableprocessos.component';

@NgModule({
    imports: [CommonModule,
               ProcessosRoutingModule,
               MatFormFieldModule,
               MatSelectModule,
               MatOptionModule,
               FormsModule,
               ReactiveFormsModule,
               MatTabsModule,
               MatButtonModule,
               MatInputModule,
               MatTableModule,
               MatIconModule,
               FlexLayoutModule,
               MatRadioModule,
               MatSlideToggleModule,
               NgxMaskModule
             ],
    declarations: [ProcessosComponent, TableProcessosComponent]
})
export class ProcessosModule {}
