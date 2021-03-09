package person;

/**
 * Билдер для класса Person
 * Содержит логику валидации данных, получаемых для создания выходного объекта
 */
public class PersonBuilder {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender; // Пол правильнее было бы сделать енумом, но ТЗ есть ТЗ

    // Обёртка над исключением, чтобы не дублировать одно и то же сообщение
    private void emptyArgumentException(String field) throws Exception {
        throw new Exception(field + " can't be empty");
    }

    public Person build() throws Exception {
        // Проверки валидности введённых данных
        if (this.firstName == null) { emptyArgumentException("firstName"); }
        if (this.lastName == null) { emptyArgumentException("lastName"); }
        if (this.middleName == null) { this.middleName = ""; } // Допустим, что отчество можно оставлять пустым
        if (this.country == null) { this.country = "гражданин мира"; }
        if (this.address == null) { this.address = "не указан"; }
        if (this.phone == null) { this.phone = "отсутствует"; }
        if (this.age == 0) { emptyArgumentException("age"); }
        if (this.age < 0) { throw new Exception("Age can't be negative"); }
        if (this.age > 130) { throw new Exception("Столько не живут"); }
        if (this.gender == null) { emptyArgumentException("gender"); }

        // Создаём объект и передаём в него нужные свойства
        // Можно было бы сделать через конструктор, но тогда получится очень длинный конструктор,
        // поэтому передаём через сеттеры
        Person person = new Person();
        person.setFirstName(this.firstName);
        person.setLastName(this.lastName);
        person.setMiddleName(this.middleName);
        person.setCountry(this.country);
        person.setAddress(this.address);
        person.setPhone(this.phone);
        person.setAge(this.age);
        person.setGender(this.gender);

        // После завершения формирования выходного объекта обнуляем исходные данные,
        // чтобы они не попали в следующий создаваемый объект в случае повторного использования
        // одного и того же билдера
        this.firstName = null;
        this.lastName = null;
        this.middleName = null;
        this.country = null;
        this.address = null;
        this.phone = null;
        this.age = 0;
        this.gender = null;

        return person;
    }

    public PersonBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public PersonBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public PersonBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }
}
