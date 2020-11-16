import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ParecerRoutingModule } from './parecer.routing.module';
import { ParecerComponent } from './parecer.component';
import { MatFormFieldModule, MatSelectModule, MatOptionModule, MatTabsModule,
         MatButtonModule, MatInputModule, MatTableModule, MatIconModule,
         MatRadioModule, MatSlideToggleModule } from '@angular/material';
import { FormsModule } from '../layout/forms/forms.module';
import { ReactiveFormsModule } from '@angular/forms';
import { TableParecerComponent } from '../tableparecer/tableparecer.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { NgxMaskModule } from 'ngx-mask';

@NgModule({
    imports: [CommonModule,
               ParecerRoutingModule,
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
               NgxMaskModule,
             ],
    declarations: [ParecerComponent, TableParecerComponent]
})
export class ParecerModule {}
