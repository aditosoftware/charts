package com.vaadin.addon.charts.testbenchtests;

import com.vaadin.addon.charts.examples.pointclickevent.PointClickCoordinatesDonutChart;
import org.junit.Ignore;

@Ignore("Absolute coordinates affected by Theme change")
public class PointClickCoordinatesDonutChartTBTest extends AbstractPointClickCoordinatesTest {

  @Override
  protected String getTestViewName() {
    return PointClickCoordinatesDonutChart.class.getSimpleName();
  }
}
