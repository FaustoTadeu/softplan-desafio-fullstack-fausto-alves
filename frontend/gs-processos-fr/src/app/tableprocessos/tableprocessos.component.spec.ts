import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { TableProcessosComponent } from './tableprocessos.component';

describe('TablesComponent', () => {
    let component: TableProcessosComponent;
    let fixture: ComponentFixture<TableProcessosComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [TableProcessosComponent]
        }).compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(TableProcessosComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
