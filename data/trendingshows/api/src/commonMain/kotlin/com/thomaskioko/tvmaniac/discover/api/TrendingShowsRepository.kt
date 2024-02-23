package com.thomaskioko.tvmaniac.discover.api

import androidx.paging.PagingData
import com.thomaskioko.tvmaniac.core.networkutil.model.Either
import com.thomaskioko.tvmaniac.core.networkutil.model.Failure
import com.thomaskioko.tvmaniac.shows.api.ShowEntity
import kotlinx.coroutines.flow.Flow

interface TrendingShowsRepository {
  suspend fun fetchTrendingShows(forceRefresh: Boolean = false): List<ShowEntity>

  fun observeTrendingShows(): Flow<Either<Failure, List<ShowEntity>>>

  fun getPagedTrendingShows(): Flow<PagingData<ShowEntity>>
}
