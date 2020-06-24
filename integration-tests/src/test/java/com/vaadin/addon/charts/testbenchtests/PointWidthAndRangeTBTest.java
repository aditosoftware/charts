package com.vaadin.addon.charts.testbenchtests;

import com.vaadin.addon.charts.examples.columnandbar.BasicColumnWithPointWidthAndRange;
import org.junit.Ignore;

@Ignore("Overlapping components due to theme change")
public class PointWidthAndRangeTBTest extends AbstractSimpleScreenShotTestBenchTest {

  @Override
  protected String getTestViewName() {
    return BasicColumnWithPointWidthAndRange.class.getSimpleName();
  }

  @Override
  protected String getPackageName() {
    return "columnandbar";
  }
}
