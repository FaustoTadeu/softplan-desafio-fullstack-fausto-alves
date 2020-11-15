import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { TableProcessosComponent } from './tableprocessos.component';

const routes: Routes = [
    {
        path: '',
        component: TableProcessosComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class TableProcessosRoutingModule {}
