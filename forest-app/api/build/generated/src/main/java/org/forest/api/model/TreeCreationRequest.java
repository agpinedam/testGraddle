package org.forest.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDate;
import org.forest.api.model.Exposure;
import org.forest.api.model.Species;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * TreeCreationRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-17T16:46:58.216673178+01:00[Europe/Paris]")
public class TreeCreationRequest {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate birth;

  private Exposure exposure;

  private Species species;

  private Double carbonStorageCapacity;

  public TreeCreationRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TreeCreationRequest(LocalDate birth, Exposure exposure, Species species, Double carbonStorageCapacity) {
    this.birth = birth;
    this.exposure = exposure;
    this.species = species;
    this.carbonStorageCapacity = carbonStorageCapacity;
  }

  public TreeCreationRequest birth(LocalDate birth) {
    this.birth = birth;
    return this;
  }

  /**
   * Get birth
   * @return birth
  */
  @NotNull @Valid 
  @Schema(name = "birth", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("birth")
  public LocalDate getBirth() {
    return birth;
  }

  public void setBirth(LocalDate birth) {
    this.birth = birth;
  }

  public TreeCreationRequest exposure(Exposure exposure) {
    this.exposure = exposure;
    return this;
  }

  /**
   * Get exposure
   * @return exposure
  */
  @NotNull @Valid 
  @Schema(name = "exposure", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("exposure")
  public Exposure getExposure() {
    return exposure;
  }

  public void setExposure(Exposure exposure) {
    this.exposure = exposure;
  }

  public TreeCreationRequest species(Species species) {
    this.species = species;
    return this;
  }

  /**
   * Get species
   * @return species
  */
  @NotNull @Valid 
  @Schema(name = "species", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("species")
  public Species getSpecies() {
    return species;
  }

  public void setSpecies(Species species) {
    this.species = species;
  }

  public TreeCreationRequest carbonStorageCapacity(Double carbonStorageCapacity) {
    this.carbonStorageCapacity = carbonStorageCapacity;
    return this;
  }

  /**
   * Get carbonStorageCapacity
   * @return carbonStorageCapacity
  */
  @NotNull 
  @Schema(name = "carbonStorageCapacity", requiredMode = Schema.RequiredMode.REQUIRED)
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
    TreeCreationRequest treeCreationRequest = (TreeCreationRequest) o;
    return Objects.equals(this.birth, treeCreationRequest.birth) &&
        Objects.equals(this.exposure, treeCreationRequest.exposure) &&
        Objects.equals(this.species, treeCreationRequest.species) &&
        Objects.equals(this.carbonStorageCapacity, treeCreationRequest.carbonStorageCapacity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(birth, exposure, species, carbonStorageCapacity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TreeCreationRequest {\n");
    sb.append("    birth: ").append(toIndentedString(birth)).append("\n");
    sb.append("    exposure: ").append(toIndentedString(exposure)).append("\n");
    sb.append("    species: ").append(toIndentedString(species)).append("\n");
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

