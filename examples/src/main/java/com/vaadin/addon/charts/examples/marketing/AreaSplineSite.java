package com.vaadin.addon.charts.examples.marketing;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.examples.AbstractVaadinChartExample;
import com.vaadin.addon.charts.examples.SkipFromDemo;
import com.vaadin.addon.charts.model.*;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
@SkipFromDemo
public class AreaSplineSite extends AbstractVaadinChartExample {

  @Override
  public String getDescription() {
    return "Area-Spline demo used in charts site";
  }

  @Override
  protected Component getChart() {
    Chart chart = new Chart(ChartType.AREASPLINE);

    Configuration conf = chart.getConfiguration();

    conf.setTitle("Monthly supply and demand");
    conf.setSubTitle("Last six months");

    Legend legend = conf.getLegend();
    legend.setLayout(LayoutDirection.VERTICAL);
    legend.setAlign(HorizontalAlign.LEFT);
    legend.setFloating(true);
    legend.setVerticalAlign(VerticalAlign.TOP);
    legend.setX(150);
    legend.setY(100);

    Tooltip tooltip = conf.getTooltip();
    tooltip.setValueSuffix("t");
    tooltip.setShared(true);

    XAxis xAxis = conf.getxAxis();
    xAxis.setCategories("January", "February", "March", "April", "May", "June");

    YAxis yAxis = conf.getyAxis();
    yAxis.setTitle("Metric tons");

    conf.addSeries(new ListSeries("Supply", 35, 28, 45, 60, 80, 74));
    conf.addSeries(new ListSeries("Demand", 29, 11, 50, 63, 65, 61));

    return chart;
  }
}
