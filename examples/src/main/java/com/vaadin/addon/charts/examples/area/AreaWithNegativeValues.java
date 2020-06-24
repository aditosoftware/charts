package com.vaadin.addon.charts.examples.area;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.examples.AbstractVaadinChartExample;
import com.vaadin.addon.charts.model.*;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
public class AreaWithNegativeValues extends AbstractVaadinChartExample {

  @Override
  public String getDescription() {
    return "Area with negative values";
  }

  @Override
  protected Component getChart() {

    Chart chart = new Chart(ChartType.AREA);

    Configuration conf = chart.getConfiguration();

    conf.setTitle(new Title("Area chart with negative values"));

    XAxis xAxis = new XAxis();
    xAxis.setCategories("Apples", "Oranges", "Pears", "Grapes", "Bananas");
    conf.addxAxis(xAxis);

    conf.setCredits(new Credits(false));

    Tooltip tooltip = new Tooltip();
    tooltip.setFormatter("this.series.name +': '+ this.y");
    conf.setTooltip(tooltip);

    conf.addSeries(new ListSeries("John", 5, 3, 4, 7, 2));
    conf.addSeries(new ListSeries("Jane", 2, -2, -3, 2, 1));
    conf.addSeries(new ListSeries("Joe", 3, 4, 4, -2, 5));

    chart.drawChart(conf);

    return chart;
  }
}
