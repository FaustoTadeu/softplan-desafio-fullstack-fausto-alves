import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogParecerComponent } from './dialog-parecer.component';

describe('DialogParecerComponent', () => {
    let component: DialogParecerComponent;
    let fixture: ComponentFixture<DialogParecerComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [DialogParecerComponent]
        }).compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(DialogParecerComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
