package businesslogic;

import businesslogic.event.EventManager;
import businesslogic.kitchentask.KitchenTaskManager;
import businesslogic.menu.MenuManager;
import businesslogic.procedure.ProcedureManager;
import businesslogic.shift.Shift;
import businesslogic.shift.ShiftManager;
import businesslogic.user.UserManager;
import persistence.KitchenTaskEventPersistence;
import persistence.MenuPersistence;

public class CatERing {
    private static CatERing singleInstance;

    public static CatERing getInstance() {
        if (singleInstance == null) {
            singleInstance = new CatERing();
        }
        return singleInstance;
    }

    private MenuManager menuMgr;
    private ProcedureManager recipeMgr;
    private UserManager userMgr;
    private EventManager eventMgr;
    private KitchenTaskManager kitchenTaskMgr;
    private ShiftManager shiftMgr;

    private MenuPersistence menuPersistence;
    private KitchenTaskEventPersistence kitchenTaskPersistence;

    private CatERing() {
        menuMgr = new MenuManager();
        recipeMgr = new ProcedureManager();
        userMgr = new UserManager();
        eventMgr = new EventManager();
        kitchenTaskMgr = new KitchenTaskManager();
        shiftMgr = new ShiftManager();

        menuPersistence = new MenuPersistence();
        menuMgr.addEventReceiver(menuPersistence);

        kitchenTaskPersistence = new KitchenTaskEventPersistence();
        kitchenTaskMgr.addEventReceiver(kitchenTaskPersistence);
    }


    public MenuManager getMenuManager() {
        return menuMgr;
    }

    public ProcedureManager getRecipeManager() {
        return recipeMgr;
    }

    public UserManager getUserManager() {
        return userMgr;
    }

    public EventManager getEventManager() { return eventMgr; }

    public KitchenTaskManager getKitchenTaskManager() {
        return kitchenTaskMgr;
    }

    public ShiftManager getShiftManager() {
        return shiftMgr;
    }
}
