import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from "@angular/common/http";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatButtonModule,
  MatCardModule,
  MatIconModule,
  MatListModule, MatSelectModule,
  MatSidenavModule, MatTableModule,
  MatToolbarModule, MatGridListModule, MatMenuModule, MatInputModule, MatTreeModule, MatDividerModule
} from "@angular/material";
import { LayoutModule } from "@angular/cdk/layout";
import { RouterModule, Routes } from "@angular/router";
import { PessoaPageComponent } from './pessoa-page/pessoa-page.component';
import { DocumentoPageComponent } from './documento-page/documento-page.component';
import { HomePageComponent } from './home-page/home-page.component';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";


const appRoutes: Routes = [
  { path: "", redirectTo: "home", pathMatch: "full" },
  { path: "home", component: HomePageComponent },
  { path: 'pessoas', component: PessoaPageComponent },
  { path: 'pessoa/:id', component: PessoaPageComponent },
  { path: 'documentos', component: DocumentoPageComponent },
  { path: 'documento/:id', component: DocumentoPageComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    PessoaPageComponent,
    DocumentoPageComponent,
    HomePageComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatCardModule,
    MatTableModule,
    MatSelectModule,
    FormsModule,
    ReactiveFormsModule,
    MatGridListModule,
    MatMenuModule,
    MatInputModule,
    MatDividerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
