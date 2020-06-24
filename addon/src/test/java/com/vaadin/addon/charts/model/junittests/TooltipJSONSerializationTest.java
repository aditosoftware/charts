package com.vaadin.addon.charts.model.junittests;

import com.vaadin.addon.charts.model.SeriesTooltip;
import com.vaadin.addon.charts.model.Tooltip;
import org.junit.Test;

import static com.vaadin.addon.charts.util.ChartSerialization.toJSON;
import static org.junit.Assert.assertEquals;

/**
 * Tests that {@link Tooltip} and {@link SeriesTooltip} configuration options are serialized
 * correctly as JSON
 */
public class TooltipJSONSerializationTest {

  @Test
  public void toJSON_TooltipWithPointFormatter_serializedAsFunction() {

    Tooltip tooltip = new Tooltip(true);
    tooltip.setPointFormatter("this.y units");

    String json = toJSON(tooltip);

    String expected = "{\"enabled\":true,\"_fn_pointFormatter\":\"this.y units\"}";

    assertEquals(expected, json);
  }

  @Test
  public void toJSON_SeriesTooltipWithPointFormatter_serializedAsFunction() {

    SeriesTooltip tooltip = new SeriesTooltip();
    tooltip.setPointFormatter("this.y units");

    String json = toJSON(tooltip);

    String expected = "{\"_fn_pointFormatter\":\"this.y units\"}";

    assertEquals(expected, json);
  }
}
