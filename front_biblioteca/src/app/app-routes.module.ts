import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { CarouselComponent } from './components/carousel/carousel.component';


const routers: Routes =[
  { path:'main', component: CarouselComponent },
  { path:'', redirectTo: '/main', pathMatch: 'full'}

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
