package com.tomkim.me.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.tomkim.me.client.place.ClientPlaceManager;
import com.tomkim.me.client.FirstPresenter;
import com.tomkim.me.client.FirstView;
import com.tomkim.me.client.place.DefaultPlace;
import com.tomkim.me.client.place.NameTokens;
import com.tomkim.me.client.SecondPresenter;
import com.tomkim.me.client.SecondView;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new DefaultModule(ClientPlaceManager.class));

		bindPresenter(FirstPresenter.class, FirstPresenter.MyView.class,
				FirstView.class, FirstPresenter.MyProxy.class);

		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.first);

		bindPresenter(SecondPresenter.class, SecondPresenter.MyView.class,
				SecondView.class, SecondPresenter.MyProxy.class);
	}
}
