package com.tomkim.me.client;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class SecondView extends ViewImpl implements SecondPresenter.MyView {

	private final Widget widget;
	@UiField Label secondLabel;

	public interface Binder extends UiBinder<Widget, SecondView> {
	}

	@Inject
	public SecondView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}
	
	public Label getSecondLabel() {
		return secondLabel;
	}

	public void setSecondLabel(Label secondLabel) {
		this.secondLabel = secondLabel;
	}


	@Override
	public Widget asWidget() {
		return widget;
	}
}
