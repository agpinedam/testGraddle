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
 * CalculateForestAbsorption200Response
 */

@JsonTypeName("calculateForestAbsorption_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-17T16:46:58.216673178+01:00[Europe/Paris]")
public class CalculateForestAbsorption200Response {

  private Double absorptionKgPerYear;

  public CalculateForestAbsorption200Response absorptionKgPerYear(Double absorptionKgPerYear) {
    this.absorptionKgPerYear = absorptionKgPerYear;
    return this;
  }

  /**
   * Get absorptionKgPerYear
   * @return absorptionKgPerYear
  */
  
  @Schema(name = "absorptionKgPerYear", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("absorptionKgPerYear")
  public Double getAbsorptionKgPerYear() {
    return absorptionKgPerYear;
  }

  public void setAbsorptionKgPerYear(Double absorptionKgPerYear) {
    this.absorptionKgPerYear = absorptionKgPerYear;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalculateForestAbsorption200Response calculateForestAbsorption200Response = (CalculateForestAbsorption200Response) o;
    return Objects.equals(this.absorptionKgPerYear, calculateForestAbsorption200Response.absorptionKgPerYear);
  }

  @Override
  public int hashCode() {
    return Objects.hash(absorptionKgPerYear);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalculateForestAbsorption200Response {\n");
    sb.append("    absorptionKgPerYear: ").append(toIndentedString(absorptionKgPerYear)).append("\n");
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

