import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProcessosComponent } from './processos.component';

const routes: Routes = [
    {
        path: '',
        component: ProcessosComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ProcessosRoutingModule {}
