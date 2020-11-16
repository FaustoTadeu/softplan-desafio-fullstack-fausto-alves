import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { UsuariosDTO } from 'src/models/usuarios.dto';
import { UsuariosService } from 'src/services/usuarios.service';
import { AuthService } from 'src/services/auth.service';
import { Router } from '@angular/router';
import { PerfilDTO } from 'src/models/perfil.dto';
import { PasswordDTO } from 'src/models/password.dto';
import { MatDialog } from '@angular/material';
import { DialogOverviewComponent } from '../dialog-overview/dialog-overview.component';

@Component({
    selector: 'app-parecer',
    templateUrl: './parecer.component.html',
    styleUrls: ['./parecer.component.scss']
})
export class ParecerComponent implements OnInit {

    nvUsuario: PasswordDTO;
    idUsuarios = new FormControl();
    cpfUsuarios = new FormControl();
    nomeUsuarios = new FormControl();
    emailUsuarios = new FormControl();
    statusUsuarios = new FormControl();
    perfilUsuarios = new FormControl();
    editar: boolean;

    listaPerfil: PerfilDTO[] = [{ 'codPerfil': 1 , 'nomePerfil': 'Administrador'},
                                { 'codPerfil': 2, 'nomePerfil': 'Triador'},
                                { 'codPerfil': 3, 'nomePerfil': 'Finalizador'}];

    position = new FormControl(this.listaPerfil[0]);

    constructor( private usuariosService: UsuariosService,
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

    inserirEditarUsuario() {
        if (this.cpfUsuarios.value == null || this.cpfUsuarios.value === undefined
            || this.nomeUsuarios.value == null || this.nomeUsuarios.value === undefined
            || this.emailUsuarios.value == null || this.emailUsuarios.value === undefined
            || this.perfilUsuarios.value == null || this.perfilUsuarios.value === -1
            ) {
                this.openDialog('400', 'Dados Inválidos', 'Todos os campos são obrigatórios. Preencha todos.');
            return false;
        }
        // tslint:disable-next-line:max-line-length
        const usuarioObject = this.montaUsuario(this.idUsuarios.value, this.emailUsuarios.value, this.nomeUsuarios.value, this.cpfUsuarios.value, this.statusUsuarios.value, this.perfilUsuarios.value);
        this.usuariosService.inserirEditarUsuario(usuarioObject).subscribe(response => {
            this.nvUsuario = response;
            this.editar = false;
            this.idUsuarios.setValue(null);
            this.cpfUsuarios.setValue(null);
            this.nomeUsuarios.setValue(null);
            this.emailUsuarios.setValue(null);
            this.statusUsuarios.setValue('');
            this.perfilUsuarios.setValue(-1);
            // tslint:disable-next-line:max-line-length
            this.openDialog('200', 'Usuário criado/editado com sucesso',
                            'Login: ' + this.nvUsuario.loginUsuario + '<br /> Senha: ' + this.nvUsuario.pass);
        },
        error => {});
    }

    montaUsuario(idUsuarios: number, emailUsuarios: string,
        nomeUsuarios: string, cpfUsuarios: string, statusUsuarios: string, perfilUsuarios: string) {
        const usuario = new UsuariosDTO();
        usuario.idUsuarios = idUsuarios;
        usuario.emailUsuarios = emailUsuarios;
        usuario.nomeUsuarios = nomeUsuarios;
        usuario.cpfUsuarios = cpfUsuarios;
        usuario.statusUsuarios = statusUsuarios != null ? statusUsuarios : 'A';
        usuario.perfil = perfilUsuarios;
        return usuario;
    }

   povoarFormulario(event) {
       this.idUsuarios.setValue(event.idUsuarios);
       this.cpfUsuarios.setValue(event.cpfUsuarios);
       this.nomeUsuarios.setValue(event.nomeUsuarios);
       this.emailUsuarios.setValue(event.emailUsuarios);
       this.statusUsuarios.setValue('A');
       this.perfilUsuarios.setValue(event.perfil);
       this.editar = true;
   }

   limparFormulario() {
        this.idUsuarios.setValue(null);
        this.cpfUsuarios.setValue(null);
        this.nomeUsuarios.setValue(null);
        this.emailUsuarios.setValue(null);
        this.statusUsuarios.setValue('');
        this.perfilUsuarios.setValue(-1);
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
