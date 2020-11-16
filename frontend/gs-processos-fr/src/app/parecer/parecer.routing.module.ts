import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ParecerComponent } from './parecer.component';

const routes: Routes = [
    {
        path: '',
        component: ParecerComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ParecerRoutingModule {}
