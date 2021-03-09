package person;

/**
 * Класс Person и его билдер я разнёс по разным классам.
 * Мне кажется, что это уместнее с точки зрения принципа SRP:
 * если в бизнес-логике требуется испоьзовать класс Person,
 * незачем тащить туда ненужный рудимент в виде не используемого билдера.
 */
public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    Person() {} // Если подразумевается создание только через билдер, конструктор делаем доступным в пределах пакета

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public void setCountry(String country) { this.country = country; }
    public void setAddress(String address) { this.address = address; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAge(int age) { this.age = age; }
    public void setGender(String gender) { this.gender = gender; }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person(firstName=").append(firstName)
                .append(", lastName=").append(lastName)
                .append(", middleName=").append(middleName)
                .append(", country=").append(country)
                .append(", address=").append(address)
                .append(", phone=").append(phone)
                .append(", age=").append(age)
                .append(", gender=").append(gender).append(")");
        return sb.toString();
    }
}
