package org.example.mvc;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class View extends JFrame{
    private Controller controller;
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton addButton;
    private JButton editButton;
    private JButton removeButton;
    private JPanel chartPanel;

    public View(Controller controller) {
        this.controller = controller;

        setTitle("MVC Application");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание таблицы
        tableModel = new DefaultTableModel(new Object[]{"X", "Y"}, 0);
        table = new JTable(tableModel);

        // Создание кнопок
        addButton = new JButton("Ввод");
        editButton = new JButton("Редактировать");
        removeButton = new JButton("Удалить");

        // Создание панели для графика
        chartPanel = new JPanel();
        chartPanel.setLayout(new BorderLayout());

        // Добавление компонентов на форму
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(removeButton);
        add(buttonPanel, BorderLayout.SOUTH);
        add(chartPanel, BorderLayout.EAST);
        updateTableAndChart();

        // Обработка событий кнопок
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x = Double.parseDouble(JOptionPane.showInputDialog("Enter X value:"));
                    controller.addData(x);
                    updateTableAndChart();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number for X.");
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    try {
                        double newX = Double.parseDouble(JOptionPane.showInputDialog("Enter new X value:"));
                        controller.editData(selectedRow, newX);
                        updateTableAndChart();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number for X.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to edit.");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    controller.removeData(selectedRow);
                    updateTableAndChart();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to remove.");
                }
            }
        });
    }

    // Метод для обновления таблицы и графика
    private void updateTableAndChart() {
        updateTable();
        updateChart();
    }

    // Метод для обновления таблицы
    private void updateTable() {
        tableModel.setRowCount(0);
        List<Double> xValues = controller.getXValues();
        List<Double> yValues = controller.getYValues();
        for (int i = 0; i < xValues.size(); i++) {
            tableModel.addRow(new Object[]{xValues.get(i), yValues.get(i)});
        }
    }

    // Метод для обновления графика
    private void updateChart() {
        XYSeries series = new XYSeries("Data");
        List<Double> xValues = controller.getXValues();
        List<Double> yValues = controller.getYValues();
        for (int i = 0; i < xValues.size(); i++) {
            series.add(xValues.get(i), yValues.get(i));
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Function Plot",
                "X",
                "Y",
                dataset
        );

        chartPanel.removeAll();
        chartPanel.add(new ChartPanel(chart), BorderLayout.CENTER);
        chartPanel.revalidate();
        chartPanel.repaint();
    }


}