package com.github.C204_242_DJSM.Assignment_1.jds30.session;

public class ClientLoginResponce {
	public enum SuccessState {
		SUCCESS,
		PASSWORDINCORRECT,
		USERNAMEINCORRECT
	}
	
	private ClientSession _session = null;
	private SuccessState _state = null;
	
	public ClientLoginResponce(ClientSession clientSession, SuccessState successState) {
		this._session = clientSession;
		this._state = successState;
	}
	
	public ClientSession getSession() {
		return _session;
	}
	
	public SuccessState getState() {
		return _state;
	}
	
	public Boolean isSuccess() {
		return _state == SuccessState.SUCCESS;
	}
}
