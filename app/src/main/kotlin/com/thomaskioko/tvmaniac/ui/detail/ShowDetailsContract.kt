package com.thomaskioko.tvmaniac.ui.detail

import com.thomaskioko.tvmaniac.interactor.EpisodeQuery
import com.thomaskioko.tvmaniac.presentation.model.Episode
import com.thomaskioko.tvmaniac.presentation.model.GenreModel
import com.thomaskioko.tvmaniac.presentation.model.Season
import com.thomaskioko.tvmaniac.presentation.model.TrailerModel
import com.thomaskioko.tvmaniac.presentation.model.TvShow

sealed class ShowDetailAction {
    data class SeasonSelected(
        val query: EpisodeQuery
    ) : ShowDetailAction()
}


data class ShowDetailViewState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val tvShow: TvShow = TvShow.EMPTY_SHOW,
    val tvSeasons: List<Season> = emptyList(),
    val genreList: List<GenreModel> = emptyList(),
    val episodesViewState: EpisodesViewState = EpisodesViewState(),
    val trailerViewState: TrailersViewState = TrailersViewState()
) {
    companion object {
        val Empty = ShowDetailViewState()
    }
}

data class EpisodesViewState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val episodeList: List<Episode> = emptyList(),
) {
    companion object {
        val Empty = EpisodesViewState()
    }
}

data class TrailersViewState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val trailerList: List<TrailerModel> = emptyList(),
) {
    companion object {
        val Empty = TrailersViewState()
    }
}