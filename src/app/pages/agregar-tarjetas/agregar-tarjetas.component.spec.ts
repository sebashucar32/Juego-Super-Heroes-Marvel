import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarTarjetasComponent } from './agregar-tarjetas.component';

describe('AgregarTarjetasComponent', () => {
  let component: AgregarTarjetasComponent;
  let fixture: ComponentFixture<AgregarTarjetasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgregarTarjetasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AgregarTarjetasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
