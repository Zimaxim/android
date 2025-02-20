package com.pg.homeworknetwork

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import coil.load
import coil.transform.RoundedCornersTransformation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking


class MovieDetailFragment : Fragment(R.layout.fragment_movie_preview) {
    lateinit var poster: ImageView
    lateinit var originalTitle: TextView
    lateinit var overview: TextView
    lateinit var popularity: TextView
    lateinit var releaseDate: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view) {
            poster = findViewById(R.id.poster)
            originalTitle = findViewById(R.id.originalTitle)
            overview = findViewById(R.id.overview)
            popularity = findViewById(R.id.popularity)
            releaseDate = findViewById(R.id.releaseDate)
        }


        val movieId = arguments?.getString(ARG_ID) ?: "tt9419884"

        runBlocking (Dispatchers.IO){
            val movie: Movie = Api().getMovie(movieId)
            poster.load("${movie.image}") {
                transformations(RoundedCornersTransformation(16f))
            }
            originalTitle.text = movie.fullTitle

            overview.text =  movie.plot
            popularity.text =  " IMDB rating: ${movie.imDbRating}"
            releaseDate.text = "Release Date: ${movie.releaseDate}"
        }



        activity?.onBackPressedDispatcher?.addCallback(this.viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val manager: FragmentManager = parentFragmentManager
                val transaction: FragmentTransaction = manager.beginTransaction()
                transaction.replace(R.id.mainFragment, MovieListFragment())
                transaction.commit()
            }
        })
    }

    companion object {
        const val TAG = "MovieDetailFragment"
        const val ARG_ID = "MovieDetailFragment_Arguments_Movie_Id"
    }
}
