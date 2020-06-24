package com.vaadin.addon.charts.testbenchtests;

import com.vaadin.addon.charts.examples.pointclickevent.PointClickCoordinatesPieChart;
import org.junit.Ignore;

@Ignore("Absolute coordinates affected by Theme change")
public class PointClickCoordinatesPieChartTBTest extends AbstractPointClickCoordinatesTest {

  @Override
  protected String getTestViewName() {
    return PointClickCoordinatesPieChart.class.getSimpleName();
  }
}
