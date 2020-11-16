import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { TableParecerComponent } from './tableparecer.component';

describe('TablesComponent', () => {
    let component: TableParecerComponent;
    let fixture: ComponentFixture<TableParecerComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [TableParecerComponent]
        }).compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(TableParecerComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
