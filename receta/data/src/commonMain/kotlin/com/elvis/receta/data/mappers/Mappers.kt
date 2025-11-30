package com.elvis.receta.data.mappers

import com.elvis.coreNetwork.model.receta.Categoria
import com.elvis.receta.dominio.model.RecetaCategoria

fun List<Categoria>.aDominioListaRecetaCategorias(): List<RecetaCategoria> = map {
    RecetaCategoria(
        idCategoria = it.idCategory,
        nombreCategoria = it.strCategory,
        descripcion = it.strCategoryDescription,
        imagen = it.strCategoryThumb
    )
}