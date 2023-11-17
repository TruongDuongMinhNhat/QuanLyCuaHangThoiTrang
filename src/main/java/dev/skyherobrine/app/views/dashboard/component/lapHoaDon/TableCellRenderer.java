/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.skyherobrine.app.views.dashboard.component.lapHoaDon;
//https://www.youtube.com/watch?v=RMwufjRRHBU&t=442s
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 *
 * @author Virtue Nguyen
 */
public class TableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
       
        CustomButtonChucNang customButtonChucNang = new CustomButtonChucNang();
        if(isSelected==false&& row%2==0){
            customButtonChucNang.setBackground(Color.WHITE);
        }
        customButtonChucNang.setBackground(component.getBackground());
        return customButtonChucNang;
    }
}
