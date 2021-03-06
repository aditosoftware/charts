package com.vaadin.addon.charts.examples.pointclickevent;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.examples.SkipFromDemo;
import com.vaadin.addon.charts.model.*;

@SkipFromDemo
public class PointClickCoordinatesPieChart extends AbstractPointClickCoordinatesChart {

  public PointClickCoordinatesPieChart() {
    super(ChartType.PIE);
  }

  @Override
  protected Chart createChart() {
    Chart chart = super.createChart();

    Configuration conf = chart.getConfiguration();

    conf.setTitle("Browser market shares at a specific website, 2010");

    PlotOptionsPie plotOptions = new PlotOptionsPie();
    plotOptions.setCursor(Cursor.POINTER);
    DataLabels dataLabels = new DataLabels();
    dataLabels.setEnabled(true);
    dataLabels.setFormatter("'<b>'+ this.point.name +'</b>: '+ this.percentage +' %'");
    plotOptions.setDataLabels(dataLabels);
    conf.setPlotOptions(plotOptions);

    chart.drawChart(conf);

    return chart;
  }

  @Override
  public void addSeries(Configuration conf) {
    final DataSeries series = new DataSeries();
    series.add(new DataSeriesItem("Firefox", 45.0));
    series.add(new DataSeriesItem("IE", 26.8));
    DataSeriesItem chrome = new DataSeriesItem("Chrome", 12.8);
    chrome.setSliced(true);
    chrome.setSelected(true);
    series.add(chrome);
    series.add(new DataSeriesItem("Safari", 8.5));
    series.add(new DataSeriesItem("Opera", 6.2));
    series.add(new DataSeriesItem("Others", 0.7));
    conf.addSeries(series);
  }
}
