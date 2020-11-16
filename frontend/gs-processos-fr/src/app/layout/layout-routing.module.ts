import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LayoutComponent } from './layout.component';

const routes: Routes = [
    {
        path: '',
        component: LayoutComponent,
        children: [
            {
                path: '',
                redirectTo: 'usuarios'
            },
            {
                path: 'usuarios',
                loadChildren: './../usuarios/usuarios.module#UsuariosModule'
            },
            {
                path: 'processos',
                loadChildren: './../processos/processos.module#ProcessosModule'
            },
            {
                path: 'parecer',
                loadChildren: './../parecer/parecer.module#ParecerModule'
            }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class LayoutRoutingModule {}
