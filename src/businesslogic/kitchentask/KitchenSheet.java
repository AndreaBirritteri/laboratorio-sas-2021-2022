package businesslogic.kitchentask;

import businesslogic.event.ServiceInfo;
import businesslogic.menu.Menu;
import businesslogic.procedure.Procedure;
import businesslogic.procedure.Recipe;
import businesslogic.shift.Shift;
import businesslogic.user.Cook;
import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class KitchenSheet {
    private String title;
    private ServiceInfo service;
    private List<KitchenTask> kitchenTasks;


    public KitchenSheet(String title, ServiceInfo service) {
        this.title = title;
        this.service = service;
        this.kitchenTasks = new ArrayList<>();

        restoreOriginalTasks();
    }

    public KitchenTask addKitchenTask(Procedure procedure) {
        KitchenTask kitchenTask = new KitchenTask(procedure);
        kitchenTasks.add(kitchenTask);
        return kitchenTask;
    }

    public void deleteKitchenTask(KitchenTask kitchenTask) {
        kitchenTasks.remove(kitchenTask);
    }

    public void restoreOriginalTasks() {
        Menu menu = service.getMenu();
        ArrayList<Recipe> recipes = menu.getRecipes();
        List<Procedure> procedures = Procedure.retrieveProceduresToPrepare(recipes);

        for (Procedure proc : procedures) {
            KitchenTask task = new KitchenTask(proc);
            kitchenTasks.add(task);
        }
    }

    public void moveTask(KitchenTask kitchenTask, int position) {
        throw new NotImplementedException("not implemented");
    }

    public void assignTask(KitchenTask kitchenTask, Shift shift, Cook cook, int minutes, int quantity) {
        throw new NotImplementedException("not implemented");
    }

    public void specifyCompletedTask(KitchenTask kitchenTask) {
        throw new NotImplementedException("not implemented");
    }
}
