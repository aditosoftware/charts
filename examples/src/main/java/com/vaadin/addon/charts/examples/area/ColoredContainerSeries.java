package com.vaadin.addon.charts.examples.area;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.examples.AbstractVaadinChartExample;
import com.vaadin.addon.charts.examples.SkipFromDemo;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.Component;

import java.util.ArrayList;
import java.util.Collection;

@SkipFromDemo
public class ColoredContainerSeries extends AbstractVaadinChartExample {

  protected class Test {
    private int number;
    private String name;

    public Test(final int number, final String name) {
      this.number = number;
      this.name = name;
    }

    public Integer getNumber() {
      return number;
    }

    public String getName() {
      return name;
    }
  }

  @Override
  protected Component getChart() {
    Chart chart = new Chart(ChartType.AREA);

    Configuration conf = chart.getConfiguration();

    conf.setTitle(new Title("Colored ContainerDataSeries"));

    conf.addxAxis(new XAxis());
    YAxis yAxis = new YAxis();
    yAxis.setTitle("Numbers");
    conf.addyAxis(yAxis);

    Collection<Test> col = new ArrayList<>();
    col.add(new Test(10, "TEN"));
    col.add(new Test(11, "ELEVEN"));
    col.add(new Test(12, "TWELVE"));
    DataProvider<Test, ?> ds = new ListDataProvider<>(col);
    DataProviderSeries<Test> chartDS = new DataProviderSeries<>(ds);

    chartDS.setName("Test Series");
    chartDS.setY(Test::getNumber);
    chartDS.setPointName(Test::getName);

    PlotOptionsArea plotOptions = new PlotOptionsArea();
    plotOptions.setFillColor(SolidColor.CORNFLOWERBLUE);
    plotOptions.setColor(SolidColor.GOLDENROD);
    chartDS.setPlotOptions(plotOptions);

    // conf.setPlotOptions(plotOptions);

    conf.setSeries(chartDS);

    chart.drawChart(conf);

    return chart;
  }
}
