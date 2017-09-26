package org.launchcode.models.forms;

import javax.validation.constraints.NotNull;

public class addMenuItemForm {
    @NotNull
    private Menu menu{}

    @NotNull
    private Iterable<Cheese> cheeses{

        @NotNull
        private int menuId{}

        private int menuId(int thisId){ return thisId;}

        @NotNull
        private int cheeseId{}

        private int cheeseId(int setId){
        }
    }
}
