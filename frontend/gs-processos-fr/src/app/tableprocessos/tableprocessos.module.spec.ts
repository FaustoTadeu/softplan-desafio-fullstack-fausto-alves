import { TableProcessosModule } from './tableprocessos.module';

describe('TableProcessosModule', () => {
    let tableProcessosModule: TableProcessosModule;

    beforeEach(() => {
        tableProcessosModule = new TableProcessosModule();
    });

    it('should create an instance', () => {
        expect(tableProcessosModule).toBeTruthy();
    });
});
