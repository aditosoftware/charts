package com.vaadin.addon.charts.examples.columnandbar;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.examples.AbstractVaadinChartExample;
import com.vaadin.addon.charts.examples.SkipFromDemo;
import com.vaadin.addon.charts.model.*;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
@SkipFromDemo
public class ColumnWithIncompleteCategories extends AbstractVaadinChartExample {

  @Override
  public String getDescription() {
    return "Basic column with incomplete series";
  }

  @Override
  protected Component getChart() {
    Chart mychart = new Chart();

    Configuration configuration = mychart.getConfiguration();
    configuration.getChart().setType(ChartType.COLUMN);
    configuration.getxAxis().setType(AxisType.CATEGORY);

    // series have points for different categories, no series is complete
    // (#13050)
    configuration.setSeries(
        new DataSeries(new DataSeriesItem("X", 6)),
        new DataSeries(new DataSeriesItem("X", 5)),
        new DataSeries(new DataSeriesItem("Y", 4)),
        new DataSeries(new DataSeriesItem("X", 3)),
        new DataSeries(new DataSeriesItem("X", 2)),
        new DataSeries(new DataSeriesItem("X", 1)));

    return mychart;
  }
}
