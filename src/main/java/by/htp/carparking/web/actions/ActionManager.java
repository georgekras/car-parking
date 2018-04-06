package by.htp.carparking.web.actions;

import java.util.HashMap;
import java.util.Map;
import static by.htp.carparking.web.util.WebConstantDeclaration.*;

import by.htp.carparking.web.actions.impl.CarCreateAction;
import by.htp.carparking.web.actions.impl.CarDeleteAction;
import by.htp.carparking.web.actions.impl.CarUpdateAction;
import by.htp.carparking.web.actions.impl.CarViewAction;

public final class ActionManager {

	private static Map<String, BaseAction> actions;

	static {
		actions = new HashMap<>();
		actions.put(ACTION_NAME_VIEW_CAR_LIST, new CarViewAction());
		actions.put(ACTION_NAME_CREATE_CAR,new CarCreateAction());
		actions.put(ACTION_NAME_UPDATE_CAR,new CarUpdateAction());
		actions.put(ACTION_NAME_DELETE_CAR,new CarDeleteAction());
	}
	
	private ActionManager() {
		
	}

	public static BaseAction getAction(String action) {
		return actions.get(action);
	}
}
