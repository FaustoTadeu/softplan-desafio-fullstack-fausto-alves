import { ParecerModule } from './parecer.module';

describe('ParecerModule', () => {
    let parecerModule: ParecerModule;

    beforeEach(() => {
        parecerModule = new ParecerModule();
    });

    it('should create an instance', () => {
        expect(ParecerModule).toBeTruthy();
    });
});
