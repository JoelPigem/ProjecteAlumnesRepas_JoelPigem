package com.joelpigem.projectealumnesrepas_joelpigem

//class DataSource {
object DataSource {
    var alumnes: MutableList<ItemsViewModel> = mutableListOf (
        ItemsViewModel(R.drawable.jordanpole, "Joel Pigem", 19, "2 DAM"),
        ItemsViewModel(R.drawable.jordanpole, "Nadir El Haidouri", 19, "2 DAM"),
        ItemsViewModel(R.drawable.jordanpole, "Raul Luna", 19, "2 DAM"),
        ItemsViewModel(R.drawable.jordanpole, "Alex Ramos", 21, "2 DAM"),
        ItemsViewModel(R.drawable.jordanpole, "Joan Gonzalez", 18, "1 SMX"),
        ItemsViewModel(R.drawable.jordanpole, "Razvan Purice", 21, "1 DAM"),
        ItemsViewModel(R.drawable.jordanpole, "Albert Garcia", 24, "1 SMX"),
        ItemsViewModel(R.drawable.jordanpole, "David Garcia", 22, "2 SMX"),
        ItemsViewModel(R.drawable.jordanpole, "Pep Ramos", 18, "1 DAM"),
        ItemsViewModel(R.drawable.jordanpole, "Roger Garcia", 18, "2 SMX")
    )


    fun carregarAlumnes(): MutableList<ItemsViewModel> {
        return alumnes
    }
}

