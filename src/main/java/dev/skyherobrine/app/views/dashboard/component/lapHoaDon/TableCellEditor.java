/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.skyherobrine.app.views.dashboard.component.lapHoaDon;
//https://www.youtube.com/watch?v=RMwufjRRHBU&t=442s
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Virtue Nguyen
 */
public class TableCellEditor extends DefaultCellEditor{
    private TableEvent event;
    public TableCellEditor(TableEvent event){
        super(new JCheckBox());
        this.event=event;

    }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        CustomButtonChucNang customButtonChucNang = new CustomButtonChucNang();
        customButtonChucNang.initEvent(event,row);
        customButtonChucNang.setBackground(table.getSelectionBackground());
        return  customButtonChucNang;
    }
}