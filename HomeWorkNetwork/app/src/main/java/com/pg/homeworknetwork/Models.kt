package com.pg.homeworknetwork


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//https://imdb-api.com/en/API/MostPopularMovies/k_7ffgs38v
/*
{"items":[
	{"id":"tt9419884",
	"rank":"1",
	"rankUpDown":"+5",
	"title":"Doctor Strange in the Multiverse of Madness",
	"fullTitle":"Doctor Strange in the Multiverse of Madness (2022)",
	"year":"2022",
	"image":"https://imdb-api.com/images/original/MV5BNWM0ZGJlMzMtZmYwMi00NzI3LTgzMzMtNjMzNjliNDRmZmFlXkEyXkFqcGdeQXVyMTM1MTE1NDMx._V1_Ratio0.6716_AL_.jpg",
	"crew":"Sam Raimi (dir.), Benedict Cumberbatch, Elizabeth Olsen",
	"imDbRating":"7.5",
	"imDbRatingCount":"117127"
	},
	
	]
}
*/

//class Movies
@Serializable
data class Movies(
    @SerialName("page")
    val page: Int = 0,
    @SerialName("items")
    val items: List<Movie> = ArrayList()
)

@Serializable
data class Item(
    @SerialName("item")
    val item: Movie
)

// https://imdb-api.com/ru/API/Title/k_7ffgs38v/tt9419884
//class Movie
@Serializable
data class Movie(
    @SerialName("id")
    val id: String,
    @SerialName("rank")
    val rank: String? = null,
    @SerialName("rankUpDown")
    val rankUpDown: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("fullTitle")
    val fullTitle: String? = null,
    @SerialName("year")
    val year: String? = null,
    @SerialName("image")
    val image: String? = null,
    @SerialName("crew")
    val crew: String? = null,
    @SerialName("imDbRating")
    val imDbRating: String? = null,
    @SerialName("imDbRatingCount")
    val imDbRatingCount: String? = null,
    @SerialName("plot")
    val plot: String? = null,
    @SerialName("plotLocal")
    val plotLocal: String? = null,
    @SerialName("releaseDate")
    val releaseDate: String? = null,
)
