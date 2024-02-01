package org.academiadecodigo.nanderthals;

import org.academiadecodigo.simplegraphics.graphics.Color;
import java.util.ArrayList;

public class GridField extends ArrayList<Cell> {
    public GridField(int columns, int rows) {

        initializeGridField(columns, rows);
        drawGrid();
    }

    private void initializeGridField(int columns, int rows) {
        for (int col = 0; col < columns; col++) {

            for (int row = 0; row < rows; row++) {
                int x = col * AppPaint.cellSize + AppPaint.PADDING;
                int y = row * AppPaint.cellSize + AppPaint.PADDING;
                this.add(new Cell(x, y, AppPaint.cellSize, AppPaint.cellSize));
            }
        }
    }

    private void drawGrid() {
        for (Cell c : this) {
            c.draw();
        }
    }

    public void paintCell(int col, int row) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getX() == col && this.get(i).getY() == row) {

                if(!this.get(i).isPainted()) {
                    this.get(i).setPainted(true);
                    this.get(i).setColor(Color.RED);
                    this.get(i).fill();
                    return;
                }
                this.get(i).setPainted(false);
                this.get(i).draw();
            }
        }
    }

    public void clearGrid() {
        for (Cell c : this) {
            c.setPainted(false);
            c.draw();
        }
    }
}