package com.thomaskioko.tvmaniac.presentation.watchlist

import com.thomaskioko.tvmaniac.core.db.LibraryShows
import com.thomaskioko.tvmaniac.core.db.SearchWatchlist
import com.thomaskioko.tvmaniac.presentation.watchlist.model.WatchlistItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

fun List<LibraryShows>.entityToLibraryShowList(): PersistentList<WatchlistItem> {
  return this.map {
    WatchlistItem(
        tmdbId = it.id.id,
        title = it.name,
        posterImageUrl = it.poster_path,
        year = it.first_air_date,
        status = it.status,
      )
    }
    .toPersistentList()
}

fun List<SearchWatchlist>.entityToLibraryShowList(): ImmutableList<WatchlistItem> {
  return this.map {
    WatchlistItem(
      tmdbId = it.id.id,
      title = it.name,
      posterImageUrl = it.poster_path,
      year = it.first_air_date,
      status = it.status,
    )
  }
    .toPersistentList()
}
