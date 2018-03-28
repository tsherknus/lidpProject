    import { BrowserModule } from '@angular/platform-browser';
    import { NgModule } from '@angular/core';
    import { AppComponent } from './app.component';
    import {MdSidenavModule,MdMenuModule} from '@angular/material';
    import {BrowserAnimationsModule} from '@angular/platform-browser/animations'; 
    import {NoopAnimationsModule} from '@angular/platform-browser/animations';
    import 'hammerjs';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    MdSidenavModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    MdMenuModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }