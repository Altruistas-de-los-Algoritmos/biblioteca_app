import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { CarouselComponent } from './components/carousel/carousel.component';
import { FormComponent } from './components/form/form.component';


const routers: Routes = [
  { path: 'form', component: FormComponent },
  { path: 'main', component: CarouselComponent },
  { path: '', redirectTo: '/main', pathMatch: 'full' }

]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routers)
  ],
  exports: [RouterModule]
})
export class AppRoutesModule { }
