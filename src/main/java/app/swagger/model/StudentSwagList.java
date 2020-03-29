package app.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * StudentSwagList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-28T21:40:49.806+01:00")

public class StudentSwagList   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("passportName")
  private String passportName = null;

  public StudentSwagList id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "12", value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public StudentSwagList name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "nazwaFromList", value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public StudentSwagList passportName(String passportName) {
    this.passportName = passportName;
    return this;
  }

  /**
   * Get passportName
   * @return passportName
  **/
  @ApiModelProperty(example = "paszportFromList", value = "")


  public String getPassportName() {
    return passportName;
  }

  public void setPassportName(String passportName) {
    this.passportName = passportName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudentSwagList studentSwagList = (StudentSwagList) o;
    return Objects.equals(this.id, studentSwagList.id) &&
        Objects.equals(this.name, studentSwagList.name) &&
        Objects.equals(this.passportName, studentSwagList.passportName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, passportName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudentSwagList {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    passportName: ").append(toIndentedString(passportName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

