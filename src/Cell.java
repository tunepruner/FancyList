import com.sun.codemodel.internal.JForEach;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import netscape.javascript.JSUtil;

import java.awt.*;
import java.util.Observable;

public abstract class Cell {
    HBox hBox;
    VBox vBox;
    Label label;
    boolean isInListArea = false;
    Point currentPosition = new Point();
    SimpleDoubleProperty followableX;
    SimpleDoubleProperty followableY;

    //TODO I still need to set this up.
    private CellState cellState;
//    Property property = new Simple



    public abstract void displayCell(ListArea listArea, String string, Grid grid);


    public void handleDragAndDrop(ListArea listArea, HBox hBox, VBox vBox, int currentDraggedFromInt, Cell cell) {
        /*Default implementation goes here.
         * Store (lbl.getText) in String lblTxt "".
         * Store ObservableList.indexOf(lblTxt) in int lblTxtIndex.
         * ObservarbleList.remove(lblTxtIndex)
         * Drag handler moves hBox, calls getIndexOfXY,
         * and adds empty string back into ObservableList.
         * At drop, it removes that empty string and adds lblTxt.
         *
         * */
    }

    public abstract void cueReposition(ListArea listArea, HBox hBox, VBox vBox, Cell cell);
    public abstract void executeReposition(ListArea listArea, HBox hBox, VBox vBox, Cell cell);
    public void displayAllCells(ListArea listArea) {
        ObservableList list = listArea.getList();
        listArea.setGrid(new PlanGrid(listArea));
        for (int i = 0; i < listArea.getList().size(); i++) {
            String string = (String) listArea.getList().get(i);
            listArea.getListFromFile().handleSyncToFile(listArea);
            displayCell(listArea, string, listArea.getGrid());
        }
    }

}

