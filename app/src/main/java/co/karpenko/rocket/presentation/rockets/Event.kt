package co.karpenko.rocket.presentation.rockets

import co.karpenko.rocket.data.mapper.Rocket


sealed class Event {
    object EmptyQuery : Event()
    object ShowDialog : Event()
    data class RocketList(val list: List<Rocket> = emptyList()) : Event()
}
