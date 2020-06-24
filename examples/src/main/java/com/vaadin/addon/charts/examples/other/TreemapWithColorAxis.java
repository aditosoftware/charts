package com.vaadin.addon.charts.examples.other;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.examples.AbstractVaadinChartExample;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.ui.Component;

import java.util.ArrayList;
import java.util.List;

public class TreemapWithColorAxis extends AbstractVaadinChartExample {

  @Override
  public String getDescription() {
    return "Tree map with color axis";
  }

  @Override
  protected Component getChart() {
    Chart chart = new Chart(ChartType.TREEMAP);

    ColorAxis colorAxis = new ColorAxis();
    colorAxis.setMinColor(new SolidColor("#FFFFFF"));
    colorAxis.setMaxColor(new SolidColor("#7BB5EF"));
    chart.getConfiguration().addColorAxis(colorAxis);

    PlotOptionsTreemap plotOptions = new PlotOptionsTreemap();
    plotOptions.setLayoutAlgorithm(TreeMapLayoutAlgorithm.SQUARIFIED);

    TreeSeries series = createSeries();

    series.setPlotOptions(plotOptions);

    chart.getConfiguration().addSeries(series);

    chart.getConfiguration().setTitle("Vaadin Charts Treemap");

    return chart;
  }

  private TreeSeries createSeries() {
    List<TreeSeriesItem> items = new ArrayList<TreeSeriesItem>();

    items.add(new TreeSeriesItem("A", 6));
    items.add(new TreeSeriesItem("B", 6));
    items.add(new TreeSeriesItem("C", 4));
    items.add(new TreeSeriesItem("D", 3));
    items.add(new TreeSeriesItem("E", 2));
    items.add(new TreeSeriesItem("F", 2));
    items.add(new TreeSeriesItem("G", 1));

    for (int i = 1; i <= items.size(); i++) {
      items.get(i - 1).setColorValue(i);
    }

    TreeSeries series = new TreeSeries();

    series.setData(items);

    return series;
  }
}
