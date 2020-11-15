import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogAtribuicoesComponent } from './dialog-atribuicoes.component';

describe('DialogAtribuicoesComponent', () => {
    let component: DialogAtribuicoesComponent;
    let fixture: ComponentFixture<DialogAtribuicoesComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [DialogAtribuicoesComponent]
        }).compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(DialogAtribuicoesComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
