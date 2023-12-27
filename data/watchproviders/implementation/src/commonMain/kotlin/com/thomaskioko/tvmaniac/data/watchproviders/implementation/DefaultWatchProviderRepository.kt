package com.thomaskioko.tvmaniac.data.watchproviders.implementation

import com.thomaskioko.tvmaniac.core.db.WatchProviders
import com.thomaskioko.tvmaniac.data.watchproviders.api.WatchProviderRepository
import com.thomaskioko.tvmaniac.resourcemanager.api.RequestManagerRepository
import com.thomaskioko.tvmaniac.util.extensions.mapResult
import com.thomaskioko.tvmaniac.util.model.AppCoroutineDispatchers
import com.thomaskioko.tvmaniac.util.model.Either
import com.thomaskioko.tvmaniac.util.model.Failure
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import me.tatarka.inject.annotations.Inject
import org.mobilenativefoundation.store.store5.StoreReadRequest
import org.mobilenativefoundation.store.store5.impl.extensions.get
import kotlin.time.Duration.Companion.days

@Inject
class DefaultWatchProviderRepository(
    private val store: WatchProvidersStore,
    private val requestManagerRepository: RequestManagerRepository,
    private val dispatcher: AppCoroutineDispatchers,
) : WatchProviderRepository {
    override suspend fun fetchWatchProviders(id: Long): List<WatchProviders> =
        store.get(id)

    override fun observeWatchProviders(id: Long): Flow<Either<Failure, List<WatchProviders>>> =
        store.stream(
            StoreReadRequest.cached(
                key = id,
                refresh = requestManagerRepository.isRequestExpired(
                    entityId = id,
                    requestType = "WATCH_PROVIDERS",
                    threshold = 3.days,
                ),
            ),
        )
            .mapResult()
            .flowOn(dispatcher.io)
}