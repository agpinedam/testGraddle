package org.forest.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDate;
import org.forest.api.model.Exposure;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * TreeUpdateRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-17T16:46:58.216673178+01:00[Europe/Paris]")
public class TreeUpdateRequest {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate birth;

  private Exposure exposure;

  private Double carbonStorageCapacity;

  public TreeUpdateRequest birth(LocalDate birth) {
    this.birth = birth;
    return this;
  }

  /**
   * Get birth
   * @return birth
  */
  @Valid 
  @Schema(name = "birth", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("birth")
  public LocalDate getBirth() {
    return birth;
  }

  public void setBirth(LocalDate birth) {
    this.birth = birth;
  }

  public TreeUpdateRequest exposure(Exposure exposure) {
    this.exposure = exposure;
    return this;
  }

  /**
   * Get exposure
   * @return exposure
  */
  @Valid 
  @Schema(name = "exposure", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("exposure")
  public Exposure getExposure() {
    return exposure;
  }

  public void setExposure(Exposure exposure) {
    this.exposure = exposure;
  }

  public TreeUpdateRequest carbonStorageCapacity(Double carbonStorageCapacity) {
    this.carbonStorageCapacity = carbonStorageCapacity;
    return this;
  }

  /**
   * Get carbonStorageCapacity
   * @return carbonStorageCapacity
  */
  
  @Schema(name = "carbonStorageCapacity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("carbonStorageCapacity")
  public Double getCarbonStorageCapacity() {
    return carbonStorageCapacity;
  }

  public void setCarbonStorageCapacity(Double carbonStorageCapacity) {
    this.carbonStorageCapacity = carbonStorageCapacity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TreeUpdateRequest treeUpdateRequest = (TreeUpdateRequest) o;
    return Objects.equals(this.birth, treeUpdateRequest.birth) &&
        Objects.equals(this.exposure, treeUpdateRequest.exposure) &&
        Objects.equals(this.carbonStorageCapacity, treeUpdateRequest.carbonStorageCapacity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(birth, exposure, carbonStorageCapacity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TreeUpdateRequest {\n");
    sb.append("    birth: ").append(toIndentedString(birth)).append("\n");
    sb.append("    exposure: ").append(toIndentedString(exposure)).append("\n");
    sb.append("    carbonStorageCapacity: ").append(toIndentedString(carbonStorageCapacity)).append("\n");
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

