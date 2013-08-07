package com.tomkim.me.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;
import com.tomkim.me.client.place.NameTokens;

public class FirstPresenter extends
	Presenter<FirstPresenter.MyView, FirstPresenter.MyProxy> {
	
	public interface MyView extends View {
		public Label getFirstLabel();

		public TextBox getFirstBox();

		public Button getFirstButton();
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.first)
	public interface MyProxy extends ProxyPlace<FirstPresenter> {
	}

	@Inject
	public FirstPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy) {
		super(eventBus, view, proxy);
	}

	@Override
	protected void revealInParent() {
		RevealRootContentEvent.fire(this, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}
	
	@Inject
	PlaceManager placeManager;

	@Override
	protected void onReset() {
		super.onReset();
		
		//Setting the Text on the first TextBox
		getView().getFirstBox().setText("Testing this!");
		
		//Navigate to second Presenter
		getView().getFirstButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {			
				PlaceRequest request =new PlaceRequest(NameTokens.second).with("name", getView().getFirstBox().getText());
				placeManager.revealPlace(request);
			}
		});
	}
}
