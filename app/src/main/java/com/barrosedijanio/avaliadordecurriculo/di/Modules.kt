package com.barrosedijanio.avaliadordecurriculo.di

import com.barrosedijanio.avaliadordecurriculo.ia.GeminiConnection
import com.barrosedijanio.avaliadordecurriculo.viewmodels.ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modules = module {
    viewModel {
        ViewModel(get())
    }

    single{
        GeminiConnection()
    }
}