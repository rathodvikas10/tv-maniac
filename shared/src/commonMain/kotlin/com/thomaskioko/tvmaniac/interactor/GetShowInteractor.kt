package com.thomaskioko.tvmaniac.interactor

import com.thomaskioko.tvmaniac.core.usecase.FlowInteractor
import com.thomaskioko.tvmaniac.datasource.mapper.toTvShow
import com.thomaskioko.tvmaniac.datasource.repository.tvshow.TvShowsRepository
import com.thomaskioko.tvmaniac.presentation.model.TvShow
import com.thomaskioko.tvmaniac.util.DomainResultState
import com.thomaskioko.tvmaniac.util.DomainResultState.Companion.error
import com.thomaskioko.tvmaniac.util.DomainResultState.Companion.success
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class GetShowInteractor constructor(
    private val repository: TvShowsRepository,
) : FlowInteractor<Int, DomainResultState<TvShow>>() {

    override fun run(params: Int): Flow<DomainResultState<TvShow>> = repository.observeShow(params)
        .map { it.toTvShow() }
        .map { success(it) }
        .catch { emit(error(it)) }
}
