package com.elvis.receta.data.mappers

import androidx.compose.runtime.mutableStateOf
import com.elvis.coreNetwork.model.receta.Categoria
import com.elvis.coreNetwork.model.receta.MealDto
import com.elvis.coreNetwork.model.receta.PlatoDto
import com.elvis.coreNetwork.model.receta.PlatoInformacionDto
import com.elvis.coreNetwork.model.receta.PlatosDto
import com.elvis.receta.dominio.model.Ingrediente
import com.elvis.receta.dominio.model.Meal
import com.elvis.receta.dominio.model.Plato
import com.elvis.receta.dominio.model.RecetaCategoria

fun List<Categoria>.aDominioListaRecetaCategorias(): List<RecetaCategoria> = map {
    RecetaCategoria(
        idCategoria = it.idCategory,
        nombreCategoria = it.strCategory,
        descripcion = it.strCategoryDescription,
        imagen = it.strCategoryThumb
    )
}

fun List<PlatoDto>.aDominioListaPlatos(): List<Plato> = map {
    Plato(
        id = it.idMeal,
        nombre = it.strMeal,
        imagen = it.strMealThumb
    )
}
fun Meal.aListaIngredientes(): List<Ingrediente>{
    val ingredientes = mutableListOf<Ingrediente>()

    val pares = listOf(
        strIngredient1 to strMeasure1,
        strIngredient2 to strMeasure2,
        strIngredient3 to strMeasure3,
        strIngredient4 to strMeasure4,
        strIngredient5 to strMeasure5,
        strIngredient6 to strMeasure6,
        strIngredient7 to strMeasure7,
        strIngredient8 to strMeasure8,
        strIngredient9 to strMeasure9,
        strIngredient10 to strMeasure10,
        strIngredient11 to strMeasure11,
        strIngredient12 to strMeasure12,
        strIngredient13 to strMeasure13,
        strIngredient14 to strMeasure14,
        strIngredient15 to strMeasure15,
        strIngredient16 to strMeasure16,
        strIngredient17 to strMeasure17,
        strIngredient18 to strMeasure18,
        strIngredient19 to strMeasure19,
        strIngredient20 to strMeasure20,
    )
    pares.forEach { (ingrediente,medida)->
        if (!ingrediente.isNullOrBlank()){
            ingredientes.add(
                Ingrediente(
                    ingrediente = ingrediente.trim(),
                    medida = medida.trim().let { it.ifBlank { "" } }
                )
            )
        }
    }
    return ingredientes

}
fun List<MealDto>.aDominioListaPlatoInformacion(): List<Meal> = map {
    Meal(
        idMeal = it.idMeal,
        strMeal = it.strMeal,
        strMealAlternate = it.strMealAlternate,
        strCategory = it.strCategory,
        strArea = it.strArea,
        strInstructions = it.strInstructions,
        strMealThumb = it.strMealThumb,
        strTags = it.strTags,
        strYoutube = it.strYoutube,
        strImageSource = it.strImageSource,
        strIngredient1 = it.strIngredient1,
        strIngredient2 = it.strIngredient2,
        strIngredient3 = it.strIngredient3,
        strIngredient4 = it.strIngredient4,
        strIngredient5 = it.strIngredient5,
        strIngredient6 = it.strIngredient6,
        strIngredient7 = it.strIngredient7,
        strIngredient8 = it.strIngredient8,
        strIngredient9 = it.strIngredient9,
        strIngredient10 = it.strIngredient10,
        strIngredient11 = it.strIngredient11,
        strIngredient12 = it.strIngredient12,
        strIngredient13 = it.strIngredient13,
        strIngredient14 = it.strIngredient14,
        strIngredient15 = it.strIngredient15,
        strIngredient16 = it.strIngredient16,
        strIngredient17 = it.strIngredient17,
        strIngredient18 = it.strIngredient18,
        strIngredient19 = it.strIngredient19,
        strIngredient20 = it.strIngredient20,
        strMeasure1 = it.strMeasure1,
        strMeasure2 = it.strMeasure2,
        strMeasure3 = it.strMeasure3,
        strMeasure4 = it.strMeasure4,
        strMeasure5 = it.strMeasure5,
        strMeasure6 = it.strMeasure6,
        strMeasure7 = it.strMeasure7,
        strMeasure8 = it.strMeasure8,
        strMeasure9 = it.strMeasure9,
        strMeasure10 = it.strMeasure10,
        strMeasure11 = it.strMeasure11,
        strMeasure12 = it.strMeasure12,
        strMeasure13 = it.strMeasure13,
        strMeasure14 = it.strMeasure14,
        strMeasure15 = it.strMeasure15,
        strMeasure16 = it.strMeasure16,
        strMeasure17 = it.strMeasure17,
        strMeasure18 = it.strMeasure18,
        strMeasure19 = it.strMeasure19,
        strMeasure20 = it.strMeasure20,
        strSource = it.strSource,
        strCreativeCommonsConfirmed = it.strCreativeCommonsConfirmed,
        dateModified = it.dateModified
    )
}