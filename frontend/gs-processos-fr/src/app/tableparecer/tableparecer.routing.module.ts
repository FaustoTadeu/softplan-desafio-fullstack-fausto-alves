import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { TableParecerComponent } from './tableparecer.component';

const routes: Routes = [
    {
        path: '',
        component: TableParecerComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class TableParecerRoutingModule {}
