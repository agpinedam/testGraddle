package org.forest.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CalculateSurfaceNeeded200Response
 */

@JsonTypeName("calculateSurfaceNeeded_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-17T16:46:58.216673178+01:00[Europe/Paris]")
public class CalculateSurfaceNeeded200Response {

  private Double surfaceKm2;

  public CalculateSurfaceNeeded200Response surfaceKm2(Double surfaceKm2) {
    this.surfaceKm2 = surfaceKm2;
    return this;
  }

  /**
   * Get surfaceKm2
   * @return surfaceKm2
  */
  
  @Schema(name = "surfaceKm2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("surfaceKm2")
  public Double getSurfaceKm2() {
    return surfaceKm2;
  }

  public void setSurfaceKm2(Double surfaceKm2) {
    this.surfaceKm2 = surfaceKm2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalculateSurfaceNeeded200Response calculateSurfaceNeeded200Response = (CalculateSurfaceNeeded200Response) o;
    return Objects.equals(this.surfaceKm2, calculateSurfaceNeeded200Response.surfaceKm2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(surfaceKm2);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalculateSurfaceNeeded200Response {\n");
    sb.append("    surfaceKm2: ").append(toIndentedString(surfaceKm2)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

