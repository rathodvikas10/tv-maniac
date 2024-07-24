//
//  RootView.swift
//  tv-maniac
//
//  Created by Thomas Kioko on 03.12.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import TvManiac

struct RootView: View {
    private let rootComponent: RootComponent
    @StateFlow private var uiState: ThemeState

    init(rootComponent: RootComponent) {
        self.rootComponent = rootComponent
        _uiState = StateFlow(rootComponent.themeState)
    }

    var body: some View {
        StackView(
            stackValue: StateFlow(rootComponent.stack),
            onBack: rootComponent.onBackClicked
        ) { (child: RootComponentChild) in
            switch onEnum(of: child) {
                case .home(let child): 
                    HomeTabView(component: child.component)
                case .showDetails(let child): 
                    ShowDetailView(presenter: child.presenter)
                case .seasonDetails(let child):
                    SeasonDetailsView(presenter: child.presenter)
                case .moreShows(let child):
                    MoreShowsView(presenter: child.presenter)
                case .trailers(_):
                    EmptyView() //TODO:: Add implementation
            }
        }
        .environment(\.colorScheme, uiState.appTheme == .lightTheme ? .light : .dark)
    }
}
