package ca.uvic.seng330.ex3;

/**
 * Contact details for an individual responsible for a whale sighting modelled by Observation.
 */
public class Reporter {
  private String name;
  private String email;
  private String phone;

  /**
   * Constructor for Reporter requiring all fields.
   *
   * @param name  The reporter's full name.
   * @param email The reporter's email address.
   * @param phone The reporter's full name.
   */
  public Reporter(String name, String email, String phone) {
    setName(name);
    setEmail(email);
    setPhone(phone);
  }

  /**
   * Copy constructor to create a new whale with fields copied from an existing whale.
   *
   * @param reporter The reporter to copy.
   */
  public Reporter(Reporter reporter) {
    if (reporter == null) {
      throw new IllegalArgumentException("Reporter can't be null.");
    }

    setName(reporter.getName());
    setEmail(reporter.getEmail());
    setPhone(reporter.getPhone());
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Name can't be null.");
    }

    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    if (email == null) {
      throw new IllegalArgumentException("Email can't be null.");
    }

    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    if (phone == null) {
      throw new IllegalArgumentException("Phone can't be null.");
    }

    this.phone = phone;
  }
}