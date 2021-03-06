import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { MainPageComponent } from './main-page/main-page.component';
import { LoginComponent } from './login/login.component';
import { PharmacyListComponent } from './pharmacy-list/pharmacy-list.component';
import { MedicineListComponent } from './medicine-list/medicine-list.component';

@NgModule({
  declarations: [
    AppComponent,
    SignUpComponent,
    MainPageComponent,
    LoginComponent,
    PharmacyListComponent,
    MedicineListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
